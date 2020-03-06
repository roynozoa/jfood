
/**
 * Write a description of class InvoiceStatus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public enum InvoiceStatus
{
    // instance variables - replace the example below with your own
    Ongoing("Ongoing"),
    Finished("Finished"),
    Cancelled("Cancelled");
    
    private String status;
    /**
     * method untuk mendapatkan status invoice
     */
    private InvoiceStatus(String status){
        this.status = status;
    }
    
    /**
     * mengubah status menjadi string
     */
    public String toString(){
        return status;
    }
}

