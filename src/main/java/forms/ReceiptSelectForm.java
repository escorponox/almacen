package forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReceiptSelectForm {

    @NotNull
    @Min(value = 1, message = "Code must be greater than one")
    private Long orderCode;

    @NotNull
    @Size(min = 1, message = "Delivery note is empty")
    private String deliveryNote;

    @NotNull
    private Long dockId;

    public Long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Long orderCode) {
        this.orderCode = orderCode;
    }

    public String getDeliveryNote() {
        return deliveryNote;
    }

    public void setDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
    }

    public Long getDockId() {
        return dockId;
    }

    public void setDockId(Long dockId) {
        this.dockId = dockId;
    }
}
