import java.util.ArrayList;
import java.util.Calendar;
public class JFood
{
    public static void main(String[] args){
        Location lokasi = new Location("Jakarta Timur", "DKI Jakarta", "Lokasi jajan gorengan");

        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Muhammad Adisatriyo Pratama","muhammad.adisatriyo@ui.ac.id", "081297449833", lokasi));

        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1,"Muhammad Adisatriyo", "muhammad.adisatriyo@ui.ac.id", "P@sswordModul6", Calendar.getInstance()));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1,"Muhammad Adisatriyo", "muhammad.adisatriyo@ui.ac.id", "P@sswordModul6", Calendar.getInstance()));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1,"Bang Fadel", "emailbangfadel@email.com", "P@sswordModul6", Calendar.getInstance()));

        for (Customer cust : DatabaseCustomer.getCustomerDatabase()) {
            System.out.println(cust.toString());
        }

        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Cireng", DatabaseSeller.getSellerById(1), 25000, FoodCategory.Snacks));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakwan", DatabaseSeller.getSellerById(1), 25000, FoodCategory.Snacks));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Roti", DatabaseSeller.getSellerById(1), 25000, FoodCategory.Bakery));

        for (Food food : DatabaseFood.getFoodDatabase()) {
            System.out.println(food.toString());
        }
        
        //Testing setTotalPrice
        Promo promoCashback = new Promo(001, "Promo Cashback", 5000, 20000, true);
        Invoice strukSatu = new CashlessInvoice(001, DatabaseFood.getFoodDatabase(), DatabaseCustomer.getCustomerById(1), InvoiceStatus.Ongoing, promoCashback);
        Invoice strukDua = new CashInvoice(001, DatabaseFood.getFoodDatabase(), DatabaseCustomer.getCustomerById(1), InvoiceStatus.Ongoing);

        System.out.println(strukSatu.toString());
        System.out.println(strukDua.toString());

    }
}
