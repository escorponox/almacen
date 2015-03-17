package services.utils.locate;

import jpa.LocateAction;
import jpa.User;
import jpa.dao.ActionStatusDAO;
import jpa.dao.LocateActionDAO;
import jpa.dao.UserDAO;
import jpa.enums.ActionStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class LocateActionAllocator {

    @Autowired
    private LocateActionDAO locateActionDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ActionStatusDAO actionStatusDAO;

    public LocateAction allocate(String username) {

        User user = userDAO.getUserByUsername(username);

        LocateAction locateAction = locateActionDAO.getAssignedAction(user);

        if (locateAction == null) {

            locateAction = locateActionDAO.getFirstUnassignedLocateAction();
            if (locateAction != null) {

                locateAction.setPicker(user);
                locateAction.setStatus(actionStatusDAO.getActionStatusByStatus(ActionStatusEnum.AS));

                locateActionDAO.updateLocateAction(locateAction);
            }
        }

        return locateAction;
    }
}
