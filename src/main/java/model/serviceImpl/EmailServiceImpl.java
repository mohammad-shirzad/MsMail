package model.serviceImpl;

import model.dao.BaseDao;
import model.dao.EmailDao;
import model.dto.EmailDto;
import model.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EmailService")
public class EmailServiceImpl extends BaseServiceImpl<EmailDto> implements EmailService {

    @Qualifier("EmailDao")
    @Autowired
    EmailDao emailDao;

    @Override
    public List<EmailDto> getEmailsByToAccount(String toUser) {
        return getListByField("ToAccount", toUser);
    }

    @Override
    public void sendEmail(EmailDto emailDto) {
        emailDao.save(emailDto);
    }

    @Override
    public void changeEmailReadStatus(int id) {
        EmailDto emailDto = new EmailDto();
        emailDto = emailDao.getById(emailDto, id);
        emailDto.setRead(true);
        emailDao.save(emailDto);

    }

    @Override
    public BaseDao getDao() {
        return emailDao;
    }
}
