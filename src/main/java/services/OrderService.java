package services;

import forms.OrdersReleaseForm;
import forms.OrdersShippingForm;
import jpa.*;
import jpa.dao.OutgoingDockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import services.domain.FillItemDataResponse;
import services.utils.customers.CustomerCreator;
import services.utils.customers.CustomerFinder;
import services.utils.customers.CustomerNotFoundException;
import services.utils.items.ItemCodeSearcher;
import services.utils.items.ItemFinder;
import services.utils.orders.*;

import java.util.List;

@Service("orderService")
public class OrderService {

    @Autowired
    private OutgoingDockDAO outgoingDockDAO;
    @Autowired
    private CustomerFinder customerFinder;
    @Autowired
    private CustomerCreator customerCreator;
    @Autowired
    private ItemFinder itemFinder;
    @Autowired
    private OrderCreator orderCreator;
    @Autowired
    private ItemCodeSearcher itemCodeSearcher;
    @Autowired
    private UserService userService;
    @Autowired
    private ReleaseCandidatesFinder releaseCandidatesFinder;
    @Autowired
    private OrderReleaseFormValidator orderReleaseFormValidator;
    @Autowired
    private OrderLauncher orderLauncher;
    @Autowired
    private ShippingCandidatesFinder shippingCandidatesFinder;
    @Autowired
    private OrdersShippingFormValidator ordersShippingFormValidator;
    @Autowired
    private OrderShipper orderShipper;

    public Customer findCustomer(String nif) throws CustomerNotFoundException {
        return customerFinder.find(nif);
    }

    public void addCustomer(Customer customer) {
        customerCreator.create(customer);
    }

    public void setOrderSeller(Order order, String userName) {
        order.setSeller(userService.getUserByUsername(userName));
    }

    public OrderLine createLine(Order order, String code, Long quantity) {

        Item item = itemFinder.find(code);

        OrderLine orderLine = new OrderLine();
        orderLine.setOrder(order);
        orderLine.setItem(item);
        orderLine.setLineNumber((long) (order.getOrderLines().size() + 1));
        orderLine.setOrderedQuantity(quantity);
        orderLine.setPendingQuantity(quantity);

        return orderLine;
    }

    public void createOrder(Order order) {
        orderCreator.create(order);
    }

    public List<String> searchItemCodes(String tagName) {
        return itemCodeSearcher.search(tagName);
    }

    public FillItemDataResponse fillItemData(String itemcode) {

        FillItemDataResponse fillItemDataResponse = new FillItemDataResponse();

        Item item = itemFinder.find(itemcode);

        if (item != null) {
            fillItemDataResponse.setErrorCode("0");
            fillItemDataResponse.getData().setItemName(item.getName());
            fillItemDataResponse.getData().setItemPrice(item.getPrice());
        } else {
            fillItemDataResponse.setErrorCode("-1");
            fillItemDataResponse.setErrorDescription("No item found.");
        }

        return fillItemDataResponse;
    }

    public List<OutgoingDock> getAllOutgoingDocks() {
        return outgoingDockDAO.listAll();
    }


    public OrdersReleaseForm getReleaseCandidates() {

        return releaseCandidatesFinder.find();
    }

    public void validate(OrdersReleaseForm ordersReleaseForm, BindingResult bindingResult) {

        orderReleaseFormValidator.validateOrders(ordersReleaseForm, bindingResult);
        orderReleaseFormValidator.validateDocks(ordersReleaseForm, bindingResult);
    }

    public void releaseOrders(OrdersReleaseForm ordersReleaseForm) {

        orderLauncher.launch(ordersReleaseForm);
    }

    public OrdersShippingForm getShippingCandidates() {
        return shippingCandidatesFinder.find();
    }

    public void validate(OrdersShippingForm ordersShippingForm, BindingResult bindingResult) {

        ordersShippingFormValidator.validate(ordersShippingForm, bindingResult);
    }

    public void shipOrders(OrdersShippingForm ordersShippingForm) {

        orderShipper.ship(ordersShippingForm);
    }
}