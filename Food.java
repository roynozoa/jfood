/*
 * komen
 */
/**
 * Kelas Food berguna untuk menyimpan data makanan
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (3.0 05/03/2020)
 */

public class Food{
    //merupakan field dari kelas Food
    private int id,price;
    private String name;
    private Seller seller;
    private FoodCategory category;

    /**
     * Merupakan constructor dari kelas Food
     */
    public Food(int id, String name, Seller seller, int price, FoodCategory category){ 
        //Food 
        this.id = id;
        this.price = price;
        this.name = name;
        this.seller = seller;
        this.category = category;
        
        
    }

    /**
     * Metode getID untuk mendapatknan id makanan
     *
     * 
     * @return    id makanan
     */
    public int getId(){
   
        return this.id;
    }
    
    /**
     * Metode getName untuk mendapatknan nama makanan
     *
     * 
     * @return    nama makanan
     */ 
    public String getName(){
        return this.name;
    }
    
    /**
     * Metode getSeller untuk mendapatknan data seller
     *
     * 
     * @return    info penjual
     */
    public Seller getSeller(){
        //asd
        return this.seller;
    }
     
    /**
     * Metode getPrice untuk mendapatknan harga makanan
     *
     * 
     * @return    harga makanan
     */
    public int getPrice(){
        return this.price;
    }
    
    /**
     * Metode getCategory untuk mendapatknan kategori makanan
     *
     * 
     * @return    kategori makanan
     */
    public FoodCategory getCategory(){
        return this.category;
    }
    
    /**
     * Metode setID untuk mengatur id makanan
     *
     * 
     * @param    id makanan
     */
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * Metode setName untuk mengatur nama makanan
     *
     * 
     * @param    nama makanan
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Metode setSeller untuk mengatur info penjual makanan
     *
     * 
     * @param    penjual makanan
     */
    public void setSeller(Seller seller){
        this.seller = seller;
    }
    
    /**
     * Metode setPrice untuk mengatur harga makanan
     *
     * 
     * @param    harga makanan
     */
    public void setPrice(int price){
        this.price = price;
    }
    
    /**
     * Metode setCategory untuk mengatur kategori makanan
     *
     * 
     * @param    kategori makanan
     */
    public void setCategory(FoodCategory category){
        this.category = category;
    }
    
    /**
     * Metode printData untuk menampilkan nama penjual
     *
     * 
     * 
     */
    public void printData(){
        System.out.println("==========FOOD==========");
        System.out.println("ID: "+ id);
        System.out.println("Name: "+ name);
        System.out.println("Seller: "+ seller.getName());
        System.out.println("City: "+ seller.getLocation().getCity());
        System.out.println("Price: "+ price);
        System.out.println("Category: "+ category);
    }
}
