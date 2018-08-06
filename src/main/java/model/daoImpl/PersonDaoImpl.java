package model.daoImpl;

import model.dao.PersonDao;
import model.dto.PersonDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDaoImpl extends BaseDaoImpl<PersonDto,String> implements PersonDao {


    public PersonDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public PersonDto authorizeUser(String userName, String password) {
        return (PersonDto) session.createQuery("from PersonDto where userName = " + userName + " and password = " + password).list().get(0);
    }

    @Override
    public PersonDto getUserByUserName(String userName) {
        return session.get(clazz,userName);
    }
}