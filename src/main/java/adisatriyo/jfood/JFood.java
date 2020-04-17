package adisatriyo.jfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JFood {

    public static void main(String[] args) {
        Location lokasiSatu = new Location("Kota Depok", "Jawa Barat", "Margo City");
        Location lokasiDua = new Location("Kota Depok", "Jawa Barat", "Pasar");
        Location lokasiTiga = new Location("Kota Depok", "Jawa Barat", "Kantin Teknik");

        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Muhammad Adisatriyo Pratama","muhammad.adisatriyo@ui.ac.id", "081297449833", lokasiSatu));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Muhammad Adisatriyo Pratama","muhammad.adisatriyo@ui.ac.id", "081297449833", lokasiDua));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Muhammad Adisatriyo Pratama","muhammad.adisatriyo@ui.ac.id", "081297449833", lokasiTiga));

        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Cireng", DatabaseSeller.getSellerById(1), 25000, FoodCategory.Snacks));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakwan", DatabaseSeller.getSellerById(1), 25000, FoodCategory.Snacks));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Roti", DatabaseSeller.getSellerById(1), 25000, FoodCategory.Bakery));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Kue", DatabaseSeller.getSellerById(1), 25000, FoodCategory.Bakery));
        } catch (SellerNotFoundException e) {
            System.err.println(e.getMessage());
        }

        SpringApplication.run(JFood.class, args);
    }

}
