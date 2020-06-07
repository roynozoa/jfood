package adisatriyo.jfood.controller;

import adisatriyo.jfood.*;
import adisatriyo.jfood.databases.DatabaseCustomer;
import adisatriyo.jfood.databases.DatabaseCustomerPostgres;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CustomerController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomer() {
        return DatabaseCustomerPostgres.getCustomerDatabase();
    }

    @RequestMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        Customer customer = null;
        customer = DatabaseCustomerPostgres.getCustomerById(id);

        return customer;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Customer registerCustomer(@RequestParam(value="name") String name,
                                     @RequestParam(value="email") String email,
                                     @RequestParam(value="password") String password)
    {
        String regexEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern patternEmail = Pattern.compile(regexEmail);
        Matcher matcherEmail = patternEmail.matcher(email);

        String regexPass = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern patternPass = Pattern.compile(regexPass);
        Matcher matcherPass = patternPass.matcher(password);
        if(matcherEmail.matches() && matcherPass.matches()){
            return DatabaseCustomerPostgres.insertCustomer(DatabaseCustomerPostgres.getLastId()+1, name, email, password);
        } else {
            return null;
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Customer loginCustomer(@RequestParam(value = "email") String email,
                                  @RequestParam(value = "password") String password) {
        Customer customer = DatabaseCustomerPostgres.getCustomerLogin(email, password);
        return customer;
    }



}