public class Location{
    String province, description, city;
    
    public Location(String city, String province, String description){
        this.city = city;
        this.province = province;
        this.description = description;
    }
    
    public String getProvince(){
        return this.province = province;
    }
    
    public String getCity(){
        return this.city = city;
    }
    
    public String getDescription(){
        return this.description = description;
    }
    
    public void setProvince(String province){
        this.province = province;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void printData(){
        System.out.println(province);
        //print data
    }

}