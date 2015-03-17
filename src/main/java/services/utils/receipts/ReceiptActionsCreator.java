package services.utils.receipts;

import forms.ReceiptActionsForm;
import forms.ReceiptForm;
import jpa.*;
import jpa.dao.*;
import jpa.enums.ActionStatusEnum;
import jpa.enums.ReceivingOrdersStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
@Transactional
public class ReceiptActionsCreator {

    @Autowired
    private ReceivingOrderDAO receivingOrderDAO;
    @Autowired
    private ReceivingOrderLineDAO receivingOrderLineDAO;
    @Autowired
    private ReceiptActionDAO receiptActionDAO;
    @Autowired
    private LocateActionDAO locateActionDAO;
    @Autowired
    private IncomingDockDAO incomingDockDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ActionStatusDAO actionStatusDAO;
    @Autowired
    private ReceivingOrdersStatusDAO receivingOrdersStatusDAO;

    public void create(ReceiptForm receiptForm, String username) {

        String deliveryNote = receiptForm.getDeliveryNote();
        User user = userDAO.getUserByUsername(username);
        IncomingDock incomingDock = incomingDockDAO.getIncomingDockById(receiptForm.getDockId());

        Boolean allLinesCompleted = true;

        for (ReceiptActionsForm receiptActionsForm : receiptForm.getReceiptActionsForms()) {

            ReceivingOrderLine receivingOrderLine = receivingOrderLineDAO.getReceivingOrderLineById(receiptActionsForm.getReceivingOrderLine());
            ReceiptAction receiptAction = new ReceiptAction();

            receiptAction.setDeliveryNote(deliveryNote);
            receiptAction.setRecQuantity(receiptActionsForm.getRecQuantity());
            receiptAction.setReceivedAt(new Date());
            receiptAction.setIncomingDock(incomingDock);
            receiptAction.setReceivingOrderLine(receivingOrderLine);
            receiptAction.setPicker(user);

            receiptActionDAO.addReceiptAction(receiptAction);

            receivingOrderLine.setPendingQuantity(receivingOrderLine.getPendingQuantity() - receiptActionsForm.getRecQuantity());

            receivingOrderLineDAO.updateReceivingOrderLine(receivingOrderLine);

            LocateAction locateAction = new LocateAction();
            locateAction.setReceiptAction(receiptAction);
            locateAction.setStatus(actionStatusDAO.getActionStatusByStatus(ActionStatusEnum.CR));

            locateActionDAO.addLocateAction(locateAction);

            if (receivingOrderLine.getPendingQuantity() > 0) {
                allLinesCompleted = false;
            }
        }

        if (allLinesCompleted) {
            receivingOrderDAO.getReceivingOrderByCode(receiptForm.getOrderCode())
                    .setStatus(receivingOrdersStatusDAO.getReceivingOrdersStatusByStatus(ReceivingOrdersStatusEnum.CO));
        } else {
            receivingOrderDAO.getReceivingOrderByCode(receiptForm.getOrderCode())
                    .setStatus(receivingOrdersStatusDAO.getReceivingOrdersStatusByStatus(ReceivingOrdersStatusEnum.PR));
        }
    }
}
