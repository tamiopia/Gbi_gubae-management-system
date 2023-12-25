
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class Agenda5 extends javax.swing.JFrame {

    /**
     * Creates new form Agenda
     */
    public Agenda5() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
      // Method to update the agenda table based on the selected department
private void updateAgendaTable(String department) throws SQLException {
    // Query the database for agendas based on department
    ResultSet resultSet = DatabaseHandler.getAgendasByDepartment(department);

    // Update the JTable with the retrieved data
  if (resultSet != null) {
     //jTable1.setModel(buildTableModel(resultSet));
}
}

      private void clearForm() {
        jDateChooser1.setDate(null);
        jComboBox1.setSelectedIndex(0);
        jTextField1.setText("");
        jTextArea1.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Agenda_submit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 36)); // NOI18N
        jLabel1.setText("የ አጀንዳ ማስገቢያ ቅጽ");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 462, -1));

        jLabel2.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 18)); // NOI18N
        jLabel2.setText("ቀን ይምረጡ");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 100, -1));
        kGradientPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 669, 32));

        jLabel3.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 18)); // NOI18N
        jLabel3.setText("ርእስ");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 84, -1));

        jLabel4.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 18)); // NOI18N
        jLabel4.setText("ይዘት");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 70, 24));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "01", "03", "04", "05", "06", "07", "08", "09", "10", "11" }));
        kGradientPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 669, 30));

        jLabel5.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 18)); // NOI18N
        jLabel5.setText("ኪፍላት");
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 70, 20));

        jTextField1.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 18)); // NOI18N
        kGradientPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 669, 40));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        kGradientPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 669, 305));

        Agenda_submit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Agenda_submit.setText("submit");
        Agenda_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agenda_submitActionPerformed(evt);
            }
        });
        kGradientPanel1.add(Agenda_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 672, -1, 33));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 660, 100, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 65, Short.MAX_VALUE)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1685, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Agenda_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agenda_submitActionPerformed
        // TODO add your handling code here
        
        try{
        Date selectedDate = jDateChooser1.getDate();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String formattedDate = sdf.format(selectedDate);

    // Get other input values
    String department = (String) jComboBox1.getSelectedItem();
    String title = jTextField1.getText();
    String content = jTextArea1.getText();

    // Insert agenda into the database
    DatabaseHandler.insertAgenda(formattedDate, department, title, content);
       JOptionPane.showMessageDialog(this, " agenda submited succesfully");
    // Clear the form after submission
    clearForm();

    // Update the agenda table
 updateAgendaTable(department);
       //dateAgendaTable(selectedDepartment);
    } catch (SQLException ex) {
        // Handle the exception appropriately, such as showing an error message
      //JOptionPane.showMessageDialog(this, "Error updating agenda table: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
     // ex.printStackTrace(); // This is for debugging, replace it with proper error handling
    }
    }//GEN-LAST:event_Agenda_submitActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new department_detail05().setVisible(true);
        //new member().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agenda_submit;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables

    // Build a TableModel from ResultSet
private static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
    ResultSetMetaData metaData = rs.getMetaData();

    // Names of columns
    Vector<String> columnNames = new Vector<>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // Data of the table
    Vector<Vector<Object>> data = new Vector<>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);
}

}
