package services;

import jpa.Item;
import jpa.dao.ItemDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.domain.ItemXml;
import services.domain.ItemsListXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

@Service
public class ItemService {

    private static final Logger LOGGER = Logger.getLogger(ItemService.class);

    @Autowired
    private ItemDAO itemDAO;

    public String listAllItemsXml() {

        List<Item> items = itemDAO.listAll();

        ItemsListXml itemsListXml = new ItemsListXml();

        for (Item item : items) {
            ItemXml itemXml = new ItemXml();
            itemXml.setCode(item.getCode());
            itemXml.setName(item.getName());
            itemXml.setDescription(item.getDescription());
            itemXml.setPrice(item.getPrice());
            itemXml.setLocation(item.getLocation().getName());

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
