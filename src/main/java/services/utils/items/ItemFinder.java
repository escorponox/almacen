package services.utils.items;

import jpa.Item;
import jpa.dao.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.utils.orders.ItemNotFoundException;

@Component
public class ItemFinder {

    @Autowired
    private ItemDAO itemDAO;

    public Item find(String code) throws ItemNotFoundException {
        Item customer = itemDAO.getItemByCode(code);
        if (customer != null) {
            return customer;
        } else {
            throw new ItemNotFoundException("Item not found.");
        }
    }
}
