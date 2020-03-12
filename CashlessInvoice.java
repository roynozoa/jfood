public class CashlessInvoice extends Invoice{
    private PaymentType PAYMENT_TYPE = PaymentType.Cashless; 
    private Promo promo;
    
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus){
        super(id, food, date, customer, invoiceStatus);
    }
    
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, Promo promo){
        super(id, food, date, customer, invoiceStatus);
        this.promo = promo;
    }
    
    
    public PaymentType getPaymentType(){
        return PAYMENT_TYPE;
    }
    
   
    public Promo getPromo(){
        return promo;
    }
    
    public void setPromo(Promo promo){
        this.promo = promo;
    }
    
    public void setTotalPrice(){
        
        if (promo!= null  && getPromo().getActive() == true && getFood().getPrice() > getPromo().getMinPrice()){
            this.totalPrice = getFood().getPrice() - getPromo().getDiscount();
        } else{
            this.totalPrice = getFood().getPrice();
        }
        
        
    }
    
    public void printData(){
        //if (promo!= null  ){
            System.out.println("==========INVOICE==========");
            System.out.println("ID: "+ super.getId());
            System.out.println("Food: " + getFood().getName());
            System.out.println("Date: " + super.getDate());
            System.out.println("Customer: " + getCustomer().getName());
            System.out.println("Total Price: " +totalPrice);
            System.out.println("Payment Type: " + getPaymentType());
        /*} else{
            System.out.println("==========INVOICE==========");
            System.out.println("ID: "+ super.getId());
            System.out.println("Food: " + super.getFood());
            System.out.println("Date: " + super.getDate());
            System.out.println("Customer: " + getCustomer().getName());
            System.out.println("Promo: "+ getPromo().getCode());
            System.out.println("Total Price: " +totalPrice);
            System.out.println("Payment Type: " + getPaymentType());
        }
        
        
        
        /*
        System.out.println("==========INVOICE==========");
        System.out.println("ID: "+ id);
        System.out.println("Food ID: "+ idFood);
        System.out.println("Date: "+ date);
        System.out.println("Customer: "+ customer.getName());
        System.out.println("Total Price: "+ totalPrice);
        System.out.println("Status: "+ status);
        */
    }
   
}
