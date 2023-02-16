
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class updateFeeDetails extends javax.swing.JFrame {

    /**
     * Creates new form AddFees
     */
    public updateFeeDetails() {
        initComponents();
        setSize(2021,1036);
        setTitle("ADD FEES");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        courseload();
        displayCashFirst();
        int r = getReceiptNo();
        receiptNo_tf.setText(Integer.toString(r));
        
        setRecords();
    }
    public void setRecords(){
        try{
             
            ResultSet rs = DBLoader.executeSQL("select * from feedetails order by receiptNo desc limit 1");
            
        while(rs.next()){
             receiptNo_tf.setText(rs.getString("receiptNo"));
             cb_mode.setSelectedItem(rs.getString("payment_mode"));
             
             ddno_tf.setText(rs.getString("ddno"));
             chequeno_tf.setText(rs.getString("chequeNo"));
             bankname_tf.setText(rs.getString("bankname"));
             received_tf.setText(rs.getString("studentName"));
             dateChooser.setDate(rs.getDate("date"));
             gst_lbl.setText(rs.getString("gstno"));
             rollno_tf.setText(rs.getString("Rollno"));
             year_tf1.setText(rs.getString("year1"));
             year_tf2.setText(rs.getString("year2"));
             courseName_tf.setText(rs.getString("courseName"));
             amount_tf.setText(rs.getString("amount"));
             cgst_tf.setText(rs.getString("cgst"));
             sgst_tf.setText(rs.getString("sgst"));
             totalAmount_tf.setText(rs.getString("totalAmount"));
             totalInWords_tf.setText(rs.getString("total_in_words"));
             remarks_textarea.setText(rs.getString("remarks")); 
        }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
       
    }
    void courseload(){
        try{
            ResultSet rs = DBLoader.executeSQL("select * from course");
            
        while(rs.next()){
            String coursename= rs.getString("cname");
             cb_course.addItem(coursename);            
        }
        }
        catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    public int getReceiptNo(){
        int r=0;
        try{
             
            ResultSet rs = DBLoader.executeSQL("select max(receiptNo) from feedetails");
            
        while(rs.next()){
             r = rs.getInt(1);
             
        }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return r+1;
    }
    
    public void displayCashFirst(){
        ddno_lbl.setVisible(false);
        chequeno_lbl.setVisible(false);
        ddno_tf.setVisible(false);
        chequeno_tf.setVisible(false);
        bankname_lbl.setVisible(false);
        bankname_tf.setVisible(false); 
    }
    
    public boolean validation(){
//        if(ddno_tf.getText().equals("")){
//            JOptionPane.showConfirmDialog(this,"please Enter DD number");
//            return false;
//        }
//        if(chequeno_tf.getText().equals("")){
//            JOptionPane.showConfirmDialog(this,"please Enter cheque number");
//            return false;
//        }
        if(dateChooser.getDate().equals("")){
            JOptionPane.showConfirmDialog(this,"choose Date First!!!!");
            return false;
        }
        if(received_tf.getText().equals("")){
             JOptionPane.showMessageDialog(this,"where you received from ????");
            return false;
        }
        if(rollno_tf.getText().equals("")||rollno_tf.getText().matches("[0-9]+")== false){
             JOptionPane.showMessageDialog(this,"please fill roll number");
            return false;
        }
        if(year_tf1.getText().equals("")||(year_tf1.getText().matches("[0-9]+")== false)){
             JOptionPane.showMessageDialog(this,"please Fill course start year & in number!!!");
            return false;
        }
        if(year_tf2.getText().equals("")||(year_tf2.getText().matches("[0-9]+")== false)){
             JOptionPane.showMessageDialog(this,"please Fill course last year & in number!!!");
            return false;
        }
        if(courseName_tf.getText().equals("")){
             JOptionPane.showMessageDialog(this,"please Enter course Name");
            return false;
        }
        if(amount_tf.getText().equals("")){
             JOptionPane.showMessageDialog(this,"please Fill Amount in Number");
            return false;
        }
       
        if(cb_mode.getSelectedItem().toString().equalsIgnoreCase("Cheque")){
            if(chequeno_tf.getText().equals("")||chequeno_tf.getText().matches("[0-9]+")== false){
                JOptionPane.showMessageDialog(this,"please Enter checque number");
                return false;
            }
            if(bankname_tf.getText().equals("")){
                JOptionPane.showMessageDialog(this,"please Enter Bank Name");
                return false;
            }   
        }
        if(cb_mode.getSelectedItem().toString().equalsIgnoreCase("dd")){
            if(ddno_tf.getText().equals("")||ddno_tf.getText().matches("[0-9]+")== false){
                JOptionPane.showMessageDialog(this,"please Enter DD number");
                return false;
            }
            if(bankname_tf.getText().equals("")){
                JOptionPane.showMessageDialog(this,"please Enter Bank Name");
                return false;
            }   
        }
        if(cb_mode.getSelectedItem().toString().equalsIgnoreCase("Card")){
           
            if(bankname_tf.getText().equals("")){
                JOptionPane.showMessageDialog(this,"please Enter Bank Name");
                return false;
            }   
        }
    return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidepanel = new javax.swing.JPanel();
        courselist_btn = new javax.swing.JButton();
        viewall_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        logout_btn = new javax.swing.JButton();
        home_btn = new javax.swing.JButton();
        searchRecord_btn = new javax.swing.JButton();
        parentpanel = new javax.swing.JPanel();
        mode_lbl = new javax.swing.JLabel();
        ddno_lbl = new javax.swing.JLabel();
        chequeno_lbl = new javax.swing.JLabel();
        gst_lbl = new javax.swing.JLabel();
        receipt_lbl = new javax.swing.JLabel();
        bankname_lbl = new javax.swing.JLabel();
        date_lbl = new javax.swing.JLabel();
        gstno_lbl = new javax.swing.JLabel();
        receivedfrom_lbl = new javax.swing.JLabel();
        ddno_tf = new javax.swing.JTextField();
        chequeno_tf = new javax.swing.JTextField();
        bankname_tf = new javax.swing.JTextField();
        received_tf = new javax.swing.JTextField();
        year_tf2 = new javax.swing.JTextField();
        receiptNo_tf = new javax.swing.JTextField();
        cb_mode = new javax.swing.JComboBox<>();
        minus_lbl = new javax.swing.JLabel();
        year_tf1 = new javax.swing.JTextField();
        year_lbl = new javax.swing.JLabel();
        rollno_lbl = new javax.swing.JLabel();
        course_lbl = new javax.swing.JLabel();
        cb_course = new javax.swing.JComboBox<>();
        separator_lbl = new javax.swing.JLabel();
        amount_lbl = new javax.swing.JLabel();
        srno_lbl = new javax.swing.JLabel();
        head_lbl = new javax.swing.JLabel();
        amount_tf = new javax.swing.JTextField();
        sgst_tf = new javax.swing.JTextField();
        totalAmount_tf = new javax.swing.JTextField();
        totalInWords_tf = new javax.swing.JTextField();
        cgst_tf = new javax.swing.JTextField();
        courseName_tf = new javax.swing.JTextField();
        totalinwords_lbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        sgst_lbl = new javax.swing.JLabel();
        cgst_lbl = new javax.swing.JLabel();
        remarks_lbl = new javax.swing.JLabel();
        receiverSignature_lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarks_textarea = new javax.swing.JTextArea();
        print_btn = new javax.swing.JButton();
        rollno_tf = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        sidepanel.setBackground(new java.awt.Color(0, 153, 153));
        sidepanel.setLayout(null);

        courselist_btn.setBackground(new java.awt.Color(0, 204, 204));
        courselist_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        courselist_btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\NetBeansProjects\\Fee_management\\src\\feeimages\\list.png")); // NOI18N
        courselist_btn.setText("COURSE LIST");
        courselist_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        courselist_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sidepanel.add(courselist_btn);
        courselist_btn.setBounds(120, 300, 250, 80);

        viewall_btn.setBackground(new java.awt.Color(0, 204, 204));
        viewall_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        viewall_btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\NetBeansProjects\\Fee_management\\src\\feeimages\\view all record.png")); // NOI18N
        viewall_btn.setText("VIEW ALL RECORDS");
        viewall_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewall_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sidepanel.add(viewall_btn);
        viewall_btn.setBounds(120, 430, 250, 80);

        back_btn.setBackground(new java.awt.Color(0, 204, 204));
        back_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back_btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\NetBeansProjects\\Fee_management\\src\\feeimages\\back-button.png")); // NOI18N
        back_btn.setText("BACK");
        back_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        back_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        sidepanel.add(back_btn);
        back_btn.setBounds(120, 570, 250, 70);

        logout_btn.setBackground(new java.awt.Color(0, 204, 204));
        logout_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logout_btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\NetBeansProjects\\Fee_management\\src\\feeimages\\logout.png")); // NOI18N
        logout_btn.setText("LOG OUT");
        logout_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logout_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });
        sidepanel.add(logout_btn);
        logout_btn.setBounds(120, 690, 250, 70);

        home_btn.setBackground(new java.awt.Color(0, 204, 204));
        home_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        home_btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\NetBeansProjects\\Fee_management\\src\\feeimages\\home.png")); // NOI18N
        home_btn.setText("HOME");
        home_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        home_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sidepanel.add(home_btn);
        home_btn.setBounds(120, 60, 250, 80);

        searchRecord_btn.setBackground(new java.awt.Color(0, 204, 204));
        searchRecord_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchRecord_btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\NetBeansProjects\\Fee_management\\src\\feeimages\\search2.png")); // NOI18N
        searchRecord_btn.setText("SEARCH RECORD");
        searchRecord_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchRecord_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sidepanel.add(searchRecord_btn);
        searchRecord_btn.setBounds(120, 180, 250, 80);

        getContentPane().add(sidepanel);
        sidepanel.setBounds(0, 0, 540, 1040);

        parentpanel.setBackground(new java.awt.Color(0, 255, 255));
        parentpanel.setLayout(null);

        mode_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mode_lbl.setText("Mode of Payment :");
        parentpanel.add(mode_lbl);
        mode_lbl.setBounds(40, 50, 160, 30);

        ddno_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ddno_lbl.setText("DD no :");
        parentpanel.add(ddno_lbl);
        ddno_lbl.setBounds(40, 90, 90, 30);

        chequeno_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chequeno_lbl.setText("Cheque no :");
        parentpanel.add(chequeno_lbl);
        chequeno_lbl.setBounds(40, 90, 130, 30);

        gst_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gst_lbl.setText("5524GH8JLFPK");
        parentpanel.add(gst_lbl);
        gst_lbl.setBounds(680, 60, 130, 30);

        receipt_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        receipt_lbl.setText("Receipt no :   AGC -");
        parentpanel.add(receipt_lbl);
        receipt_lbl.setBounds(40, 10, 170, 30);

        bankname_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bankname_lbl.setText("Bank Name :");
        parentpanel.add(bankname_lbl);
        bankname_lbl.setBounds(40, 150, 130, 30);

        date_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        date_lbl.setText("Date :");
        parentpanel.add(date_lbl);
        date_lbl.setBounds(590, 10, 60, 30);

        gstno_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gstno_lbl.setText("GST NO :");
        parentpanel.add(gstno_lbl);
        gstno_lbl.setBounds(590, 60, 80, 30);

        receivedfrom_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        receivedfrom_lbl.setText("Received From :");
        parentpanel.add(receivedfrom_lbl);
        receivedfrom_lbl.setBounds(40, 210, 150, 30);

        ddno_tf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ddno_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddno_tfActionPerformed(evt);
            }
        });
        parentpanel.add(ddno_tf);
        ddno_tf.setBounds(230, 90, 160, 40);

        chequeno_tf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        parentpanel.add(chequeno_tf);
        chequeno_tf.setBounds(230, 90, 160, 40);

        bankname_tf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        parentpanel.add(bankname_tf);
        bankname_tf.setBounds(230, 150, 280, 40);

        received_tf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        parentpanel.add(received_tf);
        received_tf.setBounds(230, 210, 370, 40);

        year_tf2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        parentpanel.add(year_tf2);
        year_tf2.setBounds(640, 290, 90, 30);

        receiptNo_tf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        parentpanel.add(receiptNo_tf);
        receiptNo_tf.setBounds(230, 10, 160, 30);

        cb_mode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cb_mode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "CHEQUE", "CASH", "CARD" }));
        cb_mode.setSelectedIndex(2);
        cb_mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_modeActionPerformed(evt);
            }
        });
        parentpanel.add(cb_mode);
        cb_mode.setBounds(230, 50, 160, 30);

        minus_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        minus_lbl.setText("to");
        parentpanel.add(minus_lbl);
        minus_lbl.setBounds(620, 290, 20, 30);

        year_tf1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        year_tf1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        parentpanel.add(year_tf1);
        year_tf1.setBounds(520, 290, 90, 30);

        year_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        year_lbl.setText("The following payment in the college office for the year :");
        parentpanel.add(year_lbl);
        year_lbl.setBounds(40, 290, 460, 30);

        rollno_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rollno_lbl.setText("Roll No :");
        parentpanel.add(rollno_lbl);
        rollno_lbl.setBounds(690, 170, 80, 30);

        course_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        course_lbl.setText("Course :");
        parentpanel.add(course_lbl);
        course_lbl.setBounds(40, 350, 80, 30);

        cb_course.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cb_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_courseActionPerformed(evt);
            }
        });
        parentpanel.add(cb_course);
        cb_course.setBounds(170, 350, 160, 30);

        separator_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        separator_lbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        parentpanel.add(separator_lbl);
        separator_lbl.setBounds(20, 410, 960, 30);

        amount_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        amount_lbl.setText("Amount");
        parentpanel.add(amount_lbl);
        amount_lbl.setBounds(840, 410, 80, 30);

        srno_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        srno_lbl.setText("Sr No");
        parentpanel.add(srno_lbl);
        srno_lbl.setBounds(40, 410, 80, 30);

        head_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        head_lbl.setText("Head");
        parentpanel.add(head_lbl);
        head_lbl.setBounds(350, 410, 80, 30);

        amount_tf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        amount_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amount_tfActionPerformed(evt);
            }
        });
        parentpanel.add(amount_tf);
        amount_tf.setBounds(800, 460, 170, 30);

        sgst_tf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        parentpanel.add(sgst_tf);
        sgst_tf.setBounds(800, 550, 170, 30);

        totalAmount_tf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        parentpanel.add(totalAmount_tf);
        totalAmount_tf.setBounds(800, 620, 170, 30);

        totalInWords_tf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        parentpanel.add(totalInWords_tf);
        totalInWords_tf.setBounds(190, 600, 410, 40);

        cgst_tf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        parentpanel.add(cgst_tf);
        cgst_tf.setBounds(800, 510, 170, 30);

        courseName_tf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        parentpanel.add(courseName_tf);
        courseName_tf.setBounds(180, 460, 400, 40);

        totalinwords_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalinwords_lbl.setText("Total in words :");
        parentpanel.add(totalinwords_lbl);
        totalinwords_lbl.setBounds(20, 600, 140, 30);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        parentpanel.add(jSeparator1);
        jSeparator1.setBounds(770, 690, 240, 20);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        parentpanel.add(jSeparator2);
        jSeparator2.setBounds(770, 590, 240, 20);

        sgst_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sgst_lbl.setText("SGST 9%");
        parentpanel.add(sgst_lbl);
        sgst_lbl.setBounds(180, 550, 90, 30);

        cgst_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cgst_lbl.setText("CGST 9%");
        parentpanel.add(cgst_lbl);
        cgst_lbl.setBounds(180, 510, 80, 30);

        remarks_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        remarks_lbl.setText("Remarks :");
        parentpanel.add(remarks_lbl);
        remarks_lbl.setBounds(20, 640, 90, 30);

        receiverSignature_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        receiverSignature_lbl.setText("Receiver Signature");
        parentpanel.add(receiverSignature_lbl);
        receiverSignature_lbl.setBounds(800, 700, 160, 30);

        remarks_textarea.setColumns(20);
        remarks_textarea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        remarks_textarea.setRows(5);
        jScrollPane1.setViewportView(remarks_textarea);

        parentpanel.add(jScrollPane1);
        jScrollPane1.setBounds(190, 650, 410, 131);

        print_btn.setBackground(new java.awt.Color(0, 204, 204));
        print_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        print_btn.setText("PRINT");
        print_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        print_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        print_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_btnActionPerformed(evt);
            }
        });
        parentpanel.add(print_btn);
        print_btn.setBounds(840, 740, 80, 30);

        rollno_tf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        parentpanel.add(rollno_tf);
        rollno_tf.setBounds(780, 170, 150, 30);

        dateChooser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dateChooser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        parentpanel.add(dateChooser);
        dateChooser.setBounds(670, 10, 260, 40);

        getContentPane().add(parentpanel);
        parentpanel.setBounds(540, 0, 1310, 1040);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_logout_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
        Home obj = new Home();
        obj.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void ddno_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddno_tfActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ddno_tfActionPerformed

    private void cb_modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_modeActionPerformed
        // TODO add your handling code here:
        if(cb_mode.getSelectedIndex()==0){
        ddno_lbl.setVisible(true);
        chequeno_lbl.setVisible(false);
        ddno_tf.setVisible(true);
        chequeno_tf.setVisible(false);
        bankname_lbl.setVisible(true);
        bankname_tf.setVisible(true);
        }
        if(cb_mode.getSelectedIndex()==1){
        ddno_lbl.setVisible(false);
        chequeno_lbl.setVisible(true);
        ddno_tf.setVisible(false);
        chequeno_tf.setVisible(true);
        bankname_lbl.setVisible(true);
        bankname_tf.setVisible(true);
        }
        if(cb_mode.getSelectedIndex()==2){
        ddno_lbl.setVisible(false);
        chequeno_lbl.setVisible(false);
        ddno_tf.setVisible(false);
        chequeno_tf.setVisible(false);
        bankname_lbl.setVisible(false);
        bankname_tf.setVisible(false); 
        }
        if(cb_mode.getSelectedItem().equals("CARD")){
        ddno_lbl.setVisible(false);
        chequeno_lbl.setVisible(false);
        ddno_tf.setVisible(false);
        chequeno_tf.setVisible(false);
        bankname_lbl.setVisible(true);
        bankname_tf.setVisible(true);
        }
    }//GEN-LAST:event_cb_modeActionPerformed

    private void print_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_btnActionPerformed
        // TODO add your handling code here:
        if(validation()==true){
            int receipt = Integer.parseInt(receiptNo_tf.getText());
            String name = received_tf.getText();
            int roll = Integer.parseInt(rollno_tf.getText());
            String payment = cb_mode.getSelectedItem().toString();
            String cheque = chequeno_tf.getText();
            String course = courseName_tf.getText();
            String dd = ddno_tf.getText();
            String bank = bankname_tf.getText();
            String gst = gst_lbl.getText();
            String tot = totalAmount_tf.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
            String date = dateFormat.format(dateChooser.getDate());
            String initialamount = amount_tf.getText();
            float cgst = Float.parseFloat(cgst_tf.getText());
            float sgst = Float.parseFloat(sgst_tf.getText());
            String totalinwords = totalInWords_tf.getText();
            String remarks = remarks_textarea.getText();
            int year1 = Integer.parseInt(year_tf1.getText());
            int year2 = Integer.parseInt(year_tf2.getText());
            try{
                    ResultSet rs = DBLoader.executeSQL("select * from feedetails where receiptNo ='"+receipt+"'");
                    if(rs.next()){
                        //fill row
                        rs.updateInt("receiptNo",receipt);
                        rs.updateString("studentName",name);
                        rs.updateInt("Rollno", roll);
                        rs.updateString("payment_mode",payment);
                        rs.updateString("chequeNo",cheque);
                        rs.updateString("bankname",bank);
                        rs.updateString("ddno",dd);
                        rs.updateString("courseName",course);
                        rs.updateString("gstno",gst);
                        rs.updateString("totalamount",tot);
                        rs.updateString("date",date);
                        rs.updateString("amount",initialamount);
                        rs.updateFloat("cgst",cgst);
                        rs.updateFloat("sgst",sgst);
                        rs.updateString("total_in_words",totalinwords);
                        rs.updateString("remarks",remarks);
                        rs.updateInt("year1",year1);
                        rs.updateInt("year2",year2);
                        
                        // insert to actual databases
                        rs.updateRow();
                        
                        JOptionPane.showMessageDialog(this,"Fee update successfully");
                        printReceipt obj = new printReceipt();
                        obj.setVisible(true);
                        this.dispose();
                    
                     receiptNo_tf.setText("");
                     received_tf.setText("");
                     rollno_tf.setText("");
                     chequeno_tf.setText("");
                     ddno_tf.setText("");
                     bankname_tf.setText("");
                     totalAmount_tf.setText("");
//                     dateChooser.setText("");
                     amount_tf.setText("");
                     cgst_tf.setText("");
                     sgst_tf.setText("");
                     totalInWords_tf.setText("");
                     remarks_textarea.setText("");       
                }
            }
                catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this,ex);
                }
            
        }
    }//GEN-LAST:event_print_btnActionPerformed

    private void amount_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amount_tfActionPerformed
        // TODO add your handling code here:
        courseName_tf.setText(cb_course.getSelectedItem().toString());
        Float amt = Float.parseFloat(amount_tf.getText());
        
        Float cgst = (float)(amt * 0.09);
        Float sgst = (float)(amt * 0.09);
        
        cgst_tf.setText(cgst.toString());
        sgst_tf.setText(sgst.toString());
        
        float tot =  amt+cgst+sgst;
        totalAmount_tf.setText(Float.toString(tot));
        
