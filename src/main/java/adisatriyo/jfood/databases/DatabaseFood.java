/**
 * Kelas DatabaseFood berguna untuk menyimpan database makanan
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (9/4/2020)
 */
package adisatriyo.jfood.databases;

import adisatriyo.jfood.Food;
import adisatriyo.jfood.FoodCategory;
import adisatriyo.jfood.FoodNotFoundException;

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

    public static Food getFoodById(int id) throws FoodNotFoundException {
        for(Food food : FOOD_DATABASE){
            if(food.getId() == id){
                return food;
            }
        }
        throw new FoodNotFoundException(id);
    }

    public static ArrayList<Food> getFoodBySeller(int sellerId){
        ArrayList<Food> LIST_FOOD_BY_SELLER = new ArrayList<Food>();
        for(Food food : FOOD_DATABASE){
            if(food.getSeller().getId() == sellerId){
                LIST_FOOD_BY_SELLER.add(food);

            }
        }
        return LIST_FOOD_BY_SELLER;
    }
    public static ArrayList<Food> getFoodByCategory(String category){
        ArrayList<Food> LIST_FOOD_BY_CATEGORY = new ArrayList<Food>();
        for(Food food : FOOD_DATABASE){
            if(food.getCategory() == category){
                LIST_FOOD_BY_CATEGORY.add(food);
            }
        }
        return LIST_FOOD_BY_CATEGORY;
    }

    public static boolean addFood(Food food){

        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;

    }

    public static boolean removeFood(int id) throws FoodNotFoundException{
        for(Food food : FOOD_DATABASE){
            if(food.getId()== id){
                FOOD_DATABASE.remove(food);
                return true;
            }
        }
        throw new FoodNotFoundException(id);

    }



    
}
