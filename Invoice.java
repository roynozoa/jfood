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

    public int getId(){
        return this.id = id;
    }
    
    public int getIdFood(){
        return this.idFood = idFood;
    }
    
    public String getDate(){
        return this.date = date;
    }
    
    public Customer getCustomer(){
        return this.customer = customer;
    }
    
    public int getTotalPrice(){
        return this.totalPrice = totalPrice;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setIdFood(int idFood){
        this.idFood = idFood;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public void setTotalPrice(int totalPrice){
        this.totalPrice = totalPrice;
    }
    
    public void printData(){
        //print data
    }
    
}
