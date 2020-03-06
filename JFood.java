/*
 * komen
 *///asd
public class JFood
{
    // instance variables - replace the example below with your own
    //Seller seller1;
    public static void main(String[] args){
        /*
        Location lokasi = new Location("Jakarta Timur", "DKI Jakarta", "Lokasi jajan gorengan");
        Seller tukangGorengan = new Seller(003, "Muhammad Adisatriyo Pratama","muhammad.adisatriyo@ui.ac.id", "081297449833", lokasi);
        Food gorengan = new Food(002,"Gorengan", tukangGorengan, 1000, FoodCategory.Snacks);
        
        
        
        gorengan.printData();
        */
        //SOAL POST TEST
        Location lokasi = new Location("Jakarta Timur", "DKI Jakarta", "Lokasi jajan gorengan");
        Seller tukangGorengan = new Seller(003, "Muhammad Adisatriyo Pratama","muhammad.adisatriyo@ui.ac.id", "081297449833", lokasi);
        Food gorengan = new Food(002,"Gorengan", tukangGorengan, 1000, FoodCategory.Snacks);
        Customer pembeli = new Customer(001, "Pembeli", "email@pembeli.com", "inipassword", "05-03-2020");
        Invoice struk = new Invoice (001, 002, "06-03-2020", 1000000, pembeli, PaymentType.Cash, InvoiceStatus.Finished);
        
        struk.printData();
        
        
        
        
    }
}
