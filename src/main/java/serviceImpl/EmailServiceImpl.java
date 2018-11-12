package serviceImpl;

import dao.EmailDao;
import model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.EmailService;
import util.DateUtil;

import java.util.List;

@Service("EmailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailDao emailDao;


    @Override
    public List<Email> getEmailsByReceiver(String receiver) {

        try {
            return emailDao.findEmailsByReceiver(receiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Email sendEmail(Email email) {

        try {
            email.setLastChangeDate(DateUtil.getCurrentDateTime());
            return emailDao.save(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changeEmailReadStatus(int id) {

    }


}
