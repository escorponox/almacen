package services.utils.items;

import jpa.Item;
import jpa.dao.ItemDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.domain.ItemXml;
import services.domain.ItemsListXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

@Component
public class ItemsXmlListMaker {

    private static final Logger LOGGER = Logger.getLogger(ItemsXmlListMaker.class);

    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private AvailableStockGetter availableStockGetter;


    public String make() {
        List<Item> items = itemDAO.listAll();

        ItemsListXml itemsListXml = new ItemsListXml();

        for (Item item : items) {
            ItemXml itemXml = new ItemXml();
            itemXml.setCode(item.getCode());
            itemXml.setName(item.getName());
            itemXml.setDescription(item.getDescription());
            itemXml.setPrice(item.getPrice());
            itemXml.setLocation(item.getLocation().getName());
            itemXml.setStock(availableStockGetter.get(item));
            itemXml.setMinStock(item.getMinStock());
            itemXml.setMaxStock(item.getMaxStock());

            itemsListXml.getItemList().add(itemXml);
        }

        String result;
        StringWriter sw = new StringWriter();

        try {

            JAXBContext context = JAXBContext.newInstance(ItemsListXml.class, ItemXml.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(itemsListXml, sw);
            result = sw.toString();

        } catch (Exception e) {
            result = "";
            LOGGER.error("Error marshaling item list", e);
        }

        return result;
    }
}