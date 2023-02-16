public class SRecord {
    String receiptNo;
    String studentName;
    String paymentMode;
    String course;
    String amount;
    String remark;
    
    
    
    SRecord(String receiptNo,String studentName,String paymentMode,String course,String amount,String remark){
        
        this.receiptNo = receiptNo;
        this.studentName= studentName;
        this.paymentMode= paymentMode;
        this.course=course;
        this.amount=amount;
        this.remark= remark;
    }
    
}
