package services.utils.picking;

import forms.PickingForm;
import jpa.Container;
import jpa.OrderLine;
import jpa.PickingAction;
import jpa.Stock;
import jpa.dao.ActionStatusDAO;
import jpa.dao.OrderLineDAO;
import jpa.dao.PickingActionDAO;
import jpa.dao.StockDAO;
import jpa.enums.ActionStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PickingProcessor {

    @Autowired
    private ActionStatusDAO actionStatusDAO;
    @Autowired
    private PickingActionDAO pickingActionDAO;
    @Autowired
    private OrderLineDAO orderLineDAO;
    @Autowired
    private StockDAO stockDAO;

    public void process(PickingForm pickingForm, Container container) {

        PickingAction pickingAction = pickingActionDAO.getPickingActionById(pickingForm.getPickingActionId());

        OrderLine orderLine = pickingAction.getOrderLine();

        Stock locationStock = stockDAO.getStockByLocationAndItem(orderLine.getItem(), orderLine.getItem().getLocation());


        if (locationStock != null) {

            locationStock.setQuantity(locationStock.getQuantity() - pickingForm.getPicked());
            stockDAO.updateStock(locationStock);

            Stock containerStock = new Stock();
            containerStock.setContainer(container);
            containerStock.setItem(pickingAction.getOrderLine().getItem());
            containerStock.setQuantity(pickingForm.getPicked());

            stockDAO.updateStock(containerStock);
        }

        pickingAction.setPicked(pickingForm.getPicked());
        pickingAction.setStatus(actionStatusDAO.getActionStatusByStatus(ActionStatusEnum.FI));

        pickingActionDAO.updatePickingAction(pickingAction);

        orderLine.setPendingQuantity(orderLine.getPendingQuantity() - pickingForm.getPicked());

        orderLineDAO.updateOrderLine(orderLine);
    }
}
