package model.service;

import model.dao.BaseDao;
import model.dto.PersonDto;
import org.springframework.stereotype.Service;


public interface PersonService extends BaseService<PersonDto> {
    PersonDto authorizeUser(String userName, String password);

    PersonDto getUserByUserName(String userName);
}
