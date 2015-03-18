package services;

import jpa.Customer;
import jpa.Item;
import jpa.Order;
import jpa.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;
import services.utils.customers.CustomerCreator;
import services.utils.customers.CustomerFinder;
import services.utils.customers.CustomerNotFoundException;
import services.utils.items.ItemFinder;
import services.utils.orders.ItemNotFoundException;
import services.utils.orders.NegativeQuantityException;
import services.utils.orders.QuantityChecker;

@Service("orderService")
public class OrderService {

    @Autowired
    private CustomerFinder customerFinder;
    @Autowired
    private CustomerCreator customerCreator;
    @Autowired
    private ItemFinder itemFinder;
    @Autowired
    private QuantityChecker quantityChecker;


    public Customer findCustomer(String nif) throws CustomerNotFoundException {
        return customerFinder.find(nif);
    }

    public void addCustomer(Customer customer) throws TransactionSystemException {
        customerCreator.create(customer);
    }

    public OrderLine createLine(Order order, String code, Long quantity) throws ItemNotFoundException, NegativeQuantityException {

        Item item = itemFinder.find(code);
        Long checkedQuantity = quantityChecker.check(quantity);

        OrderLine orderLine = new OrderLine();
        orderLine.setOrder(order);
        orderLine.setItem(item);
        orderLine.setLineNumber((long) (order.getOrderLines().size() + 1));
        orderLine.setOrderedQuantity(checkedQuantity);
        orderLine.setPendingQuantity(checkedQuantity);

        return orderLine;
    }

}