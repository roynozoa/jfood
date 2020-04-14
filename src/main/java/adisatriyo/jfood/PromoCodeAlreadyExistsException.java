package adisatriyo.jfood;

public class PromoCodeAlreadyExistsException extends Exception {
    private Promo promo_error;

    public PromoCodeAlreadyExistsException(Promo promo_input) {
        super("Promo Code: ");
        this.promo_error = promo_input;
    }

    public String getMessage()
    {
        return super.getMessage() + promo_error.getCode() + " not found. \n";
    }
}
