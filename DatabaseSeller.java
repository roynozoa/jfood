
/**
 * Write a description of class DatabaseSeller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseSeller
{
    private String[] listSeller;
    
    public DatabaseSeller(String[] listSeller){
        this.listSeller = listSeller;
        
    }
    
    public boolean addSeller(Seller seller){
        return true;
    }
    
    public boolean removeSeller(Seller seller){
        return false;
    }
    
    /*public Seller getSeller(){
        return this.seller;
    }*/
    
    public String[] getListSeller(){
        return this.listSeller = listSeller;
    }
}
