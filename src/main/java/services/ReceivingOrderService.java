package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.utils.receiving.RecOrderRequestValidator;
import services.utils.receiving.ReceivingOrderCreator;
import webservices.domain.RecOrderRequest;
import webservices.domain.RecOrderResponse;

@Service
@Transactional
public class ReceivingOrderService {

    @Autowired
    private RecOrderRequestValidator recOrderRequestValidator;
    @Autowired
    private ReceivingOrderCreator receivingOrderCreator;


    public void processRequest(RecOrderRequest recOrderRequest, RecOrderResponse recOrderResponse) {

        recOrderRequestValidator.validateCode(recOrderRequest, recOrderResponse);
        recOrderRequestValidator.validateProvider(recOrderRequest, recOrderResponse);
        recOrderRequestValidator.validateLines(recOrderRequest, recOrderResponse);

        if ("0".equals(recOrderResponse.getResponseCode())) {

            try {
                receivingOrderCreator.create(recOrderRequest, recOrderResponse);
            } catch (Exception e) {
                recOrderResponse.setResponseCode("-4");
                recOrderResponse.setErrorDescription("Error in saving process.");
            }
        }
    }
}
