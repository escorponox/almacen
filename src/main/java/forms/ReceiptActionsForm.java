package forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ReceiptActionsForm {

    @NotNull(message = "Line not found.")
    private Long receivingOrderLine;
    private String itemCode;
    private String itemName;
    private Long pendingQuantity;

    @Min(value = 0, message = "Can't receive negative quantity.")
    private Long recQuantity;

    public Long getReceivingOrderLine() {
        return receivingOrderLine;
    }

    public void setReceivingOrderLine(Long receivingOrderLine) {
        this.receivingOrderLine = receivingOrderLine;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getPendingQuantity() {
        return pendingQuantity;
    }

    public void setPendingQuantity(Long pendingQuantity) {
        this.pendingQuantity = pendingQuantity;
    }

    public Long getRecQuantity() {
        return recQuantity;
    }

    public void setRecQuantity(Long recQuantity) {
        this.recQuantity = recQuantity;
    }
}
