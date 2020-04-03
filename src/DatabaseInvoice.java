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

    public static Invoice getInvoiceById(int id){
        for(Invoice invoice : INVOICE_DATABASE){
            if(invoice.getId() == id){
                return invoice;
            }
        }
        return null;
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customerid){
        ArrayList<Invoice> LIST_INVOICE_BY_CUSTOMER = new ArrayList<Invoice>();
        for(Invoice invoice : INVOICE_DATABASE){
            if(invoice.getCustomer().getId() == customerid){
                LIST_INVOICE_BY_CUSTOMER.add(invoice);
            }
        }
        return LIST_INVOICE_BY_CUSTOMER;
    }

    public static boolean addInvoice(Invoice invoice){
        for(Invoice struk : INVOICE_DATABASE){
            if(struk.getInvoiceStatus() != InvoiceStatus.Ongoing){
                INVOICE_DATABASE.add(invoice);
                lastId = struk.getId();
                return true;
            }
        }
        return false;

    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus){
        for(Invoice struk : INVOICE_DATABASE){
            if(struk.getInvoiceStatus() == InvoiceStatus.Ongoing && struk.getId() == id){
                struk.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    public static boolean removeInvoice(int id){
        for(Invoice struk : INVOICE_DATABASE){
            if(struk.getId()== id){
                INVOICE_DATABASE.remove(struk);
                return true;
            }
        }
        return false;
    }


}
