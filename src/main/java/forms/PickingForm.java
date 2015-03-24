package forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PickingForm implements Serializable {

    private static final long serialVersionUID = 1121804102538773311L;

    @NotNull(message = "No action given")
    private Long pickingActionId;

    private Long orderCode;
    private Long orderLine;

    private String locationName;

    private String itemCode;
    private String itemName;

    @NotEmpty(message = "Please confirm the item code")
    private String itemCodeConfirmation;

    private Long ordered;

    @Min(value = 0, message = "Please confirm picked quantity")
    private Long picked;

    public Long getPickingActionId() {
        return pickingActionId;
    }

    public void setPickingActionId(Long pickingActionId) {
        this.pickingActionId = pickingActionId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemCodeConfirmation() {
        return itemCodeConfirmation;
    }

    public void setItemCodeConfirmation(String itemCodeConfirmation) {
        this.itemCodeConfirmation = itemCodeConfirmation;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Long orderCode) {
        this.orderCode = orderCode;
    }

    public Long getOrdered() {
        return ordered;
    }

    public void setOrdered(Long ordered) {
        this.ordered = ordered;
    }

    public Long getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(Long orderLine) {
        this.orderLine = orderLine;
    }

    public Long getPicked() {
        return picked;
    }

    public void setPicked(Long picked) {
        this.picked = picked;
    }
}
