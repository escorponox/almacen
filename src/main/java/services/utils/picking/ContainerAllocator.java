package services.utils.picking;

import jpa.Container;
import jpa.PickingAction;
import jpa.User;
import jpa.dao.*;
import jpa.enums.ActionStatusEnum;
import jpa.enums.ContainerStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ContainerAllocator {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ContainerDAO containerDAO;
    @Autowired
    private ContainerStatusDAO containerStatusDAO;
    @Autowired
    private PickingActionDAO pickingActionDAO;
    @Autowired
    private ActionStatusDAO actionStatusDAO;

    public Container allocate(String username) {

        User user = userDAO.getUserByUsername(username);

        Container container = containerDAO.getContainerByPicker(user);

        if (container == null) {
            
            container = containerDAO.getFirstUnAssignedContainer();
            if (container != null) {

                container.setStatus(containerStatusDAO.getContainerStatusByStatus(ContainerStatusEnum.AS));
                container.setPicker(user);

                containerDAO.updateContainer(container);

                for (PickingAction pickingAction : pickingActionDAO.getCreatedPickingActionsByContainer(container)) {

                    pickingAction.setStatus(actionStatusDAO.getActionStatusByStatus(ActionStatusEnum.AS));
                    pickingAction.setPicker(user);

                    pickingActionDAO.updatePickingAction(pickingAction);
                }

            }
        }

        return container;
    }
}
