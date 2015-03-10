package initTests;

import jpa.Location;
import jpa.dao.LocationsDAO;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

public class LocationsInitiator {

    @Test
    @Ignore
    @Transactional
    public void initiate() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-context.xml");

        LocationsDAO locationsDAO = (LocationsDAO) context.getBean("locationsDAO");

        Long sequence = 0L;

        for (int p = 1; p < 3; p++) {

            for (int m = 1; m < 26; m++) {

                for (int s = 0; s < 2; s++) {

                    Location location = new Location();
                    location.setCorridor("P" + p);
                    location.setSide(String.valueOf(s));
                    location.setModule("M" + m);
                    location.setSeq(sequence);
                    sequence++;

                    locationsDAO.addLocation(location);
                }
            }

        }
    }
}
