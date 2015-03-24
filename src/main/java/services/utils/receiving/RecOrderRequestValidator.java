package services.utils.receiving;

import jpa.Item;
import jpa.Provider;
import jpa.ReceivingOrder;
import jpa.dao.ItemDAO;
import jpa.dao.ProviderDAO;
import jpa.dao.ReceivingOrderDAO;
import jpa.enums.ReceivingOrdersStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import webservices.domain.RecLineRequest;
import webservices.domain.RecLineResponse;
import webservices.domain.RecOrderRequest;
import webservices.domain.RecOrderResponse;

import java.util.LinkedList;
import java.util.List;

@Component
public class RecOrderRequestValidator {

    @Autowired
    private ReceivingOrderDAO receivingOrderDAO;
    @Autowired
    private ProviderDAO providerDAO;
    @Autowired
    private ItemDAO itemDAO;

    public void validateCode(RecOrderRequest recOrderRequest, RecOrderResponse recOrderResponse) {

        ReceivingOrder receivingOrder = receivingOrderDAO.getReceivingOrderByCode(recOrderRequest.getOrderCode());

        if (receivingOrder != null && receivingOrder.getStatus().getStatus() != ReceivingOrdersStatusEnum.CR) {
            recOrderResponse.setResponseCode("-1");
            recOrderResponse.setErrorDescription("Order code " + recOrderRequest.getOrderCode() + " already in use.");
        }
    }

    public void validateProvider(RecOrderRequest recOrderRequest, RecOrderResponse recOrderResponse) {

        Provider provider = providerDAO.getProviderByNif(recOrderRequest.getProviderNif());

        if (provider == null) {
            recOrderResponse.setResponseCode("-2");
            recOrderResponse.setErrorDescription("Provider " + recOrderRequest.getProviderNif() + "not found.");
        }
    }

    public void validateLines(RecOrderRequest recOrderRequest, RecOrderResponse recOrderResponse) {

        List<RecLineResponse> recLineResponses = new LinkedList<>();
        Boolean oneValidLine = false;

        for (RecLineRequest recLineRequest : recOrderRequest.getRecLines()) {

            RecLineResponse recLineResponse = new RecLineResponse();
            Item item = itemDAO.getItemByCode(recLineRequest.getItemCode());

            if (item == null) {
                recLineResponse.setResponseCode("-1");
                recLineResponse.setErrorDescription(new StringBuilder("Item ")
                        .append(recLineRequest.getItemCode())
                        .append(" not found.").toString());
            } else if (recLineRequest.getQuantity() >= 0) {
                oneValidLine = true;
            } else {
                recLineResponse.setResponseCode("-2");
                recLineResponse.setErrorDescription(new StringBuilder("Negative quantity for item ")
                        .append(recLineRequest.getItemCode())
                        .toString());
            }

            recLineResponses.add(recLineResponse);
        }

        recOrderResponse.setRecLineResponses(recLineResponses);

        if (!oneValidLine) {
            recOrderResponse.setResponseCode("-3");
            recOrderResponse.setErrorDescription("No valid lines found.");
        }

    }
}
