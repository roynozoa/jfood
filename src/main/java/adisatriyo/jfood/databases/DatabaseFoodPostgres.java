package adisatriyo.jfood.databases;

import adisatriyo.jfood.*;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseFoodPostgres extends DatabaseConnection {

    public static Food insertFood(Food food) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String name = food.getName();
            int price = food.getPrice();
            int sellerId = food.getSeller().getId();
            String category = food.getCategory();
            int id = food.getId();
            String sql = "INSERT INTO food (id, name, sellerId, price, category) VALUES ('"+id+"','"+name+"','"+sellerId+"','"+price+"','"+category+"');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return food;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Food> getFoodDatabase()
    {
        Connection c = connection();
        PreparedStatement stmt;
        Food food = null;
        ArrayList<Food> foods = new ArrayList<>();
        int id = 0;
        String name = null;
        int price = 0;
        int sellerId = 0;
        String category = null;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM food;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                id = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getInt("price");
                sellerId = rs.getInt("sellerId");
                category = rs.getString("category");
                food = new Food(id, name, DatabaseSellerPostgres.getSellerById(sellerId), price,category);
                foods.add(food);
            }
            rs.close();
            stmt.close();
            c.close();
            if (id == 0){
                return null;
            }
            else {
                return foods;
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getLastId(){
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id from food;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
            stmt.close();
            c.close();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static Food getFoodById(int foodId)
    {
        Connection c = connection();
        PreparedStatement stmt;
        Food food = null;
        int id = 0;
        String name = null;
        int price = 0;
        int sellerId = 0;
        String category = null;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM food WHERE id = '"+foodId+"';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                id = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getInt("price");
                sellerId = rs.getInt("sellerId");
                category = rs.getString("category");
            }
            rs.close();
            stmt.close();
            c.close();
            if (id == 0){
                return null;
            }
            else {
                food = new Food(id, name, DatabaseSellerPostgres.getSellerById(sellerId), price,category);
                return food;
            }

        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Food> getFoodBySeller(int sellerIdFood)
    {
        Connection c = connection();
        PreparedStatement stmt;
        Food food = null;
        ArrayList<Food> foods = new ArrayList<>();
        int id = 0;
        String name = null;
        int price = 0;
        int sellerId = 0;
        String category = null;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM food WHERE sellerId = '"+sellerIdFood+"';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                id = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getInt("price");
                sellerId = rs.getInt("sellerId");
                category = rs.getString("category");
                food = new Food(id, name, DatabaseSellerPostgres.getSellerById(sellerId), price,category);
                foods.add(food);
            }
            rs.close();
            stmt.close();
            c.close();
            if (id == 0){
                return null;
            }
            else {
                return foods;
            }

        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Food> getFoodByCategory(String categoryFood)
    {
        Connection c = connection();
        PreparedStatement stmt;
        Food food = null;
        ArrayList<Food> foods = new ArrayList<>();
        int id = 0;
        String name = null;
        int price = 0;
        int sellerId = 0;
        String category = null;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM food WHERE id = '"+categoryFood+"';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                id = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getInt("price");
                sellerId = rs.getInt("sellerId");
                category = rs.getString("category");
                food = new Food(id, name, DatabaseSellerPostgres.getSellerById(sellerId), price,category);
                foods.add(food);
            }
            rs.close();
            stmt.close();
            c.close();
            if (id == 0){
                return null;
            }
            else {
                return foods;
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }

}
