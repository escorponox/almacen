package services.utils.picking;

import forms.PickingForm;
import jpa.Item;
import jpa.PickingAction;
import jpa.Stock;
import jpa.dao.ItemDAO;
import jpa.dao.PickingActionDAO;
import jpa.dao.StockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

@Component
public class PickingFormValidator {

    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private PickingActionDAO pickingActionDAO;
    @Autowired
    private StockDAO stockDAO;

    public void validateConfirmPicking(PickingForm pickingForm, ValidationContext validationContext) {

        MessageContext messages = validationContext.getMessageContext();

        PickingAction pickingAction = pickingActionDAO.getPickingActionById(pickingForm.getPickingActionId());

        if (pickingAction == null) {
            messages.addMessage(new MessageBuilder().error().defaultText("Picking not found.").build());
        } else {
            Item item = itemDAO.getItemByCode(pickingForm.getItemCode());

            if (item == null || !pickingAction.getOrderLine().getItem().getCode().equals(pickingForm.getItemCode())) {
                messages.addMessage(new MessageBuilder().error()
                        .source("itemCodeConfirmation").defaultText("Item code not valid.").build());
            }

            if (pickingForm.getPicked() > pickingAction.getOrdered()) {
                messages.addMessage(new MessageBuilder().error()
                        .source("picked").defaultText("You can't pick more than ordered.").build());
            }

            Stock stock = stockDAO.getStockByLocationAndItem(pickingAction.getOrderLine().getItem(), pickingAction.getOrderLine().getItem().getLocation());
            Long quantity = stock == null ? 0L : stock.getQuantity();

            if ((stock == null && pickingForm.getPicked() > 0) || quantity < pickingForm.getPicked()) {

                messages.addMessage(new MessageBuilder().error()
                        .source("picked").defaultText("Only " + quantity + " units in location.").build());
            }
        }
    }
}
