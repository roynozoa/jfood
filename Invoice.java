//komen
/**
 * Kelas Invoice berguna untuk menyimpan data invoice
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (12/03/2020)
 */
abstract class Invoice{
    
    //field Invoice
    
    private int id;
    private Food food;
    private String date;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor kelas Invoice
     */
    public Invoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus){
        this.id = id;
        this.food = food;
        this.date = date;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * Metode getId untuk mendapatkan id invoice
     *
     * 
     * @return   id invoice
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * Metode getIdFood untuk mendapatkan id makanan invoice
     *
     * 
     * @return   id makanan invoice
     */
    public Food getFood(){
        return this.food;
    }
    
    /**
     * Metode getDate untuk mendapatkan tanggal pada invoice
     *
     * 
     * @return   tanggal invoice
     */
    public String getDate(){
        return this.date;
    }
    
    /**
     * Metode getTotalPrice untuk mendapatkan total hargainvoice
     *
     * 
     * @return   total harga invoice
     */
    public int getTotalPrice(){
        return this.totalPrice;
    }
    
    /**
     * Metode getCustomer untuk mendapatkan customer atau pembeli invoice
     *
     * 
     * @return   pembeli atau customer
     */
    public Customer getCustomer(){
        return this.customer;
    }
    
    /**
     * Metode getPaymentType untuk mendapatkan tipe pembayaran
     * 
     * 
     */
    public abstract PaymentType getPaymentType();
    
    /**
     * Metode getStatus untuk mendapatkan status invoice
     * 
     * @return   status pembayaran
     */
    public InvoiceStatus getInvoiceStatus(){
        return this.invoiceStatus;
    }
    
    /**
     * Metode setId untuk mengatur id invoice
     *
     * 
     * @param    id invoice
     */
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * Metode setIdFood untuk mengatur id makanan
     *
     * 
     * @param    id makanan
     */
    public void setFood(Food idFood){
        this.food = food;
    }
    
    /**
     * Metode setDate untuk mengatur tanggal invoice
     *
     * 
     * @param    tanggal invoice
     */
    public void setDate(String date){
        this.date = date;
    }
    
    /**
     * Metode setTotalPrice untuk mengatur total harga invoice
     *
     * 
     * 
     */
    public abstract void setTotalPrice();
    
    /**
     * Metode setCustomer untuk mengatur pembeli
     *
     * 
     * @param    customer pembeli
     */
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    
    
    /**
     * Metode setInvoiceStatus untuk mengatur status invoice
     *
     * 
     * @param    status invoice
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus){
        this.invoiceStatus = invoiceStatus;
    }
    
    /**
     * Metode printData untuk menampilkan nama penjual
     *
     * 
     * 
     */
    public abstract void printData();
        
    
    
}
