package forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LocateActionForm {

    private Long locateActionId;
    private String dockName;
    private String itemCode;
    private String itemName;
    private Long quantity;
    private String destination;

    @NotNull
    @Size(min = 1, message = "Please confirm destination")
    private String locationConfirmation;

    public Long getLocateActionId() {
        return locateActionId;
    }

    public void setLocateActionId(Long locateActionId) {
        this.locateActionId = locateActionId;
    }

    public String getDockName() {
        return dockName;
    }

    public void setDockName(String dockName) {
        this.dockName = dockName;
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLocationConfirmation() {
        return locationConfirmation;
    }

    public void setLocationConfirmation(String locationConfirmation) {
        this.locationConfirmation = locationConfirmation;
    }
}
