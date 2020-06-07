package adisatriyo.jfood.databases;

import adisatriyo.jfood.Customer;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DatabaseCustomerPostgres extends DatabaseConnection {
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();

    public static ArrayList<Customer> getCustomerDatabase() {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        Customer customer = null;
        try {
            String sql = "SELECT * FROM customer;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
                customer = new Customer(id, name, email, password);
                CUSTOMER_DATABASE.add(customer);
            }
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CUSTOMER_DATABASE;
    }


    public static Customer insertCustomer(int id, String name, String email, String password) {
        Connection c = connection();
        PreparedStatement stmt;
        Customer customer = null;
        try {
            c.setAutoCommit(false);

            String sql = "INSERT INTO customer (id, name, email, password) VALUES ('"+id+"','"+name+"','"+email+"','"+password+"');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            customer = new Customer(id, name, email, password);
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public static int getLastId() {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id FROM customer;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
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

    public static Customer getCustomerById(int id_cust) {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        Customer customer = null;
        try {
            String sql = "SELECT * FROM customer WHERE id=?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, id_cust);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
            }
            stmt.close();
            c.close();
            customer = new Customer(id, name, email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }


    public static boolean removeCustomer(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM customer WHERE id=?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            c.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Customer getCustomerLogin(String emailcust, String passwordcust) {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        Customer customer = null;
        try {
            String sql = "SELECT id, name, email, password FROM customer WHERE email=? AND password=?;";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, emailcust);
            stmt.setString(2, passwordcust);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
            }
            stmt.close();
            c.close();
            customer = new Customer(id, name, email, password);
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
