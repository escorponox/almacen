package forms;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedList;
import java.util.List;

public class ReceiptForm {

    @NotNull
    @Min(value = 1, message = "Code must be greater than one")
    private Long orderCode;

    @NotNull
    @Size(min = 1, message = "Delivery note is empty")
    private String deliveryNote;

    @NotNull
    @Min(value = 1, message = "Dock id must be greater than one")
    private Long dockId;

    private String dockName;

    private String providerCode;

    private String providerName;

    @Valid
    private List<ReceiptActionsForm> receiptActionsForms;

    public ReceiptForm() {
        receiptActionsForms = new LinkedList<>();
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

    public Long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Long orderCode) {
        this.orderCode = orderCode;
    }

    public List<ReceiptActionsForm> getReceiptActionsForms() {
        return receiptActionsForms;
    }

    public void setReceiptActionsForms(List<ReceiptActionsForm> receiptActionsForms) {
        this.receiptActionsForms = receiptActionsForms;
    }

    public String getDockName() {
        return dockName;
    }

    public void setDockName(String dockName) {
        this.dockName = dockName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }
}
