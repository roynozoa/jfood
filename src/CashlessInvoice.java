/**
 * Kelas CashlessInvoice merupakan subclass dari kelas Invoice
 * Kelas ini berfungsi untuk menampilkan invoice bertipe cashless
 * 
 * @author (Muhammad Adisatriyo Pratama)
 * @version (12/03/2020)
 */
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class CashlessInvoice extends Invoice{
    //field kelas
    private PaymentType PAYMENT_TYPE = PaymentType.Cashless; 
    private Promo promo;
    
    /**
     * Constructor 1 kelas CashlessInvoice (tanpa promo)
     */
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus){
        super(id, food, customer, invoiceStatus);
    }
    
    /**
     * Constructor 2 kelas CashlessInvoice (dengan promo)
     */
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus, Promo promo){
        super(id, food, customer, invoiceStatus);
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
     * method toString yang dapat ditampilkan pada main method
     */
    public String toString(){
        SimpleDateFormat formatDate = new SimpleDateFormat ("dd MMMM yyyy");
        setTotalPrice();
        
        if (promo!= null && getPromo().getActive() == true && getFood().getPrice() > getPromo().getMinPrice() ){
        return String.format("==========INVOICE CASHLESS==========" + "\n" +
                            "Id=" + getId() + "\n" + 
                            "Food=" + getFood().getName() + "\n" + 
                            "Date=" + formatDate.format(getDate().getTime()) + "\n" +
                            "Customer=" + getCustomer().getName() + "\n" +
                            "Total Price=" + getTotalPrice() + "\n" +
                            "Payment Type=" + getPaymentType() + "\n" +
                            "Delivery Fee=" + getPromo().getCode() + "\n");
        } else {
        return String.format("==========INVOICE CASHLESS==========" + "\n" +
                            "Id=" + getId() + "\n" + 
                            "Food=" + getFood().getName() + "\n" + 
                            "Date=" + formatDate.format(getDate().getTime()) + "\n" +
                            "Customer=" + getCustomer().getName() + "\n" +
                            "Total Price=" + getTotalPrice() + "\n" +
                            "Payment Type=" + getPaymentType() + "\n");
        
        }
    }
    
}
