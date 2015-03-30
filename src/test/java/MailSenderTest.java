import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailSenderTest {

    @Test
    @Ignore
    public void sendMailToMe() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-context.xml");
        JavaMailSenderImpl javaMailSender = (JavaMailSenderImpl) context.getBean("mailSender");

        SimpleMailMessage templateMessage = new SimpleMailMessage();

        SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
        msg.setFrom("exes.wm.ccp@gmail.com");
        msg.setTo("escorponox@gmail.com");
        msg.setText("Hola hola");
        javaMailSender.send(msg);
    }
}
