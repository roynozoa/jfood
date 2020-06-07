
/**
 * Kelas CashInvoice merupakan subclass dari kelas Invoice
 * Kelas ini berfungsi untuk menampilkan invoice bertipe cash
 * 
 * @author (Muhammad Adisatriyo Pratama)
 * @version (9/4/2020)
 */

package adisatriyo.jfood;

import java.util.ArrayList;
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
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer){
        super(id, foods, customer);
    }
    
    /**
     * Constructor 2 kelas CashlessInvoice (dengan ongkir)
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer, int deliveryFee){
        super(id, foods, customer);
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
     * @param    /nilai ongkir
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
        super.totalPrice = 0;
        if(deliveryFee > 0) {
            for(Food foods:getFoods()) {
                super.totalPrice += foods.getPrice();
            }
            super.totalPrice += getDeliveryFee();
        }
        else if(deliveryFee == 0) {
            for(Food foods:getFoods()) {
                super.totalPrice += foods.getPrice();
            }
        }
        
    }

    public void setTotalPrices(int totalPrices){
        super.totalPrice = totalPrices;
    }



    /**
     * method toString yang dapat ditampilkan pada main method
     */
    public String toString(){
        SimpleDateFormat formatDate = new SimpleDateFormat ("dd MMMM yyyy");
        //setTotalPrice();
        String listMakanan = "";
        for (Food food : getFoods())
        {
            listMakanan += food.getName() + ", ";
        }
        if (deliveryFee != 0){
        return String.format("==========INVOICE CASH==========" + "\n" +
                            "Id=" + getId() + "\n" +
                            "Food=" + listMakanan + "\n" +
                            "Date=" + formatDate.format(getDate().getTime()) + "\n" +
                            "Customer=" + getCustomer().getName() + "\n" +
                            "Total Price=" + getTotalPrice() + "\n" +
                            "Payment Type=" + getPaymentType() + "\n" +
                            "Status=" + getInvoiceStatus() + "\n" +
                            "Delivery Fee=" + getDeliveryFee() + "\n");
        } else {
        return String.format("==========INVOICE CASH==========" + "\n" +
                            "Id=" + getId() + "\n" +
                            "Food=" + listMakanan + "\n" +
                            "Date=" + formatDate.format(getDate().getTime()) + "\n" +
                            "Customer=" + getCustomer().getName() + "\n" +
                            "Total Price=" + getTotalPrice() + "\n" +
                            "Payment Type=" + getPaymentType()+ "\n" +
                            "Status=" + getInvoiceStatus() + "\n");

        }

    }


    @Override
    public void start() {
        for(Food foodList : getFoods())
        {
            totalPrice += foodList.getPrice();

        }
        if (deliveryFee != 0){
            totalPrice += getDeliveryFee();
        } else{
            totalPrice = totalPrice;
        }
    }

    @Override
    public void run() {

    }
}
