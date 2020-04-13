import java.util.ArrayList;
import java.util.Calendar;

public class JFood
{
    public static void main(String[] args) throws FoodNotFoundException, CustomerNotFoundException {
        System.out.println("=====POST TEST MODUL 7=====");
        //Membuat beberapa objek yang diperlukan untuk mendukung pembuatan objek Invoice
        Location lokasi = new Location("Kota Depok", "Jawa Barat", "Lokasi jajan gorengan");
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Muhammad Adisatriyo Pratama","muhammad.adisatriyo@ui.ac.id", "081297449833", lokasi));

        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1,"Muhammad Adisatriyo 1", "emailbeda@ui.ac.id", "P@sswordModul7", Calendar.getInstance()));
        } catch (EmailAlreadyExistsException e){
            System.err.println(e.getMessage());
        }

        try {
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "Promo Cashback", 10000, 20000, true));
        } catch (PromoCodeAlreadyExistsException e){
            System.err.println(e.getMessage());
        }

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

        //MULAI MEMBUAT OBJEK INVOICE SEPERTI KETENTUAN SOAL
        try {
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, LIST_FOOD, DatabaseCustomer.getCustomerById(1), InvoiceStatus.Ongoing, DatabasePromo.getPromoByCode("Promo Cashback")));
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId(), LIST_FOOD, DatabaseCustomer.getCustomerById(1), InvoiceStatus.Ongoing, DatabasePromo.getPromoByCode("Promo Cashback")));
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.err.println(e.getMessage());
        }

        try{
            DatabaseInvoice.removeInvoice(40);
        } catch (InvoiceNotFoundException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("YANG MASUK KE DATABASE INVOICE");
        for(Invoice invoice : DatabaseInvoice.getInvoiceDatabase()){
            System.out.println(invoice.toString());
        }

    }
}
