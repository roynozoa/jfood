package adisatriyo.jfood.databases;

import adisatriyo.jfood.*;

import java.sql.*;

public class DatabaseInvoiceStatusPostgres extends DatabaseConnection{

    public static String insertInvoiceStatus(String invoiceStatus) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String sql = "INSERT INTO invoiceStatus (status) VALUES ('"+invoiceStatus+"');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return invoiceStatus;
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
            String sql = "SELECT id from invoiceStatus;";
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

    public static String getInvoiceStatus(String invoiceStatus)
    {
        Connection c = connection();
        PreparedStatement stmt;
        String status = null;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT status FROM invoiceStatus WHERE status = '"+invoiceStatus+"';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                status = rs.getString("status");
            }
            rs.close();
            stmt.close();
            c.close();
            if (status == null){
                return null;
            }
            else {
                return status;
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }

}
