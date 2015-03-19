package services.utils.items;

import jpa.Item;
import jpa.dao.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemFinder {

    @Autowired
    private ItemDAO itemDAO;

    public Item find(String code) {
        return itemDAO.getItemByCode(code);
    }
}
