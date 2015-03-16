package services.utils.receipts;

import forms.ReceiptSelectForm;
import jpa.IncomingDock;
import jpa.ReceiptAction;
import jpa.ReceivingOrder;
import jpa.dao.IncomingDockDAO;
import jpa.dao.ReceiptActionDAO;
import jpa.dao.ReceivingOrderDAO;
import jpa.enums.ReceivingOrdersStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.Collection;

@Component
public class ReceiptSelectValidator {

    @Autowired
    private ReceivingOrderDAO receivingOrderDAO;
    @Autowired
    private ReceiptActionDAO receiptActionDAO;
    @Autowired
    private IncomingDockDAO incomingDockDAO;

    public void validateOrderCode(ReceiptSelectForm receiptSelectForm, BindingResult bindingResult) {

        ReceivingOrder receivingOrder = receivingOrderDAO.getReceivingOrderByCode(receiptSelectForm.getOrderCode());

        if (receivingOrder == null) {
            bindingResult.rejectValue("orderCode", "error.receipt.orderCode", "The order does not exists");
        } else if (receivingOrder.getStatus().getStatus() == ReceivingOrdersStatusEnum.CO
                || receivingOrder.getStatus().getStatus() == ReceivingOrdersStatusEnum.CL) {
            bindingResult.rejectValue("orderCode", "error.receipt.orderCode", "The order is completed or closed");
        }
    }

    public void validateDeliveryNote(ReceiptSelectForm receiptSelectForm, BindingResult bindingResult) {

        Collection<ReceiptAction> receiptActions = receiptActionDAO.getReceiptActionByDeliveryNote(receiptSelectForm.getDeliveryNote());

        if (receiptActions.size() > 0) {
            bindingResult.rejectValue("deliveryNote", "error.receipt.deliveryNote", "DeliveryNote already received");
        }
    }

    public void validateDock(ReceiptSelectForm receiptSelectForm, BindingResult bindingResult) {

        IncomingDock incomingDock = incomingDockDAO.getIncomingDockById(receiptSelectForm.getDockId());

        if (incomingDock == null) {
            bindingResult.rejectValue("dockId", "error.receipt.dockId", "Non existent dock");
        }
    }
}
