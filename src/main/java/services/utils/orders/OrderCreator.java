package services.utils.orders;

import jpa.Order;
import jpa.OrderLine;
import jpa.dao.OrderDAO;
import jpa.dao.OrderLineDAO;
import jpa.dao.OrdersStatusDAO;
import jpa.enums.OrdersStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OrderCreator {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OrderLineDAO orderLineDAO;
    @Autowired
    private OrdersStatusDAO ordersStatusDAO;

    public void create(Order order) {

        order.setStatus(ordersStatusDAO.getOrdersStatusByStatus(OrdersStatusEnum.CR));
        order.setCode(orderDAO.getOrderCodeFromSequence());

        orderDAO.addOrder(order);

        for (OrderLine orderLine : order.getOrderLines()) {
            orderLineDAO.addOrderLine(orderLine);
        }
    }
}
