public class PriceCalculator implements Runnable {
    private Invoice invoice;

    public PriceCalculator(Invoice invoice){
        this.invoice = invoice;
    }

    @Override
    public void run() {
        System.out.println("Calculating Invoice ID: " + invoice.getId());
        invoice.setTotalPrice();
        System.out.println("Finish Calculating Invoice ID: " + invoice.getId());

    }

}
