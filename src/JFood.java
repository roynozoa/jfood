import java.util.ArrayList;
import java.util.Calendar;

public class JFood
{
    public static void main(String[] args) throws FoodNotFoundException, CustomerNotFoundException {
        System.out.println("=====MODUL 7=====");
        Location lokasi = new Location("Kota Depok", "Jawa Barat", "Lokasi jajan gorengan");

        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1,"Muhammad Adisatriyo 1", "emailbeda@ui.ac.id", "P@sswordModul7", Calendar.getInstance()));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1,"Muhammad Adisatriyo 2", "emailbeda2@ui.ac.id", "P@sswordModu7", Calendar.getInstance()));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1,"Muhammad Adisatriyo 3", "emailsama@email.com", "P@sswordModul6", Calendar.getInstance()));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1,"Muhammad Adisatriyo 3", "emailsama@email.com", "P@sswordModul6", Calendar.getInstance()));
        } catch (EmailAlreadyExistsException e){
            System.err.println(e.getMessage());
        }

        try {
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "Promo Cashback", 10000, 20000, true));
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "Promo Cashback", 10000, 20000, true));

        } catch (PromoCodeAlreadyExistsException e){
            System.err.println(e.getMessage());
        }

        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Cireng", DatabaseSeller.getSellerById(1), 25000, FoodCategory.Snacks));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakwan", DatabaseSeller.getSellerById(1), 25000, FoodCategory.Snacks));
        } catch (SellerNotFoundException e){
            System.err.println(e.getMessage());
        }

        try {
            DatabaseCustomer.removeCustomer(50);
        } catch (CustomerNotFoundException e){
            System.err.println(e.getMessage());
        }

        try {
            DatabasePromo.removePromo(99);
        } catch (PromoNotFoundException e){
            System.err.println(e.getMessage());
        }

        try {
            DatabaseFood.removeFood(100);
        } catch (FoodNotFoundException e){
            System.err.println(e.getMessage());
        }

        System.out.println("=====YANG MASUK KE DATABASE=====");

        for (Customer cust : DatabaseCustomer.getCustomerDatabase()) {
            System.out.println(cust.toString());
        }

        for(Promo promo : DatabasePromo.getPromoDatabase()){
            System.out.println(promo.toString());
        }

        System.out.println("=====THREADING=====");

        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Muhammad Adisatriyo Pratama","muhammad.adisatriyo@ui.ac.id", "081297449833", lokasi));

        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Cireng", DatabaseSeller.getSellerById(1), 25000, FoodCategory.Snacks));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakwan", DatabaseSeller.getSellerById(1), 25000, FoodCategory.Snacks));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Roti", DatabaseSeller.getSellerById(1), 25000, FoodCategory.Bakery));
        } catch (SellerNotFoundException e){
            System.err.println(e.getMessage());
        }

        ArrayList<Food> LIST_FOOD = new ArrayList<>();
        LIST_FOOD.add(DatabaseFood.getFoodById(1));
        LIST_FOOD.add(DatabaseFood.getFoodById(2));
        LIST_FOOD.add(DatabaseFood.getFoodById(3));

        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, LIST_FOOD, DatabaseCustomer.getCustomerById(1), InvoiceStatus.Finished, DatabasePromo.getPromoByCode("Promo Cashback")));
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, LIST_FOOD, DatabaseCustomer.getCustomerById(2), InvoiceStatus.Finished, DatabasePromo.getPromoByCode("Promo Cashback")));
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, LIST_FOOD, DatabaseCustomer.getCustomerById(3), InvoiceStatus.Finished, DatabasePromo.getPromoByCode("Promo Cashback")));

        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            if (invoice.totalPrice == 0)
            {
                invoice.start();
            }
        }

        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            Thread priceCalculate = new Thread(new PriceCalculator(invoice));
            priceCalculate.start();
        }


    }
}
