package services.utils.orders;

import forms.OrdersReleaseForm;
import jpa.Order;
import jpa.OutgoingDock;
import jpa.dao.OrderDAO;
import jpa.dao.OutgoingDockDAO;
import jpa.enums.OrdersStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class OrderReleaseFormValidator {

    private static final String RELEASES_PREFIX = "orderReleases[";

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OutgoingDockDAO outgoingDockDAO;

    public void validateOrders(OrdersReleaseForm ordersReleaseForm, BindingResult bindingResult) {

        for (int i = 0; i < ordersReleaseForm.getOrderReleases().size(); i++) {

            Order order = orderDAO.getOrderById(ordersReleaseForm.getOrderReleases().get(i).getOrderId());

            if (order == null) {

                bindingResult.rejectValue(RELEASES_PREFIX + i + "].orderId",
                        "order.notFound",
                        "Order not found.");

            } else if (!order.getStatus().getStatus().equals(OrdersStatusEnum.CR) && !order.getStatus().getStatus().equals(OrdersStatusEnum.DO)) {

                bindingResult.rejectValue(RELEASES_PREFIX + i + "].orderId",
                        "order.badStatus",
                        "Order not created or in docks.");
            }
        }

    }

    public void validateDocks(OrdersReleaseForm ordersReleaseForm, BindingResult bindingResult) {

        for (int i = 0; i < ordersReleaseForm.getOrderReleases().size(); i++) {

            OutgoingDock outgoingDock = outgoingDockDAO.getOutgoingDockById(ordersReleaseForm.getOrderReleases().get(i).getDockId());

            if (outgoingDock == null) {

                bindingResult.rejectValue(RELEASES_PREFIX + i + "].dockId",
                        "order.badStatus",
                        "Dock not found.");
            }
        }
    }
}