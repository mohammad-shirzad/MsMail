package model.dao;

import model.dto.EmailDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailDao {
    private SessionFactory sessionFactory;

    private Session session;

    @Autowired
    public EmailDao(SessionFactory sessionFactory) {
        try {

            this.sessionFactory=sessionFactory;
            session = this.sessionFactory.openSession();
        }catch (Exception e){
            e.getStackTrace();
        }
    }


    public void sendEmail(EmailDto emailDto) {
        try {
            if (session.isOpen()){
                Transaction transaction=session.beginTransaction();
                session.saveOrUpdate(emailDto);
                transaction.commit();
                session.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public List<EmailDto> getReceivedMessages(String user){
        session = sessionFactory.openSession();
        Query query = session.createQuery("from EmailDto where ToAccount = :to");
        query.setParameter("to",user);
        List<EmailDto> emailDtoList = (List<EmailDto>) query.list();
        return emailDtoList;

    }
    public void changeMailStatus(int id){
        EmailDto emailDto = session.get(EmailDto.class,id);
        emailDto.setRead(true);
        Transaction transaction = session.beginTransaction();
        session.update(emailDto);
        transaction.commit();
    }
}
