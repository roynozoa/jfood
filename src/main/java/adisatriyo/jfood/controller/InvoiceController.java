package adisatriyo.jfood.controller;

import adisatriyo.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController

public class InvoiceController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id) {
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;

        }
        return invoice;
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomerId(@PathVariable int customerId) {
        ArrayList<Invoice> invoiceByCustomer = null;
        try {
            invoiceByCustomer = DatabaseInvoice.getInvoiceByCustomer(customerId);
        } catch (CustomerNotFoundException e) {
            e.getMessage();
            return null;

        }
        return invoiceByCustomer;
    }


    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value= "status") InvoiceStatus status){
        Invoice invoice;
        if(DatabaseInvoice.changeInvoiceStatus(id, status)){
            try {
                invoice = DatabaseInvoice.getInvoiceById(id);
                return invoice;
            } catch (InvoiceNotFoundException e) {
                e.getMessage();
            }
        }
        return null;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id){
        try {
            DatabaseInvoice.removeInvoice(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
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
            try {
                LIST_FOOD.add(DatabaseFood.getFoodById(i));
            } catch (FoodNotFoundException e) {
                e.getMessage();
            }
        }

        Invoice invoice = null;
        try {
            invoice = new CashInvoice(DatabaseInvoice.getLastId()+1, LIST_FOOD, DatabaseCustomer.getCustomerById(customerId), InvoiceStatus.Ongoing, deliveryFee);
        } catch (CustomerNotFoundException e) {
            e.getMessage();
        }
        try {
            DatabaseInvoice.addInvoice(invoice);

        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
        invoice.setTotalPrice();
        return invoice;
    }

    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value = "foodList") ArrayList<Integer> foodList,
                                      @RequestParam(value = "customerId") int customerId,
                                      @RequestParam(value = "promoCode", required = false) String promoCode){

        ArrayList<Food> LIST_FOOD = new ArrayList<>();
        for(int i : foodList){
            try {
                LIST_FOOD.add(DatabaseFood.getFoodById(i));
            } catch (FoodNotFoundException e) {
                e.getMessage();
            }
        }
        Invoice invoice = null;
        try {
            invoice = new CashlessInvoice(DatabaseInvoice.getLastId()+1, LIST_FOOD, DatabaseCustomer.getCustomerById(customerId), InvoiceStatus.Ongoing, DatabasePromo.getPromoByCode(promoCode));
        } catch (CustomerNotFoundException e) {
            e.getMessage();
        }
        try {
            DatabaseInvoice.addInvoice(invoice);

        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
        invoice.setTotalPrice();
        return invoice;
    }





}
