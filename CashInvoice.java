/**
 * Kelas CashInvoice merupakan subclass dari kelas Invoice
 * Kelas ini berfungsi untuk menampilkan invoice bertipe cash
 * 
 * @author (Muhammad Adisatriyo Pratama)
 * @version (13/03/2020)
 */

public class CashInvoice extends Invoice{
    //field kelas
    private PaymentType PAYMENT_TYPE = PaymentType.Cash; 
    private int deliveryFee;
    
    /**
     * Constructor 1 kelas CashlessInvoice (tanpa ongkir)
     */
    public CashInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus){
        super(id, food, date, customer, invoiceStatus);
    }
    
    /**
     * Constructor 2 kelas CashlessInvoice (dengan ongkir)
     */
    public CashInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, int deliveryFee){
        super(id, food, date, customer, invoiceStatus);
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
        if (deliveryFee != 0){
            System.out.println("Delivery Fee: "+ getDeliveryFee());
        } 
        System.out.println();
    }
   
}
