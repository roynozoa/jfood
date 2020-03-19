import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;  

/**
 * Kelas Customer berguna untuk menyimpan data pembeli
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (19/03/2020)
 */
public class Customer {
    //merupakan field dari kelas Customer
    private int id;
    private String name;
    private String email;
    private String password;
    private Calendar joinDate;
        
    public Customer(int id, String name, String email, String password, Calendar joinDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }
    
    public Customer(int id, String name, String email, String password, int year, int month, int dayOfMonth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
        //joinDate.set(year, month, dayOfMonth);
    }
    
    public Customer(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        
    }
    
    /**
     * Metode getID untuk mendapatknan id customer
     *
     * 
     * @return    id customer
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * Metode getName untuk mendapatknan nama customer
     *
     * 
     * @return    nama customer
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Metode getEmail untuk mendapatknan email customer
     *
     * 
     * @return    email customer
     */
    public String getEmail(){
        return this.email;
    }
    
    /**
     * Metode getPassword untuk mendapatknan password customer
     *
     * 
     * @return    password customer
     */
    public String getPassword(){
        
        return this.password;
    }
    
    /**
     * Metode getJoinDate untuk mendapatkan tanggal bergabung customer
     *
     * 
     * @return    tanggal bergabung customer
     */
    
    public Calendar getJoinDate(){
        
        return this.joinDate; 
    }
    
    /**
     * Metode setID untuk mengatur id customer
     *
     * 
     * @param    id customer
     */
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * Metode setName untuk mengatur nama customer
     *
     * 
     * @param    nama customer
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Metode setEmail untuk mengatur email customer
     *
     * 
     * @param    email customer
     */
    public void setEmail(String email){
        String emailChecker = "[A-Za-z0-9&*_~]+@[A-Za-z0-9.-]";
        Pattern checkEmail = Pattern.compile(emailChecker);
        Matcher emailMatcher = checkEmail.matcher(email);
        if (emailMatcher.find()){
            this.email = emailMatcher.group().trim();
        }
        else {
            this.email = null;
        }
        
        
    }
    
    /**
     * Metode setPassword untuk mengatur password customer
     *
     * 
     * @param    password customer
     */
    public void setPassword(String password){
        String passwordChecker = "^(?=.*[0-9]).{6, }$";
        Pattern checkPassword = Pattern.compile(passwordChecker);
        Matcher passwordMatcher = checkPassword.matcher(password);
        if (passwordMatcher.find() ){
            this.password = passwordMatcher.group().trim();
        }
        else {
            this.password = null;
        }
        

        //this.password = password;
    }
    
    /**
     * Metode setJoinDate untuk mengatur tanggal bergabung customer
     *
     * 
     * @param    tanggal bergabung customer
     */
    public void setJoinDate(Calendar joinDate){
        this.joinDate = joinDate;
    }
    
    public void setJoinDate(int year, int month, int dayOfMonth){
        
        this.joinDate = joinDate;
    }
    
    public String toString(){
        SimpleDateFormat formatDate = new SimpleDateFormat ("dd MMMM yyyy");
        if (joinDate == null){
        return String.format("Id=" + getId() + "\n" + 
                            "Nama=" + getName() + "\n" + 
                            "Email=" + getEmail() + "\n" +
                            "Password=" + password + "\n" +
                            "Join Date=" + null + "\n");
        } else {
        return String.format("Id=" + getId() + "\n" + 
                            "Nama=" + getName() + "\n" + 
                            "Email=" + getEmail() + "\n" +
                            "Password=" + password + "\n" +
                            "Join Date=" + formatDate.format(joinDate.getTime()) + "\n");
        
        }
    }

}