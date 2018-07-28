package model.dao;

import model.dto.PersonDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class PersonDao {

    private SessionFactory sessionFactory;

    private Session session;

    @Autowired
    public PersonDao(SessionFactory sessionFactory) {
        try {

            this.sessionFactory=sessionFactory;
            session = this.sessionFactory.openSession();
        }catch (Exception e){
            e.getStackTrace();
        }
    }


    public PersonDto getUserInfo(String username){
        Query query = session.createQuery("from PersonDto where UserName = :uname");
        query.setParameter("uname",username);
        PersonDto personDto = (PersonDto) query.list().get(0);
        return personDto;
    }



    public List<PersonDto> getAllAccounts(){
        List<PersonDto> personDtoList;
             Query query = session.createQuery("from PersonDto");
              personDtoList = query.list();
        return personDtoList;
    }




    public PersonDto authorizeUser(String userName, String password) {
        try {
            org.hibernate.query.Query query = session
                    .createQuery("from PersonDto p where p.userName=:un and p.password=:pw ");
            query.setParameter("un",userName );
            query.setParameter("pw",password );
            List<PersonDto> personDtoList = ((List<PersonDto>) query.list());
            if (!personDtoList.isEmpty()) return personDtoList.get(0);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    public void saveNewAccount(PersonDto personDto) {
        try {
            if (session.isOpen()){
                Transaction transaction=session.beginTransaction();
                session.saveOrUpdate(personDto);
                transaction.commit();
                session.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}