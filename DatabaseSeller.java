
/**
 * Kelas databaseseller berguna untuk menyimpan database penjual
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (3.0 05/03/2020)
 */
public class DatabaseSeller
{
    private static String[] listSeller;
    
    /**
     * Method untuk menambahkan seller
     * 
     * @return true
     */
    public static boolean addSeller(Seller seller){
        return true;
    }
    
    
    /**
     * Method untuk menghapus seller
     * @return false
     */
    public static boolean removeSeller(Seller seller){
        return false;
    }
    
    /**
     * Method getSeller untuk mengambil data seller
     * @return null
     */
    public static Seller getSeller(){
        return null;
    }
    
    /**
     * Method getListSeller untuk mengambil data list seller
     * @return listSeller
     */
    public static String[] getListSeller(){
        return listSeller;
    }
}
