package services.utils.items;

import jpa.Item;
import jpa.dao.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ItemCodeSearcher {

    @Autowired
    private ItemDAO itemDAO;

    public List<String> search(String code) {

        List<String> itemCodes = new LinkedList<>();

        for (Item item : itemDAO.searchByCode(code)) {

            itemCodes.add(item.getCode());
        }

        return itemCodes;
    }
}
