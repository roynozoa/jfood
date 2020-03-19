import java.util.Calendar;  
public class JFood
{
    public static void main(String[] args){
        Calendar tanggal = Calendar.getInstance();
        Customer pembeliSatu = new Customer(001, "Satu", "email salah", "password salah", tanggal);
        Customer pembeliDua = new Customer(002, "Dua", "email@pembeli.com", "P@sswordModul5",2020, 3, 12);
        Customer pembeliTiga = new Customer(003, "Tiga", "email@pembeli.com", "P@sswordModul5");
        
        
        
        
        System.out.println(pembeliSatu.toString());
        System.out.println(pembeliDua.toString());
        System.out.println(pembeliTiga.toString());
    }
}
