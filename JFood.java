public class JFood
{
    public static void main(String[] args){
        
        Location lokasi = new Location("Jakarta Timur", "DKI Jakarta", "Lokasi jajan gorengan");
        Seller tukangGorengan = new Seller(003, "Muhammad Adisatriyo Pratama","muhammad.adisatriyo@ui.ac.id", "081297449833", lokasi);
        Customer pembeli = new Customer(001, "Pembeli", "email@pembeli.com", "inipassword", "05-03-2020");
        Promo promoCashback = new Promo(001, "Promo Cashback", 5000, 20000, true);
        Promo promoCashback2 = new Promo(001, "Promo Cashback 2", 5000, 30000, true);
        Food gorengan = new Food(002,"Gorengan",tukangGorengan, 25000, FoodCategory.Snacks);
        Invoice struk = new CashlessInvoice(001, gorengan, "12/03/2020", pembeli, InvoiceStatus.Ongoing);
        Invoice struk2 = new CashlessInvoice(002, gorengan, "12/03/2020", pembeli, InvoiceStatus.Ongoing, promoCashback2);
        Invoice struk3 = new CashlessInvoice(003, gorengan, "12/03/2020", pembeli, InvoiceStatus.Ongoing, promoCashback);
          
        struk.printData();
        struk2.printData();
        struk3.printData();
        
       
    }
}
