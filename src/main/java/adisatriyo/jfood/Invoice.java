/**
 * Kelas Invoice berguna untuk menyimpan data invoice
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (9/4/2020)
 */
package adisatriyo.jfood;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

abstract class Invoice implements Runnable{
    
    //field Invoice
    
    private int id;
    private ArrayList<Food> foods;
    private Calendar date;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor kelas Invoice
     */
    public Invoice(int id, ArrayList<Food> foods, Customer customer, InvoiceStatus invoiceStatus){
        this.id = id;
        this.foods = foods;
        setDate(Calendar.getInstance());
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
    public ArrayList<Food> getFoods(){
        return this.foods;
    }
    
    /**
     * Metode getDate untuk mendapatkan tanggal pada invoice
     *
     * 
     * @return   tanggal invoice
     */
    public Calendar getDate(){
        
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
     * Metode setFoods untuk mengatur makanan
     *
     * 
     * @param /id makanan
     */
    public void setFoods(ArrayList<Food> foods){
        this.foods = foods;
    }
    
    /**
     * Metode setDate untuk mengatur tanggal invoice
     *
     * 
     * @param    /tanggal invoice
     */
    public void setDate(Calendar date){
        this.date = date;
    }
    
    public void setDate(int year, int month, int dayOfMonth){
        this.date = new GregorianCalendar(year, month - 1, dayOfMonth);
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
     * @param    /status invoice
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus){
        this.invoiceStatus = invoiceStatus;
    }

    public abstract void start();

    /**
     * Metode toString untuk menampilkan data
     *
     * 
     * 
     */
    //public abstract void toString();
        
    
    
}
