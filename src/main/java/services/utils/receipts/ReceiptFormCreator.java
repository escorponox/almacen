package services.utils.receipts;

import forms.ReceiptActionsForm;
import forms.ReceiptForm;
import forms.ReceiptSelectForm;
import jpa.ReceivingOrder;
import jpa.ReceivingOrderLine;
import jpa.dao.IncomingDockDAO;
import jpa.dao.ReceivingOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReceiptFormCreator {

    @Autowired
    private ReceivingOrderDAO receivingOrderDAO;
    @Autowired
    private IncomingDockDAO incomingDockDAO;

    public ReceiptForm create(ReceiptSelectForm receiptSelectForm) {

        ReceiptForm receiptForm = new ReceiptForm();

        ReceivingOrder receivingOrder = receivingOrderDAO.getReceivingOrderByCode(receiptSelectForm.getOrderCode());
        List<ReceivingOrderLine> receivingOrderLines = receivingOrder.getReceivingOrderLinesByOrder();

        receiptForm.setOrderCode(receiptSelectForm.getOrderCode());
        receiptForm.setDeliveryNote(receiptSelectForm.getDeliveryNote());
        receiptForm.setDockId(receiptSelectForm.getDockId());
        receiptForm.setDockName(incomingDockDAO.getIncomingDockById(receiptSelectForm.getDockId()).getName());
        receiptForm.setProviderCode(receivingOrder.getProvider().getNif());
        receiptForm.setProviderName(receivingOrder.getProvider().getName());

        for (ReceivingOrderLine receivingOrderLine : receivingOrderLines) {

            ReceiptActionsForm receiptActionsForm = new ReceiptActionsForm();

            receiptActionsForm.setReceivingOrderLine(receivingOrderLine.getId());
            receiptActionsForm.setItemCode(receivingOrderLine.getItem().getCode());
            receiptActionsForm.setItemName(receivingOrderLine.getItem().getName());
            receiptActionsForm.setPendingQuantity(receivingOrderLine.getPendingQuantity());
            receiptActionsForm.setRecQuantity(0L);

            receiptForm.getReceiptActionsForms().add(receiptActionsForm);
        }

        return receiptForm;
    }
}
