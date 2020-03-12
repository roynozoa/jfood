/**
 * Kelas Promo berguna untuk menyimpan data promo
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (3.0 12/03/2020)
 */
public class Promo{
    //field Promo
    private int id;
    private String code;
    private int discount;
    private int minPrice;
    private boolean active;
    /**
     * 
     */
    public Promo(int id, String code, int discount, int minPrice, boolean active){
    this.id = id;
    this.code = code;
    this.discount = discount;
    this.minPrice = minPrice;
    this.active = active;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getCode(){
        return this.code;
    }
    
    public int getDiscount(){
        return this.discount;
    }
    
    public int getMinPrice(){
        return this.minPrice;
    }
    
    public boolean getActive(){
        return true;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setCode(String code){
        this.code = code;
    }
    
    public void setDiscount(int discount){
        this.discount = discount;
    }
    
    public void setMinPrice(int minPrice){
        this.minPrice = minPrice;
    }
    
    public void setActive(boolean active){
        this.active = active;
    }
    
    public void printData(){
        System.out.println(id);
        System.out.println(code);
        System.out.println(discount);
        System.out.println(minPrice);
        System.out.println(active);
    }
    
}
