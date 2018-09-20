package model.serviceImpl;

import model.dao.BaseDao;
import model.dao.PersonDao;
import model.dto.PersonDto;
import model.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("PersonService")
public class PersonServiceImpl extends BaseServiceImpl<PersonDto> implements PersonService {

    @Qualifier("PersonDao")
    @Autowired
    PersonDao personDao;

    @Override
    public PersonDto authorizeUser(String email, String password) {
        PersonDto personDto = personDao.getInstanceByField("Email", email);
        if (personDto != null && personDto.getPassword().equals(password)) {
            return personDto;
        }
        return null;
    }

    @Override
    public PersonDto getUserByEmail(String email) {
        return personDao.getInstanceByField("Email", email);
    }

    @Override
    public BaseDao getDao() {
        return personDao;
    }
}
