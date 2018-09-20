package model.daoImpl;

import model.dao.PersonDao;
import model.dto.PersonDto;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("PersonDao")
public class PersonDaoImpl extends BaseDaoImpl<PersonDto> implements PersonDao {

    public PersonDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public PersonDto authorizeUser(String email, String password) {
        return (PersonDto) session.createQuery("from PersonDto where email = " + email + " and password = " + password).list().get(0);
    }

}