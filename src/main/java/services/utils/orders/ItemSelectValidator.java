package services.utils.orders;

import forms.ItemQuantitySelectForm;
import jpa.dao.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

@Component
public class ItemSelectValidator {

    @Autowired
    private ItemDAO itemDAO;

    public void validateItemQuantitySelect(ItemQuantitySelectForm itemQuantitySelectForm, ValidationContext validationContext) {

        MessageContext messages = validationContext.getMessageContext();

        if ("".equals(itemQuantitySelectForm.getCode()) && itemDAO.getItemByCode(itemQuantitySelectForm.getCode()) == null) {
            messages.addMessage(new MessageBuilder().error().source("code")
                    .defaultText("Item not found.").build());
        }

    }

}
