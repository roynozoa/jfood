/**
 * Kelas InvoiceStatus berguna untuk menyimpan data status invoice
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (9/4/2020)
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

