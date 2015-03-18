package services.utils.customers;

import jpa.Customer;
import jpa.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {

    @Autowired
    private CustomerDAO customerDAO;

    public void validateRegistrationForm(Customer customer, ValidationContext context) {

        MessageContext messages = context.getMessageContext();

        if (customerDAO.getCustomerByNif(customer.getNif()) != null) {
            messages.addMessage(new MessageBuilder().error().source("nif")
                    .defaultText("NIF already in use.").build());
        }
    }
}
