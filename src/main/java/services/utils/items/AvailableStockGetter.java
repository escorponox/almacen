package services.utils.items;

import jpa.Item;
import jpa.Stock;
import jpa.dao.StockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AvailableStockGetter {

    @Autowired
    private StockDAO stockDAO;

    public Long get(Item item) {

        Long availableStock = 0L;

        for (Stock stock : stockDAO.getAvailableStockBydItem(item)) {
            availableStock += stock.getQuantity();
        }

        return availableStock;
    }
}
