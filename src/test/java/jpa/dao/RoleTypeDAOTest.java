package jpa.dao;

import jpa.RoleType;
import jpa.enums.RoleTypeEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RoleTypeDAOTest {

    RoleTypeDAO roleTypeDAO;

    @Before
    public void setContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-context.xml");

        roleTypeDAO = (RoleTypeDAO) context.getBean("roleTypeDAO");
    }

    @Test
    public void getRoleTypeByRoleTest() {

        RoleType actual = roleTypeDAO.getRoleTypeByRole(RoleTypeEnum.ROLE_ADMIN);

        Assert.assertEquals(RoleTypeEnum.ROLE_ADMIN, actual.getRole());
    }
}
