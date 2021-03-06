/**
 * Kelas Location berguna untuk menyimpan alamat
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (9/4/2020)
 */
package adisatriyo.jfood;

public class Location{
    //merupakan field dari kelas Location
    int id;
    String province, description, city;
    
    /**
     * Merupakan constructor dari kelas Location
     */
    public Location(int id, String city, String province, String description){
        this.id = id;
        this.city = city;
        this.province = province;
        this.description = description;
    }


    public int getId()
    {
        return id;
    }

    /**
     * Metode getProvince untuk mendapatknan lokasi provinsi
     *
     * 
     * @return    provinsi
     */
    public String getProvince(){
        return this.province = province;
    }
    
     /**
     * Metode getCity untuk mendapatknan lokasi kota
     *
     * 
     * @return    kota
     */
    public String getCity(){
        return this.city = city;
    }
    
    /**
     * Metode getDescription untuk mendapatknan deskripsi lokasi     *
     * 
     * @return    deskripsi
     */
    public String getDescription(){
        return this.description = description;
    }
    
    /**
     * Metode setProvince untuk mengatur lokasi provinsi
     *
     *
     * @param //provinsi
     */

    public void setId(int id){
        this.id = id;
    }

    public void setProvince(String province){
        this.province = province;
    }
    
     /**
     * Metode setCity untuk mengatur lokasi kota
     *
     * 
     * @param //kota
     */
    public void setCity(String city){
        this.city = city;
    }
    
     /**
     * Metode setDescription untuk mengatur deskripsi lokasi
     *
     * 
     * @param    //deskripsi
     */
    public void setDescription(String description){
        this.description = description;
    }
    
    public String toString(){
        return String.format("Province=" + getProvince() + "\n" + 
                            "City=" + getCity() + "\n" + 
                            "Description=" + getDescription());
                            
    }
    
    /*
     * Metode printData untuk menampilkan nama penjual
     *
     * 
     * 
     
    public void printData(){
        System.out.println(province);
        //print data
    }
    */

}