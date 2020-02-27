/*
 * komen
 *///asd
public class JFood
{
    // instance variables - replace the example below with your own
    //Seller seller1;
    public static void main(String[] args){
        Location lokasiSellerDua = new Location("Depok", "Jawa Barat", "Ini adalah alamat tukang nasi goreng");
        Seller sellerDua = new Seller(002, "Tukang Nasi Goreng","email1", "nomor HP", lokasiSellerDua);
        Food nasiGoreng = new Food(001,"Nasi Goreng", sellerDua, 20000, "Makanan berat");
        Customer pembeliSatu = new Customer (001, "Saya", "emailcustomer", "ini password","baru join tadi");
        Invoice strukNasiGoreng = new Invoice (001, 001, "Sekarang", pembeliSatu, 20000);
        
        lokasiSellerDua.printData();
        sellerDua.printData();
        pembeliSatu.printData();
        
        
    }
}
