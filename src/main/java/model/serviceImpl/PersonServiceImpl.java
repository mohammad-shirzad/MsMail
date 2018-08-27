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
    public PersonDto authorizeUser(String userName, String password) {
        PersonDto personDto = personDao.getInstanceByField("UserName", userName);
        if (personDto != null && personDto.getPassword().equals(password)) {
            return personDto;
        }
        return null;
    }

    @Override
    public PersonDto getUserByUserName(String userName) {
        return personDao.getInstanceByField("UserName", userName);
    }

    @Override
    public BaseDao getDao() {
        return personDao;
    }
}
