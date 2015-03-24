package services.utils.orders;

import forms.OrdersShippingForm;
import jpa.Order;
import jpa.dao.OrderDAO;
import jpa.enums.OrdersStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class OrdersShippingFormValidator {

    @Autowired
    private OrderDAO orderDAO;

    public void validate(OrdersShippingForm ordersShippingForm, BindingResult bindingResult) {

        for (int i = 0; i < ordersShippingForm.getOrderShippings().size(); i++) {

            Order order = orderDAO.getOrderById(ordersShippingForm.getOrderShippings().get(i).getOrderId());

            if (order == null) {

                bindingResult.rejectValue("orderShippings" + i + "].orderId",
                        "order.notFound",
                        "Order not found.");

            } else if (!order.getStatus().getStatus().equals(OrdersStatusEnum.DO)) {

                bindingResult.rejectValue("orderShippings" + i + "].orderId",
                        "order.badStatus",
                        "Order not in docks.");
            }
        }
    }
}
