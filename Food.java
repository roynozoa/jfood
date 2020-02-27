/*
 * komen
 */

public class Food{
    private int id,price;
    private String name,category;
    private Seller seller;

    
    public Food(int id, String name, Seller seller, int price, String category){ 
        //Food 
        this.id = id;
        this.price = price;
        this.name = name;
        this.seller = seller;
        this.category = category;
        
    }

    public int getId(){
        //this.id = id;
        return this.id;
    }
    
     public String getName(){
        return this.name;
    }
    
    public Seller getSeller(){
        //asd
        return this.seller;
    }
     public int getPrice(){
        return this.price;
    }
    
     public String getCategory(){
        return this.category;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setSeller(Seller seller){
        this.seller = seller;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public void printData(){
        
    }
}
