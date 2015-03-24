package services.utils.orders;

import forms.OrderShipping;
import forms.OrdersShippingForm;
import jpa.Order;
import jpa.dao.ContainerDAO;
import jpa.dao.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShippingCandidatesFinder {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private ContainerDAO containerDAO;


    public OrdersShippingForm find() {

        OrdersShippingForm ordersShippingForm = new OrdersShippingForm();

        for (Order order : orderDAO.findAllShippingCandidates()) {

            OrderShipping orderShipping = new OrderShipping();
            orderShipping.setOrderId(order.getId());
            orderShipping.setOrderCode(order.getCode());
            orderShipping.setCustomerName(order.getCustomer().getName());
            orderShipping.setOrdersStatusEnum(order.getStatus().getStatus());
            orderShipping.setShipped(false);
            orderShipping.setDockName(containerDAO.getContainerByOrder(order).getOutgoingDock().getName());

            ordersShippingForm.getOrderShippings().add(orderShipping);
        }

        return ordersShippingForm;
    }
}
