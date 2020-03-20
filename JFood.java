import java.util.Calendar;  
public class JFood
{
    public static void main(String[] args){
        Calendar tanggal = Calendar.getInstance();
        Customer pembeliDua = new Customer(002, "Dua", "email@pembeli.com", "P@sswordModul5",2020, 3, 12);
        
        
        //Post Test
        Location lokasi = new Location("Jakarta Timur", "DKI Jakarta", "Lokasi jajan gorengan");
        Seller tukangGorengan = new Seller(003, "Muhammad Adisatriyo Pratama","muhammad.adisatriyo@ui.ac.id", "081297449833", lokasi);
        Promo promoCashback = new Promo(001, "Promo Cashback", 5000, 20000, true);
        Food gorengan = new Food(002,"Gorengan",tukangGorengan, 25000, FoodCategory.Snacks);
        Invoice strukSatu = new CashlessInvoice(001, gorengan, pembeliDua, InvoiceStatus.Ongoing, promoCashback);
        Invoice strukDua = new CashInvoice(001, gorengan, pembeliDua, InvoiceStatus.Ongoing);
        
        System.out.println(strukSatu.toString());
        System.out.println(strukDua.toString());
    }
}
