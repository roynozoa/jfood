package adisatriyo.jfood;

public class OngoingInvoiceAlreadyExistsException extends Exception {
    private Invoice invoice_error;

    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input) {
        super("Ongoing Invoice: ");
        this.invoice_error = invoice_input;
    }

    public String getMessage() {
        return super.getMessage() + invoice_error.getId() + " already exist. \n";
    }
}
