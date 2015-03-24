package forms;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

public class OrdersShippingForm {

    @Valid
    @NotNull
    private List<OrderShipping> orderShippings;

    public OrdersShippingForm() {

        orderShippings = new LinkedList<>();
    }

    public List<OrderShipping> getOrderShippings() {
        return orderShippings;
    }

    public void setOrderShippings(List<OrderShipping> orderShippings) {
        this.orderShippings = orderShippings;
    }
}
