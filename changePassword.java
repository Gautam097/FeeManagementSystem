
import javax.swing.JOptionPane;
import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class changePassword extends javax.swing.JFrame {

    /**
     * Creates new form changePassword
     */
    public changePassword() {
        initComponents();
        setSize(600,700);
        setTitle("FORGET PASSWORD");
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_lbl = new javax.swing.JLabel();
        oldp_lbl = new javax.swing.JLabel();
        confirmp_lbl = new javax.swing.JLabel();
        username_lbl = new javax.swing.JLabel();
        user_tf = new javax.swing.JTextField();
        oldpass_pf = new javax.swing.JPasswordField();
        confirmpass_pf = new javax.swing.JPasswordField();
        back_btn = new javax.swing.JButton();
        update_btn1 = new javax.swing.JButton();
        newp_lbl1 = new javax.swing.JLabel();
        newpass_pf = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        title_lbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title_lbl.setText("CHANGE PASSWORD ");
        getContentPane().add(title_lbl);
        title_lbl.setBounds(120, 0, 250, 50);

        oldp_lbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        oldp_lbl.setText("OLD PASSWORD");
        getContentPane().add(oldp_lbl);
        oldp_lbl.setBounds(30, 170, 180, 30);

        confirmp_lbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        confirmp_lbl.setText("CONFIRM PASSWORD :");
        getContentPane().add(confirmp_lbl);
        confirmp_lbl.setBounds(20, 310, 210, 30);

        username_lbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        username_lbl.setText("USERNAME :");
        getContentPane().add(username_lbl);
        username_lbl.setBounds(30, 100, 140, 30);

        user_tf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(user_tf);
        user_tf.setBounds(280, 90, 190, 40);

        oldpass_pf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(oldpass_pf);
        oldpass_pf.setBounds(280, 160, 190, 40);

        confirmpass_pf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmpass_pf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmpass_pfActionPerformed(evt);
            }
        });
        getContentPane().add(confirmpass_pf);
        confirmpass_pf.setBounds(290, 300, 190, 40);

        back_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back_btn.setText("BACK LOGIN");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        getContentPane().add(back_btn);
        back_btn.setBounds(290, 390, 150, 50);

        update_btn1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        update_btn1.setText("UPDATE PASSWORD");
        update_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(update_btn1);
        update_btn1.setBounds(20, 390, 220, 50);

        newp_lbl1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        newp_lbl1.setText("NEW PASSWORD :");
        getContentPane().add(newp_lbl1);
        newp_lbl1.setBounds(30, 240, 180, 30);

        newpass_pf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(newpass_pf);
        newpass_pf.setBounds(290, 230, 190, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
        login obj = new login();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void update_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btn1ActionPerformed
        // TODO add your handling code here:
        String user = user_tf.getText();
        String oldp = oldpass_pf.getText();
        String newp = newpass_pf.getText();
        String confirmp = confirmpass_pf.getText();

        if(user.equals("")||oldp.equals("")||newp.equals("")||confirmp.equals(""))
        {
            JOptionPane.showMessageDialog(this,"All field are mandatory");
        }
        else{
            try
            {
                ResultSet rs = DBLoader.executeSQL("select * from register where UserName='"+user+"'and Password ='"+oldp+"' ");
                if(rs.next()){
                    if(newp.equals(confirmp)){
                        rs.updateString("Password",confirmp);

                        rs.updateRow();
                        JOptionPane.showMessageDialog(this,"Your Password changed successfully");
                        user_tf.setText("");
                        oldpass_pf.setText("");
                        newpass_pf.setText("");
                        confirmpass_pf.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"New password & confirm password are not Matched");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this,"UserName and password are Not Matched");
                }

            }
            catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,ex);
            }
        }
    }//GEN-LAST:event_update_btn1ActionPerformed

    private void confirmpass_pfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmpass_pfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpass_pfActionPerformed

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
            java.util.logging.Logger.getLogger(changePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel confirmp_lbl;
    private javax.swing.JPasswordField confirmpass_pf;
    private javax.swing.JLabel newp_lbl1;
    private javax.swing.JPasswordField newpass_pf;
    private javax.swing.JLabel oldp_lbl;
    private javax.swing.JPasswordField oldpass_pf;
    private javax.swing.JLabel title_lbl;
    private javax.swing.JButton update_btn1;
    private javax.swing.JTextField user_tf;
    private javax.swing.JLabel username_lbl;
    // End of variables declaration//GEN-END:variables
}
