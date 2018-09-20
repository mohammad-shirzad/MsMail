package model.service;

import model.dao.BaseDao;
import model.dto.PersonDto;
import org.springframework.stereotype.Service;


public interface PersonService extends BaseService<PersonDto> {
    PersonDto authorizeUser(String email, String password);

    PersonDto getUserByEmail(String email);
}
