package model.daoImpl;

import model.dao.EmailDao;
import model.dto.EmailDto;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailDaoImpl extends BaseDaoImpl<EmailDto,String> implements EmailDao {


    public EmailDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void sendEmail(EmailDto emailDto) {
         save(emailDto);
    }

    public void changeMailStatus(int id){
        EmailDto emailDto = session.get(EmailDto.class,id);
        emailDto.setRead(true);
        Transaction transaction = session.beginTransaction();
        session.update(emailDto);
        transaction.commit();
    }

    @Override
    public List<EmailDto> getEmailsByToAccount(String toUser) {
        return session.createQuery("from EmailDto where toAccount = " + toUser).list();
    }
}
