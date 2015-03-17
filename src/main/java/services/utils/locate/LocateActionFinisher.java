package services.utils.locate;

import forms.LocateActionForm;
import jpa.Item;
import jpa.LocateAction;
import jpa.Stock;
import jpa.dao.ActionStatusDAO;
import jpa.dao.LocateActionDAO;
import jpa.dao.StockDAO;
import jpa.enums.ActionStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class LocateActionFinisher {

    @Autowired
    private LocateActionDAO locateActionDAO;
    @Autowired
    private ActionStatusDAO actionStatusDAO;
    @Autowired
    private StockDAO stockDAO;

    public void finish(LocateActionForm locateActionForm) {

        LocateAction locateAction = locateActionDAO.getLocateActionById(locateActionForm.getLocateActionId());

        Item item = locateAction.getReceiptAction().getReceivingOrderLine().getItem();

        Stock stock = stockDAO.getStockByLocationAndItem(item, item.getLocation());

        if (stock == null) {

            stock = new Stock();
            stock.setItem(item);
            stock.setLocation(item.getLocation());
            stock.setQuantity(locateAction.getReceiptAction().getRecQuantity());

            stockDAO.addStock(stock);

        } else {

            stock.setQuantity(stock.getQuantity() + locateAction.getReceiptAction().getRecQuantity());
            stockDAO.updateStock(stock);
        }

        locateAction.setStatus(actionStatusDAO.getActionStatusByStatus(ActionStatusEnum.FI));
        locateActionDAO.updateLocateAction(locateAction);

    }
}
