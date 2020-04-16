

/**
 * Kelas databaseceller berguna untuk menyimpan database pembeli
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (9/4/2020)
 */

package adisatriyo.jfood;

import java.util.ArrayList;


public class DatabaseCustomer{

    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Customer> getCustomerDatabase(){
        return CUSTOMER_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Customer getCustomerById(int id) throws CustomerNotFoundException {
        for(Customer customer : CUSTOMER_DATABASE){
            if(customer.getId() == id){
                return customer;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistsException{
        for(Customer cust : CUSTOMER_DATABASE){
            if(cust.getEmail() == customer.getEmail()){
                throw new EmailAlreadyExistsException(customer);
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
        return true;
    }

    public static boolean removeCustomer(int id) throws CustomerNotFoundException {
        for(Customer customer : CUSTOMER_DATABASE){
            if(customer.getId() == id){
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    public static Customer getCustomerLogin(String email, String password) {
        for (Customer customer : CUSTOMER_DATABASE) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }
}