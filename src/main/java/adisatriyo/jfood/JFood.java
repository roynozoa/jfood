package adisatriyo.jfood;


import adisatriyo.jfood.databases.DatabaseCustomerPostgres;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JFood {

    public static void main(String[] args) {
//        Location lokasiSatu = new Location("Kota Depok", "Jawa Barat", "Pasar");
//
//        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Muhammad Adisatriyo Pratama","muhammad.adisatriyo@ui.ac.id", "081297449833", lokasiSatu));
//
//        try {
//            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Cireng", DatabaseSeller.getSellerById(1), 25000, "Snacks"));
//            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakwan", DatabaseSeller.getSellerById(1), 25000, "Snacks"));
//        } catch (SellerNotFoundException e) {
//            System.err.println(e.getMessage());
//        }'

//        System.out.println(DatabaseCustomerPostgres.getLastId()+1);

        SpringApplication.run(JFood.class, args);

    }

}
