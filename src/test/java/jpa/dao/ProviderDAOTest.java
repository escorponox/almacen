package jpa.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
    @Ignore
    public void getByNifNonExistantReturnsNull() {
        Assert.assertNull(providerDAO.getProviderByNif("aaaa"));
    }

    @Test
    @Ignore
    public void getByNifExistant() {
        Assert.assertEquals("51094582J", providerDAO.getProviderByNif("51094582J").getNif());
    }
}
