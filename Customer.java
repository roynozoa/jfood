/*
 * komen
 */

public class Customer {
    private int id;
    private String name,email, password, joinDate;
    
    public Customer(int id, String name, String email, String password, String joinDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }
    
    public int getId(){
        return this.id = id;
    }
    
    public String getName(){
        return this.name = name;
    }
    
    public String getEmail(){
        return this.email = email;
    }
    
    public String getPassword(){
        return this.password = password;
    }
    
    public String getJoinDate(){
        return this.joinDate = joinDate;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setJoinDate(String joinDate){
        this.joinDate = joinDate;
    }
    
    public void printData(){
        //print data
        System.out.println(name);
    }

}