package services.utils.customers;

public class CustomerNotFoundException extends Exception {

    private static final long serialVersionUID = 4967563852903455034L;

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
