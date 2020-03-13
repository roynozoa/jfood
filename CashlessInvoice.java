/**
 * Kelas CashlessInvoice merupakan subclass dari kelas Invoice
 * Kelas ini berfungsi untuk menampilkan invoice bertipe cashless
 * 
 * @author (Muhammad Adisatriyo Pratama)
 * @version (12/03/2020)
 */

public class CashlessInvoice extends Invoice{
    //field kelas
    private PaymentType PAYMENT_TYPE = PaymentType.Cashless; 
    private Promo promo;
    
    /**
     * Constructor 1 kelas CashlessInvoice (tanpa promo)
     */
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus){
        super(id, food, date, customer, invoiceStatus);
    }
    
    /**
     * Constructor 2 kelas CashlessInvoice (dengan promo)
     */
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, Promo promo){
        super(id, food, date, customer, invoiceStatus);
        this.promo = promo;
    }
    
    /**
     * Metode getPaymentType untuk mendapatkan tipe pembayaran
     * 
     * @retrurn tipe pembayaran
     */
    public PaymentType getPaymentType(){
        return PAYMENT_TYPE;
    }
    
    /**
     * Metode getPromo untuk mendapatkan promo
     * 
     * @retrurn promo
     */
    public Promo getPromo(){
        return promo;
    }
    
    /**
     * Metode setPromo untuk mengatur promo yang ada
     *
     * 
     * @param    promo
     */
    public void setPromo(Promo promo){
        this.promo = promo;
    }
    
    /**
     * Metode setTotalPrice untuk mengatur harga setelah ada promo
     *
     * 
     * 
     */
    public void setTotalPrice(){
        
        if (promo!= null  && getPromo().getActive() == true && getFood().getPrice() > getPromo().getMinPrice()){
            totalPrice = getFood().getPrice() - getPromo().getDiscount();
        } else{
            this.totalPrice = getFood().getPrice();
        }
        
    }
    
    
    /**
     * method printData yang dapat ditampilkan pada main method
     */
    public void printData(){
        setTotalPrice();
        System.out.println("==========INVOICE==========");
        System.out.println("ID: "+ super.getId());
        System.out.println("Food: " + getFood().getName());
        System.out.println("Date: " + super.getDate());
        System.out.println("Customer: " + getCustomer().getName());
        System.out.println("Total Price: " + getTotalPrice());
        System.out.println("Payment Type: " + getPaymentType());
        if (promo!= null && getPromo().getActive() == true && getFood().getPrice() > getPromo().getMinPrice() ){
            System.out.println("Promo: "+ getPromo().getCode());
        } 
        System.out.println();
    }
   
}
