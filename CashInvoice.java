
/**
 * Kelas CashInvoice merupakan subclass dari kelas Invoice
 * Kelas ini berfungsi untuk menampilkan invoice bertipe cash
 * 
 * @author (Muhammad Adisatriyo Pratama)
 * @version (13/03/2020)
 */

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class CashInvoice extends Invoice{
    //field kelas
    private PaymentType PAYMENT_TYPE = PaymentType.Cash; 
    private int deliveryFee;
    
    /**
     * Constructor 1 kelas CashlessInvoice (tanpa ongkir)
     */
    public CashInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus){
        super(id, food, customer, invoiceStatus);
    }
    
    /**
     * Constructor 2 kelas CashlessInvoice (dengan ongkir)
     */
    public CashInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus, int deliveryFee){
        super(id, food, customer, invoiceStatus);
        this.deliveryFee = deliveryFee;
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
     * Metode getDeliveryFee untuk mendapatkan nilai ongkir
     * 
     * @retrurn delivery fee
     */
    public int getDeliveryFee(){
        return deliveryFee;
    }
    
    /**
     * Metode setDeliveryFee untuk mengatur nilai ongkir yang ada
     *
     * 
     * @param    nilai ongkir
     */
    public void setDeliveryFee(int deliveryFee){
        this.deliveryFee = deliveryFee;
    }
    
    /**
     * Metode setTotalPrice untuk mengatur harga setelah ada promo
     *
     * 
     * 
     */
    public void setTotalPrice(){
        
        if (deliveryFee != 0){
            totalPrice = getFood().getPrice() + getDeliveryFee();
        } else{
            totalPrice = getFood().getPrice();
        }
        
    }
    
    
    /**
     * method toString yang dapat ditampilkan pada main method
     */
    public String toString(){
        SimpleDateFormat formatDate = new SimpleDateFormat ("dd MMMM yyyy");
        setTotalPrice();
        if (deliveryFee != 0){
        return String.format("==========INVOICE CASH==========" + "\n" +
                            "Id=" + getId() + "\n" + 
                            "Food=" + getFood().getName() + "\n" + 
                            "Date=" + formatDate.format(getDate().getTime()) + "\n" +
                            "Customer=" + getCustomer().getName() + "\n" +
                            "Total Price=" + getTotalPrice() + "\n" +
                            "Payment Type=" + getPaymentType() + "\n" +
                            "Delivery Fee=" + getDeliveryFee());
        } else {
        return String.format("==========INVOICE CASH==========" + "\n" +
                            "Id=" + getId() + "\n" + 
                            "Food=" + getFood().getName() + "\n" + 
                            "Date=" + formatDate.format(getDate().getTime()) + "\n" +
                            "Customer=" + getCustomer().getName() + "\n" +
                            "Total Price=" + getTotalPrice() + "\n" +
                            "Payment Type=" + getPaymentType());
        
        }
    }
    
}
