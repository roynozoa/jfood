
/**
 * Kelas DatabaseFood berguna untuk menyimpan database makanan
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (3.0 05/03/2020)
 */
import java.util.ArrayList;

public class DatabaseFood{
    // instance variables - replace the example below with your own
    //merupakan field dari kelas DatabaseFood
    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Food> getFoodDatabase(){
        return FOOD_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Food getFoodById(int id){
        for(Food food : FOOD_DATABASE){
            if(food.getId() == id){
                return food;
            }
        }
        return null;
    }

    public static ArrayList<Food> getFoodBySeller(int sellerId){
        for(Food food : FOOD_DATABASE){
            if(food.getSeller().getId() == sellerId){
                ArrayList<Food> listFoodBySeller=new ArrayList<Food>();
                listFoodBySeller.add(food);
                return listFoodBySeller;

            }
        }
        return null;
    }
    public static ArrayList<Food> getFoodByCategory(FoodCategory category){
        for(Food food : FOOD_DATABASE){
            if(food.getCategory() == category){
                ArrayList<Food> listFoodByCategory=new ArrayList<Food>();
                listFoodByCategory.add(food);
                return listFoodByCategory;

            }
        }
        return null;
    }

    public static boolean addFood(Food food){

        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;

    }

    public static boolean removeFood(int id){
        for(Food food : FOOD_DATABASE){
            if(food.getId()== id){
                FOOD_DATABASE.remove(food);
                return true;
            }
        }
        return false;

    }



    
}
