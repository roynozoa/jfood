/**
 * Kelas DatabaseInvoice berguna untuk menyimpan database invoice
 *
 * @author (Muhammad Adisatriyo Pratama)
 * @version (9/4/2020)
 */
package adisatriyo.jfood;

import java.util.ArrayList;

public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException {
        for(Invoice invoice : INVOICE_DATABASE){
            if(invoice.getId() == id){
                return invoice;
            }
        }
        throw new InvoiceNotFoundException(id);
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId) throws CustomerNotFoundException {
        ArrayList<Invoice> LIST_INVOICE_BY_CUSTOMER = new ArrayList<>();
        Customer customer = DatabaseCustomer.getCustomerById(customerId);
        for(Invoice invoice : INVOICE_DATABASE){
            if(customer.equals(invoice.getCustomer())){
                LIST_INVOICE_BY_CUSTOMER.add(invoice);
            }
        }
        return LIST_INVOICE_BY_CUSTOMER;
    }

    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException {
        for(Invoice struk : INVOICE_DATABASE){
            if(struk.getId() == invoice.getId() && struk.getInvoiceStatus() == InvoiceStatus.Ongoing){
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;

    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus){
        for(Invoice invoice : INVOICE_DATABASE){
            if(invoice.getInvoiceStatus() == InvoiceStatus.Ongoing && invoice.getId() == id){
                invoice.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    public static boolean removeInvoice(int id) throws InvoiceNotFoundException {
        for(Invoice invoice : INVOICE_DATABASE){
            if(invoice.getId()== id){
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }


}
