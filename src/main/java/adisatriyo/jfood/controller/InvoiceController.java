package adisatriyo.jfood.controller;

import adisatriyo.jfood.*;
import adisatriyo.jfood.databases.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/invoice")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController

public class InvoiceController {

    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice() {
        ArrayList<Invoice> invoiceList;
        try {
            invoiceList = DatabaseInvoice.getInvoiceDatabase();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return invoiceList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id) {
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return invoice;
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomerId(@PathVariable int customerId) throws CustomerNotFoundException{
        return DatabaseInvoice.getInvoiceByCustomer(customerId);
    }


    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value= "status") String status){
        Invoice invoice;
        DatabaseInvoice.changeInvoiceStatus(id, status);
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
        }
        catch (Exception error) {
            error.getMessage();
            return null;
        }
        return invoice;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id){
        try {
            DatabaseInvoice.removeInvoice(id);
        }
        catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value = "foodList") ArrayList<Integer> foodList,
                                  @RequestParam(value = "customerId") int customerId,
                                  @RequestParam(value = "deliveryFee",required = false, defaultValue = "0") int deliveryFee) {

        ArrayList<Food> LIST_FOOD = new ArrayList<>();
        for(int i : foodList){
            LIST_FOOD.add(DatabaseFoodPostgres.getFoodById(i));

        }

        try{
            Invoice invoice = new CashInvoice(DatabaseInvoice.getLastId() + 1, LIST_FOOD, DatabaseCustomerPostgres.getCustomerById(customerId), deliveryFee);
            DatabaseInvoice.addInvoice(invoice);
            invoice.setTotalPrice();
            return invoice;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;

    }

    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value = "foodList") ArrayList<Integer> foodList,
                                      @RequestParam(value = "customerId") int customerId,
                                      @RequestParam(value = "promoCode", required = false) String promoCode){

        ArrayList<Food> LIST_FOOD = new ArrayList<>();
        for(int i : foodList){
            LIST_FOOD.add(DatabaseFoodPostgres.getFoodById(i));

        }

        Promo promo = DatabasePromoPostgres.getPromoByCode(promoCode);
        try{
            Invoice invoice = new CashlessInvoice(DatabaseInvoice.getLastId() + 1, LIST_FOOD, DatabaseCustomerPostgres.getCustomerById(customerId), DatabasePromoPostgres.getPromoByCode(promoCode));
            DatabaseInvoice.addInvoice(invoice);
            invoice.setTotalPrice();
            return invoice;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;


    }








}
