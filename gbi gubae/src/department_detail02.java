





import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class department_detail02 extends javax.swing.JFrame {

    /**
     * Creates new form department_detail
     */
    public department_detail02() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        dicriptionbutton02 = new javax.swing.JButton();
        menberbutton02 = new javax.swing.JButton();
        reportbutton02 = new javax.swing.JButton();
        agendabutton02 = new javax.swing.JButton();
        detaiexit = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dicriptionbutton02.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 18)); // NOI18N
        dicriptionbutton02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/discription_1.png"))); // NOI18N
        dicriptionbutton02.setText("ገለጻ");
        dicriptionbutton02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dicriptionbutton02ActionPerformed(evt);
            }
        });

        menberbutton02.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 18)); // NOI18N
        menberbutton02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-members-64.png"))); // NOI18N
        menberbutton02.setText("አባላት");
        menberbutton02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menberbutton02ActionPerformed(evt);
            }
        });

        reportbutton02.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 18)); // NOI18N
        reportbutton02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report_department.png"))); // NOI18N
        reportbutton02.setText("ሪፖርት");
        reportbutton02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportbutton02ActionPerformed(evt);
            }
        });

        agendabutton02.setFont(new java.awt.Font("A0 Tesfa Unicode", 1, 18)); // NOI18N
        agendabutton02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-agenda-64.png"))); // NOI18N
        agendabutton02.setText("አጀንዳ");
        agendabutton02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendabutton02ActionPerformed(evt);
            }
        });

        detaiexit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        detaiexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.png"))); // NOI18N
        detaiexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detaiexitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(detaiexit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(dicriptionbutton02)
                .addGap(240, 240, 240)
                .addComponent(menberbutton02)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                .addComponent(reportbutton02)
                .addGap(305, 305, 305)
                .addComponent(agendabutton02)
                .addGap(162, 162, 162))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agendabutton02)
                    .addComponent(reportbutton02, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menberbutton02)
                    .addComponent(dicriptionbutton02))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 587, Short.MAX_VALUE)
                .addComponent(detaiexit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dicriptionbutton02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dicriptionbutton02ActionPerformed
              // TODO add your handling code here:
              new hisabenanibret().setVisible(true);
             
             
    }//GEN-LAST:event_dicriptionbutton02ActionPerformed

    private void detaiexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detaiexitActionPerformed
                          setVisible(false);
                          new homepage().setVisible(true);// TODO add your handling code here:
                          new departments().setVisible(true);
    }//GEN-LAST:event_detaiexitActionPerformed

    private void menberbutton02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menberbutton02ActionPerformed
        // TODO add your handling code here
        new regstration02().setVisible(true);
        detaiexit.setVisible(true);
        
    }//GEN-LAST:event_menberbutton02ActionPerformed

    private void reportbutton02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportbutton02ActionPerformed
        // TODO add your handling code here:
        new report02().setVisible(true);
    }//GEN-LAST:event_reportbutton02ActionPerformed

    private void agendabutton02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendabutton02ActionPerformed
        // TODO add your handling code here:
        new Agenda2().setVisible(true);
    }//GEN-LAST:event_agendabutton02ActionPerformed

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
            java.util.logging.Logger.getLogger(department_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(department_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(department_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(department_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new department_detail02().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agendabutton02;
    private javax.swing.JButton detaiexit;
    private javax.swing.JButton dicriptionbutton02;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton menberbutton02;
    private javax.swing.JButton reportbutton02;
    // End of variables declaration//GEN-END:variables
}