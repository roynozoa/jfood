
/**
 * Kelas databaseseller berguna untuk menyimpan database penjual
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (3.0 05/03/2020)
 */
import java.util.ArrayList;

public class DatabaseSeller
{
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Seller> getSellerDatabase(){
        return SELLER_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Seller getSellerById(int id){
        for (Seller sell : SELLER_DATABASE){
            if(sell.getId() == id){
                return sell;
            }

        }
        return null;
    }
    public static boolean addSeller(Seller seller){

//        for(Seller sell : SELLER_DATABASE){
//
//        }
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;

    }

    public static boolean removeSeller(int id){
        for(Seller sell : SELLER_DATABASE){
            if(sell.getId()==id){
                SELLER_DATABASE.remove(sell);
                return true;
            }
        }
        return false;
    }

}
