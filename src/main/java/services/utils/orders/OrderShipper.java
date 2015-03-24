package services.utils.orders;

import forms.OrderShipping;
import forms.OrdersShippingForm;
import jpa.Container;
import jpa.Order;
import jpa.dao.ContainerDAO;
import jpa.dao.ContainerStatusDAO;
import jpa.dao.OrderDAO;
import jpa.dao.OrdersStatusDAO;
import jpa.enums.ContainerStatusEnum;
import jpa.enums.OrdersStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OrderShipper {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OrdersStatusDAO ordersStatusDAO;
    @Autowired
    private ContainerDAO containerDAO;
    @Autowired
    private ContainerStatusDAO containerStatusDAO;

    public void ship(OrdersShippingForm ordersShippingForm) {

        for (OrderShipping orderShipping : ordersShippingForm.getOrderShippings()) {

            if (orderShipping.getShipped() != null && orderShipping.getShipped()) {

                Order order = orderDAO.getOrderById(orderShipping.getOrderId());

                Container container = containerDAO.getContainerByOrder(order);

                if (OrdersStatusEnum.DO.equals(order.getStatus().getStatus()) && ContainerStatusEnum.DO.equals(container.getStatus().getStatus())) {

                    order.setStatus(ordersStatusDAO.getOrdersStatusByStatus(OrdersStatusEnum.SH));
                    container.setStatus(containerStatusDAO.getContainerStatusByStatus(ContainerStatusEnum.SH));

                    orderDAO.updateOrder(order);
                    containerDAO.updateContainer(container);
                }
            }
        }
    }
}
