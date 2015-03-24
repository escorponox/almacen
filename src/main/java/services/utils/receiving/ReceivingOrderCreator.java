package services.utils.receiving;

import jpa.Item;
import jpa.ReceivingOrder;
import jpa.ReceivingOrderLine;
import jpa.dao.*;
import jpa.enums.ReceivingOrdersStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import webservices.domain.RecLineRequest;
import webservices.domain.RecOrderRequest;
import webservices.domain.RecOrderResponse;

import java.util.List;

@Component
@Transactional
public class ReceivingOrderCreator {

    @Autowired
    private ReceivingOrderDAO receivingOrderDAO;
    @Autowired
    private ReceivingOrderLineDAO receivingOrderLineDAO;
    @Autowired
    private ReceivingOrdersStatusDAO receivingOrdersStatusDAO;
    @Autowired
    private ProviderDAO providerDAO;
    @Autowired
    private ItemDAO itemDAO;

    public void create(RecOrderRequest recOrderRequest, RecOrderResponse recOrderResponse) {

        if ("0".equals(recOrderResponse.getResponseCode())) {

            ReceivingOrder receivingOrder = receivingOrderDAO.getReceivingOrderByCode(recOrderRequest.getOrderCode());

            Integer prevNumberOfLines = 0;

            if (receivingOrder == null) {
                receivingOrder = new ReceivingOrder();
            } else {
                List<ReceivingOrderLine> previousLines = receivingOrderLineDAO.getReceivingOrderLinesByOrder(receivingOrder);
                prevNumberOfLines = previousLines.size();
            }

            receivingOrder.setCode(recOrderRequest.getOrderCode());
            receivingOrder.setProvider(providerDAO.getProviderByNif(recOrderRequest.getProviderNif()));
            receivingOrder.setStatus(receivingOrdersStatusDAO.getReceivingOrdersStatusByStatus(ReceivingOrdersStatusEnum.CR));

            receivingOrderDAO.addReceivingOrder(receivingOrder);

            Integer lineNumber = 1;

            for (RecLineRequest recLineRequest : recOrderRequest.getRecLines()) {

                ReceivingOrderLine receivingOrderLine = receivingOrderLineDAO.getReceivingOrderLineByOrderAndLineNumber(receivingOrder, lineNumber);

                Item item = itemDAO.getItemByCode(recLineRequest.getItemCode());

                if (item == null && receivingOrderLine != null) {
                    receivingOrderLineDAO.deleteReceivingOrderLine(receivingOrderLine);
                }

                if (item != null) {

                    if (receivingOrderLine == null) {
                        receivingOrderLine = new ReceivingOrderLine();
                    }

                    receivingOrderLine.setReceivingOrder(receivingOrder);
                    receivingOrderLine.setLineNumber(lineNumber);
                    receivingOrderLine.setItem(item);
                    receivingOrderLine.setOrderedQuantity(recLineRequest.getQuantity());
                    receivingOrderLine.setPendingQuantity(recLineRequest.getQuantity());

                    receivingOrderLineDAO.addReceivingOrderLine(receivingOrderLine);
                }

                lineNumber++;
            }

            for (int i = lineNumber; i <= prevNumberOfLines; i++) {

                ReceivingOrderLine receivingOrderLine = receivingOrderLineDAO.getReceivingOrderLineByOrderAndLineNumber(receivingOrder, i);
                if (receivingOrderLine != null) {
                    receivingOrderLineDAO.deleteReceivingOrderLine(receivingOrderLine);
                }
            }
        }
    }
}
