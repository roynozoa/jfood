/*
 * komen
 */
/**
 * Kelas Customer berguna untuk menyimpan data pembeli
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (3.0 12/03/2020)
 */
public class Customer {
    //merupakan field dari kelas Customer
    private int id;
    private String name,email, password, joinDate;
    
    public Customer(int id, String name, String email, String password, String joinDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }
    
    /**
     * Metode getID untuk mendapatknan id customer
     *
     * 
     * @return    id customer
     */
    public int getId(){
        return this.id = id;
    }
    
    /**
     * Metode getName untuk mendapatknan nama customer
     *
     * 
     * @return    nama customer
     */
    public String getName(){
        return this.name = name;
    }
    
    /**
     * Metode getEmail untuk mendapatknan email customer
     *
     * 
     * @return    email customer
     */
    public String getEmail(){
        return this.email = email;
    }
    
    /**
     * Metode getPassword untuk mendapatknan password customer
     *
     * 
     * @return    password customer
     */
    public String getPassword(){
        return this.password = password;
    }
    
    /**
     * Metode getJoinDate untuk mendapatkan tanggal bergabung customer
     *
     * 
     * @return    tanggal bergabung customer
     */
    
    public String getJoinDate(){
        return this.joinDate = joinDate;
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
        this.email = email;
    }
    
    /**
     * Metode setPassword untuk mengatur password customer
     *
     * 
     * @param    password customer
     */
    public void setPassword(String password){
        this.password = password;
    }
    
    /**
     * Metode setJoinDate untuk mengatur tanggal bergabung customer
     *
     * 
     * @param    tanggal bergabung customer
     */
    public void setJoinDate(String joinDate){
        this.joinDate = joinDate;
    }
    
    /**
     * Metode printData untuk menampilkan nama penjual
     *
     * 
     * 
     */
    public void printData(){
        //print data
        System.out.println(name);
    }

}