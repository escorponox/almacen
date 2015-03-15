package jpa.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderDAOTest {

    private ProviderDAO providerDAO;

    @Before
    public void setContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-context.xml");
        providerDAO = (ProviderDAO) context.getBean("providerDAO");
    }

    @Test
    public void getByNifNonExistantReturnsNull() {
        Assert.assertNull(providerDAO.getProviderByNif("aaaa"));
    }

    @Test
    public void getByNifExistant() {
        Assert.assertEquals("51094582J", providerDAO.getProviderByNif("51094582J").getNif());
    }
}
