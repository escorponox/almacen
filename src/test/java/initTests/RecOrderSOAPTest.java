package initTests;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import webservices.client.*;

public class RecOrderSOAPTest {

    @Test
    @Ignore
    @Transactional
    public void createSampleRecOrder() {

        webservices.client.ReceivingOrdersSOAP service = new webservices.client.ReceivingOrdersSOAP_Service().getReceivingOrdersSOAPPort();

        ObjectFactory objectFactory = new ObjectFactory();
        RecOrderRequest recOrderRequest = objectFactory.createRecOrderRequest();
        recOrderRequest.setOrderCode(1L);
        recOrderRequest.setProviderNif("51094582J");

        RecOrderRequest.RecLines recLines = objectFactory.createRecOrderRequestRecLines();

        RecLineRequest recLineRequest1 = objectFactory.createRecLineRequest();
        recLineRequest1.setItemCode(999000001L);
        recLineRequest1.setQuantity(100L);

        RecLineRequest recLineRequest2 = objectFactory.createRecLineRequest();
        recLineRequest2.setItemCode(999000004L);
        recLineRequest2.setQuantity(200L);

        RecLineRequest recLineRequest3 = objectFactory.createRecLineRequest();
        recLineRequest3.setItemCode(999000002L);
        recLineRequest3.setQuantity(200L);

        recLines.getRecLine().add(recLineRequest1);
        recLines.getRecLine().add(recLineRequest2);
        recLines.getRecLine().add(recLineRequest3);

        recOrderRequest.setRecLines(recLines);

        RecOrderResponse recOrderResponse = service.register(recOrderRequest);

        System.out.println(recOrderResponse.getResponseCode());
        System.out.println(recOrderResponse.getErrorDescription());
        for (RecLineResponse recLineResponse : recOrderResponse.getRecLineResponses().getRecLineResponse()) {
            System.out.println(recLineResponse.getResponseCode() + " - " + recLineResponse.getErrorDescription());
        }

    }
}
