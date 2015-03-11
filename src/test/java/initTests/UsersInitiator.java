package initTests;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

public class UsersInitiator {

    @Test
    @Ignore
    @Transactional
    public void initiate() {

        System.out.println(new BCryptPasswordEncoder().encode("1234"));
    }
}
