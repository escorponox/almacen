package forms;

import jpa.enums.OrdersStatusEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderShipping {

    @NotNull
    @Min(value = 1, message = "Order id is empty")
    private Long orderId;

    private Long orderCode;
    private String customerName;
    private OrdersStatusEnum ordersStatusEnum;

    private Boolean shipped;

    private String dockName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDockName() {
        return dockName;
    }

    public void setDockName(String dockName) {
        this.dockName = dockName;
    }

    public Long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Long orderCode) {
        this.orderCode = orderCode;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrdersStatusEnum getOrdersStatusEnum() {
        return ordersStatusEnum;
    }

    public void setOrdersStatusEnum(OrdersStatusEnum ordersStatusEnum) {
        this.ordersStatusEnum = ordersStatusEnum;
    }

    public Boolean getShipped() {
        return shipped;
    }

    public void setShipped(Boolean shipped) {
        this.shipped = shipped;
    }
}
