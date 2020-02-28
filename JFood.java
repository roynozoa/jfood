/*
 * komen
 *///asd
public class JFood
{
    // instance variables - replace the example below with your own
    //Seller seller1;
    public static void main(String[] args){
        /*Location lokasiSellerDua = new Location("Depok", "Jawa Barat", "Ini adalah alamat tukang nasi goreng");
        Seller sellerDua = new Seller(002, "Tukang Nasi Goreng","email1", "nomor HP", lokasiSellerDua);
        Food nasiGoreng = new Food(001,"Nasi Goreng", sellerDua, 20000, "Makanan berat");
        Customer pembeliSatu = new Customer (001, "Saya", "emailcustomer", "ini password","baru join tadi");
        Invoice strukNasiGoreng = new Invoice (001, 001, "Sekarang", pembeliSatu, 20000);
        
        
        lokasiSellerDua.printData();
        sellerDua.printData();
        pembeliSatu.printData();*/
        
        //Soal post test
        Location lokasiPostTest = new Location("Jakarta Timur", "DKI Jakarta", "Ini adalah lokasi post test");
        Seller tukangGorengan = new Seller(003, "Muhammad Adisatriyo Pratama","muhammad.adisatriyo@ui.ac.id", "081297449833", lokasiPostTest);
        Food gorengan = new Food(002,"Gorengan", tukangGorengan, 1000, "Makanan ringang");
        Customer pembeliGorengan = new Customer (002, "Nama orang", "emailorang", "password","baru banget join");
        Invoice strukGorengan = new Invoice (002, 002, "hari ini", pembeliGorengan, 1000);
        
        System.out.println(tukangGorengan.getName());
        tukangGorengan.setName("Nama Aslab");
        System.out.println(tukangGorengan.getName());
        
        gorengan.printData();
        
        
        
        
    }
}
