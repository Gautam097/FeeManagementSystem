public class viewAll {
    String receiptNo;
    String studentName;
    String paymentMode;
    String course;
    String amount;
    String rollno;
    String bankname;
    String cgst;
    String sgst;
    String remark;
    String gst;
    String year1;
    String year2;
    
    
    viewAll(String receiptNo,String studentName,String paymentMode,String course,String amount,String rollno,String bankname,String cgst,String sgst,String year1,String year2,String gst,String remark){
        
        this.receiptNo = receiptNo;
        this.studentName= studentName;
        this.paymentMode= paymentMode;
        this.course=course;
        this.amount=amount;
        this.rollno=rollno;
        this.bankname=bankname;
        this.cgst=cgst;
        this.sgst=sgst;
        this.gst=gst;
        this.year1=year1;
        this.year2=year2;
        this.remark= remark;
    }
    
}
