package initTests;

import jpa.Item;
import jpa.dao.ItemDAO;
import jpa.dao.LocationDAO;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

public class ItemsInitiator {

    @Test
    @Ignore
    @Transactional
    public void initiate() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-context.xml");

        ItemDAO itemDAO = (ItemDAO) context.getBean("itemDAO");
        LocationDAO locationDAO = (LocationDAO) context.getBean("locationDAO");

        Long sequence = 0L;

        for (int i = 1; i < 101; i++) {
            Item item = new Item();
            item.setCode(String.valueOf(999000000 + i));
            item.setName(String.valueOf("Item " + i));
            item.setDescription(String.valueOf("Description " + i));
            item.setLocation(locationDAO.getLocationById(Long.valueOf(String.valueOf(i))));
            item.setPrice(new BigDecimal("10" + i + ".5"));

            itemDAO.addItem(item);
        }
    }
}
