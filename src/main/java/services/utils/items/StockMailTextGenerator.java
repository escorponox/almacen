package services.utils.items;

import jpa.Item;
import jpa.dao.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockMailTextGenerator {

    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private AvailableStockGetter availableStockGetter;

    public String generate() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<html><head><style>table, td {border: 1px solid black;}</style></head>")
                .append("<body><h4>Understocked Items</h4>")
                .append("<table><tr><th>Code</th><th>Name</th><th>Stock</th><th>Min Stock</th><th>Max Stock</th></tr>");

        for (Item item : itemDAO.listAll()) {

            Long stock = availableStockGetter.get(item);

            if (stock < item.getMinStock()) {
                stringBuilder.append("<tr><td>")
                        .append(item.getCode())
                        .append("</td><td>")
                        .append(item.getName())
                        .append("</td><td>")
                        .append(stock)
                        .append("</td><td>")
                        .append(item.getMinStock())
                        .append("</td><td>")
                        .append(item.getMaxStock())
                        .append("</td></tr>");
            }
        }

        stringBuilder.append("</table></body></html>");

        return stringBuilder.toString();
    }
}
