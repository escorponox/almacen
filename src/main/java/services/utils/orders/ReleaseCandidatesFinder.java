package services.utils.orders;

import forms.OrderRelease;
import forms.OrdersReleaseForm;
import jpa.Order;
import jpa.dao.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReleaseCandidatesFinder {

    private static final Long DEFAULT_DOCK_ID = 1L;

    @Autowired
    private OrderDAO orderDAO;

    public OrdersReleaseForm find() {

        OrdersReleaseForm ordersReleaseForm = new OrdersReleaseForm();

        for (Order order : orderDAO.findAllReleaseCandidates()) {

            OrderRelease orderRelease = new OrderRelease();
            orderRelease.setOrderId(order.getId());
            orderRelease.setOrderCode(order.getCode());
            orderRelease.setCustomerName(order.getCustomer().getName());
            orderRelease.setOrdersStatusEnum(order.getStatus().getStatus());
            orderRelease.setReleased(false);
            orderRelease.setDockId(DEFAULT_DOCK_ID);

            ordersReleaseForm.getOrderReleases().add(orderRelease);
        }

        return ordersReleaseForm;
    }
}
