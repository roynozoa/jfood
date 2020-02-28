//komen
public class Invoice{
    private int id,idFood,totalPrice;
    private String date;
    Customer customer;

    public Invoice(int id, int idFood, String date, Customer customer, int totalPrice){
        this.id = id;
        this.idFood = idFood;
        this.date = date;
        this.customer = customer;
        this.totalPrice = totalPrice;
    }

    /**
     * Metode getId untuk mendapatkan id invoice
     *
     * 
     * @return   id invoice
     */
    public int getId(){
        return this.id = id;
    }
    
    /**
     * Metode getIdFood untuk mendapatkan id makanan invoice
     *
     * 
     * @return   id makanan invoice
     */
    public int getIdFood(){
        return this.idFood = idFood;
    }
    
    /**
     * Metode getDate untuk mendapatkan tanggal pada invoice
     *
     * 
     * @return   tanggal invoice
     */
    public String getDate(){
        return this.date = date;
    }
    
    /**
     * Metode getTotalPrice untuk mendapatkan total hargainvoice
     *
     * 
     * @return   total harga invoice
     */
    public int getTotalPrice(){
        return this.totalPrice = totalPrice;
    }
    
    /**
     * Metode getCustomer untuk mendapatkan customer atau pembeli invoice
     *
     * 
     * @return   pembeli atau customer
     */
    public Customer getCustomer(){
        return this.customer = customer;
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
     * Metode printData untuk menampilkan nama penjual
     *
     * 
     * 
     */
    public void printData(){
        System.out.println(totalPrice);
        //print data
    }
    
}
