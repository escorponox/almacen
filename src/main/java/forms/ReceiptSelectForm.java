package forms;

import javax.validation.constraints.NotNull;

public class ReceiptSelectForm {

    @NotNull
    private Long orderCode;

    @NotNull
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
