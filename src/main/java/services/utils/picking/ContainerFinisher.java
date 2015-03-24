package services.utils.picking;

import jpa.Container;
import jpa.OutgoingDock;
import jpa.dao.*;
import jpa.enums.ContainerStatusEnum;
import jpa.enums.OrdersStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ContainerFinisher {

    @Autowired
    private ContainerDAO containerDAO;
    @Autowired
    private ContainerStatusDAO containerStatusDAO;
    @Autowired
    private OutgoingDockDAO outgoingDockDAO;
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OrdersStatusDAO ordersStatusDAO;

    public void finish(Container container) throws NotValidOutgoingDockException {

        OutgoingDock outgoingDock = outgoingDockDAO.getOutgoingDockById(container.getOutgoingDock().getId());

        if (outgoingDock != null) {

            container.setOutgoingDock(outgoingDock);
            container.setStatus(containerStatusDAO.getContainerStatusByStatus(ContainerStatusEnum.DO));
            container.setPicker(null);

            containerDAO.updateContainer(container);

            container.getOrder().setStatus(ordersStatusDAO.getOrdersStatusByStatus(OrdersStatusEnum.DO));

            orderDAO.updateOrder(container.getOrder());
        } else {
            throw new NotValidOutgoingDockException("Not valid dock.");
        }
    }
}
