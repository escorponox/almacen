package services.utils.orders;

import forms.OrderRelease;
import forms.OrdersReleaseForm;
import jpa.Container;
import jpa.Order;
import jpa.OrderLine;
import jpa.PickingAction;
import jpa.dao.*;
import jpa.enums.ActionStatusEnum;
import jpa.enums.ContainerStatusEnum;
import jpa.enums.OrdersStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class OrderLauncher {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OrdersStatusDAO ordersStatusDAO;
    @Autowired
    private OrderLineDAO orderLineDAO;
    @Autowired
    private OutgoingDockDAO outgoingDockDAO;
    @Autowired
    private ContainerDAO containerDAO;
    @Autowired
    private ContainerStatusDAO containerStatusDAO;
    @Autowired
    private ActionStatusDAO actionStatusDAO;
    @Autowired
    private PickingActionDAO pickingActionDAO;

    public void launch(OrdersReleaseForm ordersReleaseForm) {

        for (OrderRelease orderRelease : ordersReleaseForm.getOrderReleases()) {

            if (orderRelease.getReleased() != null && orderRelease.getReleased()) {

                Order order = orderDAO.getOrderById(orderRelease.getOrderId());

                Container container;

                if (order.getStatus().getStatus() == OrdersStatusEnum.CR) {

                    container = new Container();
                    container.setOrder(order);
                    container.setStatus(containerStatusDAO.getContainerStatusByStatus(ContainerStatusEnum.CR));
                    container.setOutgoingDock(outgoingDockDAO.getOutgoingDockById(orderRelease.getDockId()));

                    containerDAO.addContainer(container);

                } else {

                    container = containerDAO.getContainerByOrder(order);
                }


                List<OrderLine> orderLines = orderLineDAO.getOrderLineForPicking(order);

                Long seq = 0L;

                for (OrderLine orderLine : orderLines) {

                    PickingAction pickingAction = new PickingAction();
                    pickingAction.setOrderLine(orderLine);
                    pickingAction.setContainer(container);
                    pickingAction.setStatus(actionStatusDAO.getActionStatusByStatus(ActionStatusEnum.CR));
                    pickingAction.setOrdered(orderLine.getOrderedQuantity());
                    pickingAction.setPicked(0L);
                    pickingAction.setSeq(seq);

                    pickingActionDAO.addPickingAction(pickingAction);

                    seq++;
                }

                order.setStatus(ordersStatusDAO.getOrdersStatusByStatus(OrdersStatusEnum.PI));

                orderDAO.updateOrder(order);
            }
        }
    }
}
