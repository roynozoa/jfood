package adisatriyo.jfood.databases;

import adisatriyo.jfood.*;

import java.sql.*;
import java.text.*;
import java.util.*;

public class DatabaseSellerPostgres extends DatabaseConnection{

    public static Seller insertSeller(Seller seller) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String name = seller.getName();
            String email = seller.getEmail();
            String phoneNumber = seller.getPhoneNumber();
            int id = seller.getId();
            int locationId = seller.getLocation().getId();
            DatabaseLocationPostgres.insertLocation(seller.getLocation());
            String sql = "INSERT INTO seller (id, name, email, phoneNumber, locationId) VALUES ('"+id+"','"+name+"','"+email+"','"+phoneNumber+"','"+locationId+"');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return seller;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getLastId(){
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id from seller;";
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

    public static Seller getSellerById(int id_seller){
        Connection c = connection();
        PreparedStatement stmt;
        Seller seller = null;
        int id = 0;
        String name = null;
        String email = null;
        String phoneNumber = null;
        int locationId = 0;
        try {
            String sql = "SELECT * FROM seller WHERE id = '"+id_seller+"';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
                name = rs.getString("name");
                email  = rs.getString("email");
                phoneNumber = rs.getString("phoneNumber");
                locationId = rs.getInt("locationId");
            }
            rs.close();
            stmt.close();
            c.close();
            seller = new Seller(id, name, email, phoneNumber, DatabaseLocationPostgres.getLocationById(locationId));
            return seller;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void removeSeller(int id){
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM seller WHERE id = "+id+";";
            stmt = c.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
