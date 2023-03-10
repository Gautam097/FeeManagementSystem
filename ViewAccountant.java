
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class ViewAccountant extends javax.swing.JFrame {
    int ans;
    ArrayList <accountant> ac;
    mytablemodel tm;
    JTable jt;
    JScrollPane jsp;

    /**
     * Creates new form ViewAccountant
     */
    public ViewAccountant() {
        initComponents();
        
        ac = new ArrayList<>();
        ac.add(new accountant("abc","1234","gautam@1234","896563214"));
        tm = new mytablemodel();
        jt = new JTable();
        jsp = new JScrollPane(jt);
        jt.setModel(tm);
        jsp.setBounds(100,100,800,600);
        add(jsp);
        
        
        setSize(1000,800);
        setTitle("View Accountant");
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    void showAccountant() {
        ac.clear();
        try {
            ResultSet rs = DBLoader.executeSQL("select * from admin");
            while (rs.next()) {
                String name = rs.getString("admin");
                String pass = rs.getString("password");
                String email = rs.getString("email");
                String contact = rs.getString("contact");
                ac.add(new accountant(name, pass,email,contact));
            }
            tm.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //inner class
    class mytablemodel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return ac.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }
        @Override
        public String getColumnName(int j){
            String c[] = {" NAME "," PASSWORD ","CONTACT NO","EMAIL"};
             return c[j];
        }

        @Override
        public Object getValueAt(int i, int j) {
            accountant at = ac.get(i);
            if(j==0)
                return at.name;
            else if(j==1){
                return at.pass;
            }
            else if( j==3){
                return at.email;
            }
            else
                return at.contact;
            
        }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refresh_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        refresh_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        refresh_btn.setText("REFRESH");
        refresh_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btnActionPerformed(evt);
            }
        });
        getContentPane().add(refresh_btn);
        refresh_btn.setBounds(400, 720, 130, 30);

        delete_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        delete_btn.setText("DELETE");
        delete_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        getContentPane().add(delete_btn);
        delete_btn.setBounds(690, 720, 110, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
        // TODO add your handling code here:
           try
         {
             ResultSet rs = DBLoader.executeSQL("select * from admin");
             
             ac.clear();
             
             
             String name;
             String pass;
             String email;
             String contact;
             
             while(rs.next())
             {
                 name = rs.getString("admin");
                 pass = rs.getString("password");
                 email = rs.getString("email");
                 contact = rs.getString("contact");
                 
                 
                 ac.add(new accountant(name,pass,email,contact));
             }
             
             // refresh jtable
             tm.fireTableDataChanged();
         }
         catch(Exception ex)
         {
             ex.printStackTrace();
         }
    }//GEN-LAST:event_refresh_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        // TODO add your handling code here:
          ans = jt.getSelectedRow();
           if(ans== -1){
               JOptionPane.showMessageDialog(this,"Please select correct from Table");
           }
           else{
//               String cat= ct.get(ans).categoryName;
        try
       {
           String acc= ac.get(ans).name;
           
           ResultSet rs = DBLoader.executeSQL("select * from admin where admin='"+acc+"'");
           
           if(rs.next())
           {
               rs.deleteRow();
               JOptionPane.showMessageDialog(this,"Accountant deleted succesfully");
           }
           else
           {
               JOptionPane.showMessageDialog(this,"cannnot delete,Accountant does not exist");
               
           }
           
           
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           JOptionPane.showMessageDialog(this,ex);
       }
               
           }
    }//GEN-LAST:event_delete_btnActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAccountant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAccountant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAccountant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAccountant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAccountant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton refresh_btn;
    // End of variables declaration//GEN-END:variables
}
