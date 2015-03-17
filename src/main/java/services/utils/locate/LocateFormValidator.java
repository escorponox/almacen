package services.utils.locate;

import forms.LocateActionForm;
import jpa.LocateAction;
import jpa.dao.LocateActionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class LocateFormValidator {

    @Autowired
    private LocateActionDAO locateActionDAO;

    public void validate(LocateActionForm locateActionForm, BindingResult bindingResult) {

        LocateAction locateAction = locateActionDAO.getLocateActionById(locateActionForm.getLocateActionId());

        if (locateAction != null && !locateAction.getReceiptAction().getReceivingOrderLine().getItem().getLocation().getName().equals(locateActionForm.getLocationConfirmation())) {
            bindingResult.rejectValue("locationConfirmation", "error.locate.badLocation", "Please confirm destination.");
        }
    }
}
