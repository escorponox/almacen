package services;

import forms.ReceiptForm;
import forms.ReceiptSelectForm;
import jpa.IncomingDock;
import jpa.dao.IncomingDockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import services.utils.receipts.ReceiptSelectValidator;

import java.util.Collection;

@Service
@Transactional
public class ReceiptService {

    @Autowired
    private ReceiptSelectValidator receiptSelectValidator;

    @Autowired
    private IncomingDockDAO incomingDockDAO;


    public Collection<IncomingDock> getAllIncomingDocks() {
        return incomingDockDAO.listAll();
    }

    public void validate(ReceiptSelectForm receiptSelectForm, BindingResult bindingResult) {

        receiptSelectValidator.validateOrderCode(receiptSelectForm, bindingResult);
        receiptSelectValidator.validateDeliveryNote(receiptSelectForm, bindingResult);
        receiptSelectValidator.validateDock(receiptSelectForm, bindingResult);
    }

    public ReceiptForm createReceipt(ReceiptSelectForm receiptSelectForm) {
        return null;
    }
}
