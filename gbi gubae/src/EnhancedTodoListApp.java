import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import com.toedter.calendar.JDateChooser;
import java.util.Date;

// ... (previous imports remain unchanged)

public class EnhancedTodoListApp extends JFrame {

    private DefaultListModel<Task> todoListModel;
    private JList<Task> todoList;
    private JTextField taskInput;
    private JTextArea descriptionArea;
    private JButton addButton;
    private JDateChooser dateChooser;
    private keeptoo.KGradientPanel kGradientPanel1;

    public EnhancedTodoListApp() {
        // Set up the main frame
        setUndecorated(true); // Remove window decorations
        setSize(1200, 590);
        setLocation(250, 255);

        kGradientPanel1 = new keeptoo.KGradientPanel();
        kGradientPanel1.setkStartColor(new Color(0, 204, 255)); // Start color
        kGradientPanel1.setkEndColor(new Color(102, 0, 255));

        // Create the to-do list model and list
        todoListModel = new DefaultListModel<>();
        todoList = new JList<>(todoListModel);

        // Create a scroll pane for the list
        JScrollPane listScrollPane = new JScrollPane(todoList);

        // Create the input fields and add a button
        taskInput = new JTextField();
        descriptionArea = new JTextArea(20, 20); // Set rows and columns for the description area
        addButton = new JButton("add task");

        // Set font for labels and input fields to bold
        Font boldFont = new Font("A0 Tesfa Unicode", Font.BOLD, 14);
        taskInput.setFont(boldFont);
        descriptionArea.setFont(boldFont);

        // Set font for button
        Font buttonFont = new Font(addButton.getFont().getName(), Font.BOLD, 18);
        addButton.setFont(buttonFont);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        // Create a panel to hold the input fields and button
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Label for Task
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(5, 5, 5, 5); // Add some spacing
        JLabel taskLabel = new JLabel("Task:");
        taskLabel.setFont(boldFont);
        inputPanel.add(taskLabel, gbc);

        // Task Input Field
        gbc.gridx = 1;
        gbc.weightx = 1.0; // Allow the input field to expand horizontally
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(taskInput, gbc);

        // Label for Description
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0; // Reset weight
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setFont(boldFont);
        inputPanel.add(descriptionLabel, gbc);

        // Description Text Area
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1.0; // Allow the text area to expand vertically
        gbc.fill = GridBagConstraints.BOTH;
        inputPanel.add(new JScrollPane(descriptionArea), gbc);

        // Button
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weighty = 0.0; // Reset weight
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(addButton, gbc);

        // Create a calendar
        dateChooser = new JDateChooser();
        dateChooser.addPropertyChangeListener("date", evt -> updateListForSelectedDate());

        // Set the dateChooser to the current date
        dateChooser.setDate(new Date());

        // Load tasks for the current date
        updateListForSelectedDate();

        // Create a panel to hold the list and input panel
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.add(listScrollPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.EAST);

        // Create a split pane for the calendar and the main panel
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, dateChooser, mainPanel);
        splitPane.setDividerLocation(200);

        // Add a list selection listener to show the description when a task is selected
        todoList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Task selectedTask = todoList.getSelectedValue();
                    if (selectedTask != null) {
                        descriptionArea.setText(selectedTask.getDescription());
                    }
                }
            }
        });

        // Add the split pane to the frame
        add(splitPane);

        // Set the frame to be visible
        setVisible(true);

        // Load tasks for the current date
        updateListForSelectedDate();
    }

    private void addTask() {
        String taskTitle = taskInput.getText().trim();
        String description = descriptionArea.getText().trim();
        Font boldFont = new Font("A0 Tesfa Unicode", Font.BOLD, 14);

        if (!taskTitle.isEmpty()) {
            LocalDate selectedDate = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String formattedDate = selectedDate.format(DateTimeFormatter.ISO_DATE);

            Task task = new Task(taskTitle, description, formattedDate);
            saveTaskToDatabase(task);
            todoListModel.addElement(task);

            // Set the added task to bold
            todoList.setFont(todoList.getFont().deriveFont(Font.BOLD));

            taskInput.setText("");
            descriptionArea.setText("");
        }
    }

    private void updateListForSelectedDate() {
        if (dateChooser != null) {
            todoListModel.clear();
            LocalDate selectedDate = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String formattedDate = selectedDate.format(DateTimeFormatter.ISO_DATE);
            loadTasksFromDatabase(formattedDate);
        }
    }

    private void saveTaskToDatabase(Task task) {
        String url = "jdbc:mysql://localhost:3306/gbigubae";
        String username = "root";
        String password = "6789";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO schedule (date, title, description) VALUES (?, ?, ?)")) {

            preparedStatement.setString(1, task.getDate());
            preparedStatement.setString(2, task.getTitle());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadTasksFromDatabase(String date) {
        String url = "jdbc:mysql://localhost:3306/gbigubae";
        String username = "root";
        String password = "6789";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT title, description FROM schedule WHERE date = ?")) {

            preparedStatement.setString(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String taskTitle = resultSet.getString("title");
                String description = resultSet.getString("description");
                todoListModel.addElement(new Task(taskTitle, description, date));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Initialize the database
        initializeDatabase();

        // Run the application
        SwingUtilities.invokeLater(EnhancedTodoListApp::new);
    }

    private static void initializeDatabase() {
        String url = "jdbc:mysql://localhost:3306/gbigubae";
        String username = "root";
        String password = "6789";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS schedule (id INT AUTO_INCREMENT PRIMARY KEY, date TEXT, title TEXT, description TEXT)")) {

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static class Task {
        private String title;
        private String description;
        private String date;

        public Task(String title, String description, String date) {
            this.title = title;
            this.description = description;
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getDate() {
            return date;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
