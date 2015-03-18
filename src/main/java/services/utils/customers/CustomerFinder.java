package services.utils.customers;

import jpa.Customer;
import jpa.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerFinder {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer find(String nif) throws CustomerNotFoundException {
        Customer customer = customerDAO.getCustomerByNif(nif);
        if (customer != null) {
            return customer;
        } else {
            throw new CustomerNotFoundException("Customer nor found.");
        }
    }
}
