package services;

import jpa.User;
import jpa.dao.UserDAO;
import jpa.enums.RoleTypeEnum;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import services.utils.items.ItemsXmlListMaker;
import services.utils.items.StockMailTextGenerator;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;

@Service
public class ItemService {

    private static final Logger LOGGER = Logger.getLogger(ItemService.class);

    @Autowired
    private ItemsXmlListMaker itemsXmlListMaker;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private StockMailTextGenerator stockMailTextGenerator;
    @Autowired
    private UserDAO userDAO;


    public String listAllItemsXml() {

        return itemsXmlListMaker.make();
    }

    @Scheduled(cron = "0 0 2 ? * MON-FRI")
    public void sendStockMail() {

        List<User> users = userDAO.listAll();
        String mailText = stockMailTextGenerator.generate();

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);

            helper.setFrom("exes.wm.ccp@gmail.com");
            helper.setTo("exes.wm.ccp@gmail.com");
            helper.setSubject("Stock Mail of " + new Date());
            for (User user : users) {

                if (user.getRoleTypesEnums().contains(RoleTypeEnum.ROLE_ADMIN)) {
                    helper.addCc(user.geteMail());
                }
            }
            helper.setText(mailText, true);

            mailSender.send(message);

        } catch (MessagingException e) {
            LOGGER.error("Error generating stock mail. ", e);
        }
    }
}