//        NumberToWordsConverter.convert((int)tot);
        
        totalInWords_tf.setText(NumberToWordsConverter.convert((int)tot)+ " Rs only");
    }//GEN-LAST:event_amount_tfActionPerformed

    private void cb_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_courseActionPerformed
        // TODO add your handling code here:
//        courseName_tf.setText().cb_course.getSelectedItem();
    }//GEN-LAST:event_cb_courseActionPerformed

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
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount_lbl;
    private javax.swing.JTextField amount_tf;
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel bankname_lbl;
    private javax.swing.JTextField bankname_tf;
    private javax.swing.JComboBox<String> cb_course;
    private javax.swing.JComboBox<String> cb_mode;
    private javax.swing.JLabel cgst_lbl;
    private javax.swing.JTextField cgst_tf;
    private javax.swing.JLabel chequeno_lbl;
    private javax.swing.JTextField chequeno_tf;
    private javax.swing.JTextField courseName_tf;
    private javax.swing.JLabel course_lbl;
    private javax.swing.JButton courselist_btn;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel date_lbl;
    private javax.swing.JLabel ddno_lbl;
    private javax.swing.JTextField ddno_tf;
    private javax.swing.JLabel gst_lbl;
    private javax.swing.JLabel gstno_lbl;
    private javax.swing.JLabel head_lbl;
    private javax.swing.JButton home_btn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton logout_btn;
    private javax.swing.JLabel minus_lbl;
    private javax.swing.JLabel mode_lbl;
    private javax.swing.JPanel parentpanel;
    private javax.swing.JButton print_btn;
    private javax.swing.JTextField receiptNo_tf;
    private javax.swing.JLabel receipt_lbl;
    private javax.swing.JTextField received_tf;
    private javax.swing.JLabel receivedfrom_lbl;
    private javax.swing.JLabel receiverSignature_lbl;
    private javax.swing.JLabel remarks_lbl;
    private javax.swing.JTextArea remarks_textarea;
    private javax.swing.JLabel rollno_lbl;
    private javax.swing.JTextField rollno_tf;
    private javax.swing.JButton searchRecord_btn;
    private javax.swing.JLabel separator_lbl;
    private javax.swing.JLabel sgst_lbl;
    private javax.swing.JTextField sgst_tf;
    private javax.swing.JPanel sidepanel;
    private javax.swing.JLabel srno_lbl;
    private javax.swing.JTextField totalAmount_tf;
    private javax.swing.JTextField totalInWords_tf;
    private javax.swing.JLabel totalinwords_lbl;
    private javax.swing.JButton viewall_btn;
    private javax.swing.JLabel year_lbl;
    private javax.swing.JTextField year_tf1;
    private javax.swing.JTextField year_tf2;
    // End of variables declaration//GEN-END:variables
}
