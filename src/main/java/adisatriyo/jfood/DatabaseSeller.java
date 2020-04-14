
/**
 * Kelas databaseseller berguna untuk menyimpan database penjual
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (9/4/2020)
 */
package adisatriyo.jfood;

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

    public static Seller getSellerById(int id) throws SellerNotFoundException {
        for (Seller sell : SELLER_DATABASE){
            if(sell.getId() == id){
                return sell;
            }

        }
        throw new SellerNotFoundException(id);
    }
    public static boolean addSeller(Seller seller){

        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;

    }

    public static boolean removeSeller(int id) throws SellerNotFoundException {
        for(Seller sell : SELLER_DATABASE){
            if(sell.getId()==id){
                SELLER_DATABASE.remove(sell);
                return true;
            }
        }
        throw new SellerNotFoundException(id);
    }

}
