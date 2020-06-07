package adisatriyo.jfood.databases;

import adisatriyo.jfood.*;

import java.sql.*;
import java.util.ArrayList;

public class DatabasePromoPostgres extends DatabaseConnection {

    public static Promo insertPromo(Promo promo) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String code = promo.getCode();
            int discount = promo.getDiscount();
            int minPrice = promo.getMinPrice();
            boolean active = promo.getActive();
            int id = promo.getId();
            String sql = "INSERT INTO promo (id, code, discount, minPrice, active) VALUES ('"+id+"','"+code+"','"+discount+"','"+minPrice+"','"+active+"');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return promo;
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
            String sql = "SELECT id from promo;";
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

    public static ArrayList<Promo> getPromoDatabase()
    {
        ArrayList<Promo> promos = new ArrayList<>();
        Connection c = connection();
        PreparedStatement stmt;
        Promo promo = null;
        int id = 0;
        String code = null;
        int discount = 0;
        int minPrice = 0;
        boolean active = false;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM promo;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                id = rs.getInt("id");
                code = rs.getString("code");
                discount  = rs.getInt("discount");
                minPrice = rs.getInt("minPrice");
                active = rs.getBoolean("active");
                promos.add(new Promo(id, code, discount, minPrice, active));
            }
            rs.close();
            stmt.close();
            c.close();
            if (id == 0){
                return null;
            }
            else{
                return promos;
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }

    public static Promo getPromoByCode(String promoCode)
    {
        Connection c = connection();
        PreparedStatement stmt;
        Promo promo = null;
        int id = 0;
        String code = null;
        int discount = 0;
        int minPrice = 0;
        boolean active = false;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM promo WHERE code = '"+promoCode+"';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                id = rs.getInt("id");
                code = rs.getString("code");
                discount  = rs.getInt("discount");
                minPrice = rs.getInt("minPrice");
                active = rs.getBoolean("active");
            }
            rs.close();
            stmt.close();
            c.close();
            if (id == 0){
                return null;
            }
            else{
                promo = new Promo(id, code, discount, minPrice, active);
                return promo;
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }


}
