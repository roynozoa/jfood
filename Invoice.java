//komen
public class Invoice{
    private int id,idFood,totalPrice;
    private String date;
    private Customer customer;
    private PaymentType paymentType;
    private InvoiceStatus status;

    /**
     * Constructor kelas Invoice
     */
    public Invoice(int id, int idFood, String date, int totalPrice, Customer customer, PaymentType paymentType, InvoiceStatus status){
        this.id = id;
        this.idFood = idFood;
        this.date = date;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.paymentType = paymentType;
        this.status = status;
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
    public int getIdFood(){
        return this.idFood;
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
     * @return   tipe pembayaran
     */
    public PaymentType getPaymentType(){
        return this.paymentType;
    }
    
    /**
     * Metode getStatus untuk mendapatkan status invoice
     * 
     * @return   status pembayaran
     */
    public InvoiceStatus getInvoiceStatus(){
        return this.status;
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
    public void setIdFood(int idFood){
        this.idFood = idFood;
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
     * @param    total harga invoice
     */
    public void setTotalPrice(int totalPrice){
        this.totalPrice = totalPrice;
    }
    
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
     * Metode setPaymentType untuk mengatur tipe pembayaran
     *
     * 
     * @param    tipe pembayaran
     */
    public void setPaymentType(PaymentType paymentType){
        this.paymentType = paymentType;
    }
    
    /**
     * Metode setInvoiceStatus untuk mengatur status invoice
     *
     * 
     * @param    status invoice
     */
    public void setInvoiceStatus(InvoiceStatus status){
        this.status = status;
    }
    
    /**
     * Metode printData untuk menampilkan nama penjual
     *
     * 
     * 
     */
    public void printData(){
        System.out.println("==========INVOICE==========");
        System.out.println("ID: "+ id);
        System.out.println("Food ID: "+ idFood);
        System.out.println("Date: "+ date);
        System.out.println("Customer: "+ customer.getName());
        System.out.println("Total Price: "+ totalPrice);
        System.out.println("Status: "+ status);
        
    }
    
}
