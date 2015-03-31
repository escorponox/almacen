package services.utils.orders;

import jpa.Order;
import jpa.OrderLine;
import jpa.dao.OrderLineDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderTotalAmountCalculator {

    @Autowired
    private OrderLineDAO orderLineDAO;

    public BigDecimal calculate(Order order) {

        BigDecimal total = BigDecimal.ZERO;

        for (OrderLine orderLine : orderLineDAO.getOrderLinesByOrder(order)) {
            total = total.add(orderLine.getItem().getPrice().multiply(BigDecimal.valueOf(orderLine.getOrderedQuantity())));
        }

        return total;
    }
}