package forms;

import java.math.BigDecimal;

public class SalaryOrder {

    private Long orderCode;
    private BigDecimal orderTotal;
    private BigDecimal orderCommission;

    public Long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Long orderCode) {
        this.orderCode = orderCode;
    }

    public BigDecimal getOrderCommission() {
        return orderCommission;
    }

    public void setOrderCommission(BigDecimal orderCommission) {
        this.orderCommission = orderCommission;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }
}