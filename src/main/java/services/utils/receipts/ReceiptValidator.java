package services.utils.receipts;

import forms.ReceiptActionsForm;
import jpa.IncomingDock;
import jpa.ReceiptAction;
import jpa.ReceivingOrder;
import jpa.ReceivingOrderLine;
import jpa.dao.IncomingDockDAO;
import jpa.dao.ReceiptActionDAO;
import jpa.dao.ReceivingOrderDAO;
import jpa.dao.ReceivingOrderLineDAO;
import jpa.enums.ReceivingOrdersStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;

@Component
public class ReceiptValidator {

    @Autowired
    private ReceivingOrderDAO receivingOrderDAO;
    @Autowired
    private ReceivingOrderLineDAO receivingOrderLineDAO;
    @Autowired
    private ReceiptActionDAO receiptActionDAO;
    @Autowired
    private IncomingDockDAO incomingDockDAO;

    public void validateOrderCode(Long orderCode, BindingResult bindingResult) {

        ReceivingOrder receivingOrder = receivingOrderDAO.getReceivingOrderByCode(orderCode);

        if (receivingOrder == null) {
            bindingResult.rejectValue("orderCode", "error.receipt.orderCode", "The order does not exists");
        } else if (receivingOrder.getStatus().getStatus() == ReceivingOrdersStatusEnum.CO
                || receivingOrder.getStatus().getStatus() == ReceivingOrdersStatusEnum.CL) {
            bindingResult.rejectValue("orderCode", "error.receipt.orderCode", "The order is completed or closed");
        }
    }

    public void validateDeliveryNote(String deliveryNote, BindingResult bindingResult) {

        List<ReceiptAction> receiptActions = receiptActionDAO.getReceiptActionByDeliveryNote(deliveryNote);

        if (receiptActions.size() > 0) {
            bindingResult.rejectValue("deliveryNote", "error.receipt.deliveryNote", "DeliveryNote already received");
        }
    }

    public void validateDock(Long dockId, BindingResult bindingResult) {

        IncomingDock incomingDock = incomingDockDAO.getIncomingDockById(dockId);

        if (incomingDock == null) {
            bindingResult.rejectValue("dockId", "error.receipt.dockId", "Non existent dock");
        }
    }

    public void validateLines(List<ReceiptActionsForm> receiptActionsForms, BindingResult bindingResult) {

        Boolean oneQuantityValid = false;

        for (int i = 0; i < receiptActionsForms.size(); i++) {

            ReceivingOrderLine receivingOrderLine = receivingOrderLineDAO.getReceivingOrderLineById(receiptActionsForms.get(i).getReceivingOrderLine());
            if (receivingOrderLine == null) {
                bindingResult.reject("error.receipt.lineNumbers", "Receiving order lines not found.");
            }

            if (receiptActionsForms.get(i).getRecQuantity() > receivingOrderLine.getPendingQuantity()) {
                bindingResult.rejectValue("receiptActionsForms[" + i + "].recQuantity", "error.receiptAction.quantity", "Can't receive more than pending quantity");
            }

            if (receiptActionsForms.get(i).getRecQuantity() > 0) {
                oneQuantityValid = true;
            }
        }

        if (!oneQuantityValid) {
            bindingResult.reject("error.receipt.noStockReceived", "No stock received.");
        }

    }

    public IncomingDockDAO getIncomingDockDAO() {
        return incomingDockDAO;
    }
}
