import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import keeptoo.KGradientPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ajendaa extends javax.swing.JFrame {

    private JTextField titleField;
    private JTextArea descriptionArea;
    private JButton addAjendaButton;
    private JFileChooser fileChooser;
    private JDateChooser dateChooser;
    private JPanel displayPanel;
    private KGradientPanel mainPanel;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/gbigubae";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "6789";

    public ajendaa() {
        initComponents();
    }

    private void initComponents() {
        titleField = new JTextField();
        descriptionArea = new JTextArea();
        addAjendaButton = new JButton();
        fileChooser = new JFileChooser();
        dateChooser = new JDateChooser();
        displayPanel = new JPanel();
        mainPanel = new KGradientPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addAjendaButton.setText("Add Ajenda");
        addAjendaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAjendaActionPerformed(evt);
            }
        });

        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        JScrollPane displayScrollPane = new JScrollPane(displayPanel);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(displayScrollPane, BorderLayout.CENTER);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addAjendaButton))
                    .addComponent(descriptionArea, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fileChooser, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(titleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addAjendaButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descriptionArea, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(fileChooser, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void addAjendaActionPerformed(java.awt.event.ActionEvent evt) {
        String title = titleField.getText();
        String description = descriptionArea.getText();
        LocalDate selectedDate = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String formattedDate = selectedDate.format(DateTimeFormatter.ISO_DATE);

        // Extract file name
        String fileName = fileChooser.getSelectedFile().getName();

        addAgendaToDatabase(formattedDate, title, description, fileName);

        displayAgendasForSelectedDate();
    }

    private void displayAgendasForSelectedDate() {
        if (dateChooser != null) {
            displayPanel.removeAll();
            LocalDate selectedDate = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String formattedDate = selectedDate.format(DateTimeFormatter.ISO_DATE);
            loadAgendasFromDatabase(formattedDate);
        }
    }

    private void loadAgendasFromDatabase(String date) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, title, description, pdf_name, pdf_path FROM agendas WHERE date = ?")) {

            preparedStatement.setString(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int agendaId = resultSet.getInt("id");
                String agendaTitle = resultSet.getString("title");
                String description = resultSet.getString("description");

                JPanel agendaPanel = new JPanel();
                agendaPanel.setLayout(new BorderLayout());
                agendaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                JLabel titleLabel = new JLabel("Title: " + agendaTitle);
                titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

                JTextArea descriptionLabel = new JTextArea("Description: " + description);
                descriptionLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
                descriptionLabel.setEditable(false);
                descriptionLabel.setLineWrap(true);
                descriptionLabel.setWrapStyleWord(true);

                JButton openPdfButton = new JButton("Open PDF");
                openPdfButton.setFont(new Font("Tahoma", Font.BOLD, 18));
                openPdfButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        openPdfFile(agendaId, agendaTitle);
                    }
                });

                agendaPanel.add(titleLabel, BorderLayout.NORTH);
                agendaPanel.add(descriptionLabel, BorderLayout.CENTER);
                agendaPanel.add(openPdfButton, BorderLayout.SOUTH);

                displayPanel.add(agendaPanel);
            }

            displayPanel.revalidate();
            displayPanel.repaint();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void openPdfFile(int agendaId, String agendaTitle) {
    String pdfPath = getPdfPathFromDatabase(agendaId);

    if (pdfPath != null) {
        if (Desktop.isDesktopSupported() && Files.exists(Paths.get(pdfPath))) {
            try {
                // Open the PDF file directly using the retrieved path
                Desktop.getDesktop().open(new File(pdfPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "PDF file not found for agenda: " + agendaTitle);
        }
    } else {
        JOptionPane.showMessageDialog(this, "PDF path not found for agenda: " + agendaTitle);
    }
}


    private String getPdfPathFromDatabase(int agendaId) {
        String pdfPath = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT pdf_path FROM agendas WHERE id = ?")) {

            preparedStatement.setInt(1, agendaId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                pdfPath = resultSet.getString("pdf_path");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pdfPath;
    }

    private void addAgendaToDatabase(String date, String title, String description, String fileName) {
        String insertSQL = "INSERT INTO agendas (date, title, description, pdf_name, pdf_path) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, date);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, fileName);

            String pdfPath = savePdfFile(fileName);  // Use file name for path

            preparedStatement.setString(5, pdfPath);

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int agendaId = generatedKeys.getInt(1);
                // Update PDF path in the database with the full path
                updatePdfPathInDatabase(agendaId, savePdfFile(pdfPath));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   private String savePdfFile(String fileName) {
    String pdfPath = "C:\\Users\\hp\\Documents\\NetBeansProjects\\gbi gubae\\" + fileName;
    System.out.println("Savedddd PDF Path: " + pdfPath);

    // Rest of the code...
    return pdfPath;
}


    private void updatePdfPathInDatabase(int agendaId, String pdfPath) {
        String updateSQL = "UPDATE agendas SET pdf_path = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            preparedStatement.setString(1, pdfPath);
            preparedStatement.setInt(2, agendaId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ajendaa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ajendaa().setVisible(true);
            }
        });
    }

    private javax.swing.JButton addajenda;
    private javax.swing.JPanel diplaypanel;
    private javax.swing.JPanel insertpanel;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private keeptoo.KGradientPanel kGradientPanel1;
}
