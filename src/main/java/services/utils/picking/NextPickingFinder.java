package services.utils.picking;

import forms.PickingForm;
import jpa.Container;
import jpa.PickingAction;
import jpa.dao.PickingActionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NextPickingFinder {

    @Autowired
    private PickingActionDAO pickingActionDAO;

    public PickingForm find(Container container) throws PickingNotFoundException {

        PickingForm pickingForm = new PickingForm();

        PickingAction pickingAction = pickingActionDAO.getNextActionByContainer(container);

        if (pickingAction == null) {

            throw new PickingNotFoundException("No pickings found for this container");

        } else {

            pickingForm.setPickingActionId(pickingAction.getId());
            pickingForm.setOrderCode(pickingAction.getOrderLine().getOrder().getCode());
            pickingForm.setOrderLine(pickingAction.getOrderLine().getLineNumber());
            pickingForm.setLocationName(pickingAction.getOrderLine().getItem().getLocation().getName());
            pickingForm.setItemCode(pickingAction.getOrderLine().getItem().getCode());
            pickingForm.setItemName(pickingAction.getOrderLine().getItem().getName());
            pickingForm.setItemCodeConfirmation("");
            pickingForm.setOrdered(pickingAction.getOrdered());
            pickingForm.setPicked(0L);
        }

        return pickingForm;
    }
}
