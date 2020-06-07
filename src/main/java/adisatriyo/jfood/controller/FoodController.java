package adisatriyo.jfood.controller;

import adisatriyo.jfood.*;
import adisatriyo.jfood.databases.DatabaseFood;
import adisatriyo.jfood.databases.DatabaseFoodPostgres;
import adisatriyo.jfood.databases.DatabaseSeller;
import adisatriyo.jfood.databases.DatabaseSellerPostgres;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/food")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController

public class FoodController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood() {
        return DatabaseFoodPostgres.getFoodDatabase();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id) {
        Food food = null;
        food = DatabaseFoodPostgres.getFoodById(id);

        return food;
    }

    @RequestMapping(value = "/seller/{sellerId}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId) {
        ArrayList<Food> FOOD_BY_SELLER= DatabaseFoodPostgres.getFoodBySeller(sellerId);
        return FOOD_BY_SELLER;
    }

    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(@PathVariable String category) {
        ArrayList<Food> FOOD_BY_CATEGORY= DatabaseFoodPostgres.getFoodByCategory(category);
        return FOOD_BY_CATEGORY;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value = "name") String name,
                        @RequestParam(value = "price") int price,
                        @RequestParam(value = "category") String category,
                        @RequestParam(value = "sellerId") int sellerId) {
        Food food = null;
        try {
            DatabaseFoodPostgres.insertFood(food = new Food(DatabaseFoodPostgres.getLastId()+1, name, DatabaseSellerPostgres.getSellerById(sellerId), price, category));
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return food;
    }




}
