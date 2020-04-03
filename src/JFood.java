import java.sql.SQLOutput;
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

        System.out.println("!!!LIST OF SNACKS FOOD!!!!");
        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.Snacks))
        {
            System.out.println(food.toString());
        }

        System.out.println("=====POST TEST MODUL 6=====");
        Promo promoCashback = new Promo(001, "Promo Cashback", 5000, 20000, false);
        Promo promoCashbackDua = new Promo(002, "Promo Cashback", 5000, 20000, true);

        System.out.println(promoCashback.toString());
        System.out.println(promoCashbackDua.toString());

        ArrayList<Food> LIST_FOOD_SATU = new ArrayList<>();
        LIST_FOOD_SATU.add(DatabaseFood.getFoodById(1));

        ArrayList<Food> LIST_FOOD_DUA = new ArrayList<>();
        LIST_FOOD_DUA.add(DatabaseFood.getFoodById(1));

        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1, LIST_FOOD_SATU, DatabaseCustomer.getCustomerById(1), InvoiceStatus.Ongoing, 1));

        for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
        {
            invoice.setTotalPrice();
        }


        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, LIST_FOOD_SATU, DatabaseCustomer.getCustomerById(1), InvoiceStatus.Ongoing, promoCashback));

        for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
        {
            invoice.setTotalPrice();
        }

        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            System.out.println(invoice.toString());
        }

        DatabaseInvoice.changeInvoiceStatus(1, InvoiceStatus.Finished);

        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, LIST_FOOD_SATU, DatabaseCustomer.getCustomerById(2), InvoiceStatus.Ongoing, promoCashback));

        promoCashback.setActive(true);
        promoCashbackDua.setActive(false);

        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            invoice.setTotalPrice();
        }

        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            System.out.println(invoice.toString());
        }



    }
}
