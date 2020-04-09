/**
 * Kelas Seller berguna untuk menyimpan data penjual
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (9/4/2020)
 */
public class Seller{
    //merupakan field dari kelas Seller
    private int id;
    private String name,email,phoneNumber;
    Location location;

    /**
     * Merupakan constructor dari kelas Seller
     */
    public Seller(int id, String name, String email, String phoneNumber, Location location){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }
    
    /**
     * Metode getID untuk mendapatknan id penjual
     *
     * 
     * @return    id seller
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * Metode getName untuk mendapatknan nama penjual
     *
     * 
     * @return    nama seller
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Metode getEmail untuk mendapatknan email penjual
     *
     * 
     * @return    email seller
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * Metode getPhoneNumber untuk mendapatknan nomor hp penjual
     *
     * 
     * @return    nomor hp seller
     */
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    
    /**
     * Metode getLocation untuk mendapatknan locasi penjual
     *
     * 
     * @return    id seller
     */
    public Location getLocation(){
        return this.location;
    }
    
    /**
     * Metode setID untuk mengatur id penjual
     *
     * 
     * @param    id seller
     */
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * Metode setName untuk mengatur nama penjual
     *
     * 
     * @param    nama seller
     */
    public void setName(String name){
        this.name = name;
    }   
    
    /**
     * Metode setEmail untuk mengatur email penjual
     *
     * 
     * @param    email seller
     */
    public void setEmail(String email){
        this.email = email;
    }
    
    /**
     * Metode setPhoneNumber untuk mengatur nomoer hp penjual
     *
     * 
     * @param    nomor hp seller
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Metode setLocation untuk mengatur lokasi penjual
     *
     * 
     * @param    lokasi seller
     */
    public void setLocation(Location location){
        this.location = location;
    }
    
    public String toString(){
        return String.format("Id=" + getId() + "\n" + 
                            "Nama=" + getName() + "\n" + 
                            "PhoneNumber=" + getPhoneNumber() + "\n" +
                            "Location=" + getLocation());
    }
    /*
     * Metode printData untuk menampilkan nama penjual
     *
     * 
     * 
    
    public void printData(){
        //print data
        System.out.println(name);
    }
     */
}
