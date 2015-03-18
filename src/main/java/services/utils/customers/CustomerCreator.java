package services.utils.customers;

import jpa.Customer;
import jpa.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CustomerCreator {

    @Autowired
    private CustomerDAO customerDAO;

    public void create(Customer customer) {
        customerDAO.addCustomer(customer);
    }

}
