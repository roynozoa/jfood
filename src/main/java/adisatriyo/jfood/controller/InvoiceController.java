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

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
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
                                       @RequestParam InvoiceStatus status){
        Invoice invoice = null;
        if (status == InvoiceStatus.Cancelled){
            DatabaseInvoice.changeInvoiceStatus(id, status);
            return invoice;
        } else if (status == InvoiceStatus.Finished){
            DatabaseInvoice.changeInvoiceStatus(id, status);
            return invoice;
        }
        return null;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id){
        Boolean invoice;
        try {
            invoice = DatabaseInvoice.removeInvoice(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return false;
        }

        return true;
    }

    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value = "foodList") ArrayList<Integer> foodList,
                                  @RequestParam(value = "customerId") int customerId,
                                  @RequestParam(value = "deliveryFee") int deliveryFee) throws CustomerNotFoundException, FoodNotFoundException {
        ArrayList<Food> LIST_FOOD = null;
        for(int i : foodList){
            LIST_FOOD.add(DatabaseFood.getFoodById(i));
        }

        Invoice invoice = new CashInvoice(DatabaseInvoice.getLastId()+1, LIST_FOOD, DatabaseCustomer.getCustomerById(customerId), InvoiceStatus.Ongoing, deliveryFee);
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
                                      @RequestParam(value = "promoCode") String promoCode) throws CustomerNotFoundException, FoodNotFoundException {

        ArrayList<Food> LIST_FOOD = null;
        for(int i : foodList){
            LIST_FOOD.add(DatabaseFood.getFoodById(i));
        }
        Invoice invoice = new CashlessInvoice(DatabaseInvoice.getLastId()+1, LIST_FOOD, DatabaseCustomer.getCustomerById(customerId), InvoiceStatus.Ongoing, DatabasePromo.getPromoByCode(promoCode));
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
