/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author hp
 */
public class report08 extends javax.swing.JFrame {

    /**
     * Creates new form report
     */
    public report08() {
        initComponents();
    }
private String contentFromDatabase;
private String department;
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
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(250, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1200, 682));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 36)); // NOI18N
        jLabel1.setText("የ አባላት ጉዳይ ክፍል አፈጻጸም መረጃ");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 600, 42));
        kGradientPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 177, 34));

        jLabel2.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 14)); // NOI18N
        jLabel2.setText("ቀን ይምረጡ");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 109, -1));

        jButton1.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 18)); // NOI18N
        jButton1.setText("አፈጻጸም አሳይ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 190, -1));

        Jtable2.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 14)); // NOI18N
        Jtable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "content"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Jtable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jtable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Jtable2);

        kGradientPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 220, 360, 130));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("content");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, -1, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        kGradientPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 601, 362));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                Date selectedDate = jDateChooser1.getDate();
               department="08";
        // Convert the selected date to java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
        String ddate=sqlDate.toString();
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/gbigubae","root","6789");
                PreparedStatement pst;
                
                String sql="SELECT  title, content FROM agendas WHERE submitted_date=? AND department=?";
                pst=connection.prepareStatement(sql);
                 pst.setString(1,ddate);
                 pst.setString(2,department);
            
                ResultSet rs=pst.executeQuery();
                if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(this, "No reports available for the selected date.", "No Data", JOptionPane.INFORMATION_MESSAGE);
            } else {
                while(rs.next()){
            //String dep=rs.getString("department");
            String tit=rs.getString("title");
            String cont=rs.getString("content");
             //String contentFromDatabase[] ={cont};
            //System.out.println(dep);
            //System.out.println(tit);
                    //System.out.println(contentFromDatabase[1]);
            String tabledata[]={tit,cont};
            DefaultTableModel tb=(DefaultTableModel)Jtable2.getModel();
            tb.setRowCount(0);
            tb.addRow(tabledata);
                }
            
            
            }
            } catch (SQLException ex) {
                Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
            }
            PreparedStatement pst;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Jtable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jtable2MouseClicked
        // TODO add your handling code here:
       int selected = Jtable2.getSelectedRow();
    DefaultTableModel model = (DefaultTableModel) Jtable2.getModel();
    
    // Check if a row is selected
    if (selected != -1) {
        // Get the content from the selected row
        String content = model.getValueAt(selected, 1).toString();
        jTextArea1.setText(content);
    }
    }//GEN-LAST:event_Jtable2MouseClicked

    /**
     * @param args the command line arguments
     */
    // Method to update the table based on the selected date
    
    // Method to get reports from the database based on the date
    
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
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new report08().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtable2;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
