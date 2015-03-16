package forms;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

public class ReceiptForm {

    @NotNull
    private Long orderCode;

    @NotNull
    private String deliveryNote;

    @NotNull
    private Long dockId;

    private String dockName;

    private String providerCode;

    private String providerName;


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
