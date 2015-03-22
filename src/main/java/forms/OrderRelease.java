package forms;

import jpa.enums.OrdersStatusEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderRelease {

    @NotNull
    @Min(value = 1, message = "Order id is empty")
    private Long orderId;

    private Long orderCode;
    private String customerName;
    private OrdersStatusEnum ordersStatusEnum;

    private Boolean released;

    @NotNull(message = "Dock not selected")
    private Long dockId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Long orderCode) {
        this.orderCode = orderCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public OrdersStatusEnum getOrdersStatusEnum() {
        return ordersStatusEnum;
    }

    public void setOrdersStatusEnum(OrdersStatusEnum ordersStatusEnum) {
        this.ordersStatusEnum = ordersStatusEnum;
    }

    public Boolean getReleased() {
        return released;
    }

    public void setReleased(Boolean released) {
        this.released = released;
    }

    public Long getDockId() {
        return dockId;
    }

    public void setDockId(Long dockId) {
        this.dockId = dockId;
    }
}
