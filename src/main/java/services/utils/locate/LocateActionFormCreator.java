package services.utils.locate;

import forms.LocateActionForm;
import jpa.LocateAction;
import org.springframework.stereotype.Component;

@Component
public class LocateActionFormCreator {

    public LocateActionForm create(LocateAction locateAction) {

        if (locateAction == null) {
            return null;
        } else {

            LocateActionForm locateActionForm = new LocateActionForm();
            locateActionForm.setLocateActionId(locateAction.getId());
            locateActionForm.setDockName(locateAction.getReceiptAction().getIncomingDock().getName());
            locateActionForm.setItemCode(locateAction.getReceiptAction().getReceivingOrderLine().getItem().getCode());
            locateActionForm.setItemName(locateAction.getReceiptAction().getReceivingOrderLine().getItem().getName());
            locateActionForm.setQuantity(locateAction.getReceiptAction().getRecQuantity());
            locateActionForm.setDestination(locateAction.getReceiptAction().getReceivingOrderLine().getItem().getLocation().getName());

            return locateActionForm;
        }
    }
}
