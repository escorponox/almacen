package services;

import forms.ReceiptForm;
import forms.ReceiptSelectForm;
import jpa.IncomingDock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import services.utils.receipts.ReceiptActionsCreator;
import services.utils.receipts.ReceiptFormCreator;
import services.utils.receipts.ReceiptValidator;

import java.util.List;

@Service
@Transactional
public class ReceiptService {

    @Autowired
    private ReceiptValidator receiptValidator;
    @Autowired
    private ReceiptFormCreator receiptFormCreator;
    @Autowired
    private ReceiptActionsCreator receiptActionsCreator;


    public List<IncomingDock> getAllIncomingDocks() {
        return receiptValidator.getIncomingDockDAO().listAll();
    }

    public void validate(ReceiptSelectForm receiptSelectForm, BindingResult bindingResult) {

        receiptValidator.validateOrderCode(receiptSelectForm.getOrderCode(), bindingResult);
        receiptValidator.validateDeliveryNote(receiptSelectForm.getDeliveryNote(), bindingResult);
        receiptValidator.validateDock(receiptSelectForm.getDockId(), bindingResult);
    }

    public ReceiptForm createReceipt(ReceiptSelectForm receiptSelectForm) {

        return receiptFormCreator.create(receiptSelectForm);
    }

    public void validate(ReceiptForm receiptForm, BindingResult bindingResult) {

        receiptValidator.validateOrderCode(receiptForm.getOrderCode(), bindingResult);
        receiptValidator.validateDeliveryNote(receiptForm.getDeliveryNote(), bindingResult);
        receiptValidator.validateDock(receiptForm.getDockId(), bindingResult);

        receiptValidator.validateLines(receiptForm.getReceiptActionsForms(), bindingResult);
    }

    public void createReceiptActions(ReceiptForm receiptForm, String username) {
        receiptActionsCreator.create(receiptForm, username);
    }


}
