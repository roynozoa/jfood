/*
 * komen
 *///asd
public class JFood
{
    // instance variables - replace the example below with your own
    //Seller seller1;
    public static void main(String[] args){
        
        Location lokasi = new Location("Jakarta Timur", "DKI Jakarta", "Lokasi jajan gorengan");
        Seller tukangGorengan = new Seller(003, "Muhammad Adisatriyo Pratama","muhammad.adisatriyo@ui.ac.id", "081297449833", lokasi);
        Food gorengan = new Food(002,"Gorengan", tukangGorengan, 1000, FoodCategory.Snacks);
        
        
        
        gorengan.printData();
        
        
        
        
    }
}
