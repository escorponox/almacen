package initTests;

import jpa.Item;
import jpa.Location;
import jpa.dao.ItemDAO;
import jpa.dao.LocationDAO;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import webservices.client.*;

import java.math.BigDecimal;

public class InitAllTest {

    @Test
    @Ignore
    @Transactional
    public void initiate() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-context.xml");

        LocationDAO locationDAO = (LocationDAO) context.getBean("locationDAO");

        Long sequence = 0L;

        for (int p = 1; p < 3; p++) {

            for (int m = 1; m < 26; m++) {

                for (int s = 0; s < 2; s++) {

                    Location location = new Location();
                    location.setCorridor("P" + p);
                    location.setSide(String.valueOf(s));
                    location.setModule("M" + m);
                    location.setSeq(sequence);
                    sequence++;

                    locationDAO.addLocation(location);
                }
            }

        }

        ItemDAO itemDAO = (ItemDAO) context.getBean("itemDAO");

        for (int i = 1; i < 101; i++) {
            Item item = new Item();
            item.setCode(String.valueOf(900000 + i));
            item.setName(String.valueOf("Item " + i));
            item.setDescription(String.valueOf("Description " + i));
            item.setLocation(locationDAO.getLocationById(Long.valueOf(String.valueOf(i))));
            item.setPrice(new BigDecimal("1" + i + ".5"));
            item.setMinStock(10L);
            item.setMaxStock(100L);

            itemDAO.addItem(item);
        }
    }

    @Test
    @Ignore
    public void initiateReceivingOrder() {

        webservices.client.ReceivingOrdersSOAP service = new webservices.client.ReceivingOrdersSOAP_Service().getReceivingOrdersSOAPPort();

        ObjectFactory objectFactory = new ObjectFactory();
        RecOrderRequest recOrderRequest = objectFactory.createRecOrderRequest();
        recOrderRequest.setOrderCode(2L);
        recOrderRequest.setProviderNif("51094582J");

        RecOrderRequest.RecLines recLines = objectFactory.createRecOrderRequestRecLines();

        for (int i = 1; i < 101; i++) {

            RecLineRequest recLineRequest = objectFactory.createRecLineRequest();
            recLineRequest.setItemCode(900000L + i);
            recLineRequest.setQuantity(100L);

            recLines.getRecLine().add(recLineRequest);
        }

        recOrderRequest.setRecLines(recLines);

        RecOrderResponse recOrderResponse = service.register(recOrderRequest);

        System.out.println("Response Code: " + recOrderResponse.getResponseCode());
        System.out.println("Error Description: " + recOrderResponse.getErrorDescription());
        for (RecLineResponse recLineResponse : recOrderResponse.getRecLineResponses().getRecLineResponse()) {
            System.out.println("Response Line Code: " + recLineResponse.getResponseCode() + ". " + recLineResponse.getErrorDescription());
        }
    }
}
