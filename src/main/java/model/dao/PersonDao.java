package model.dao;

import model.dto.PersonDto;
import org.springframework.stereotype.Service;

public interface PersonDao extends BaseDao<PersonDto> {
     PersonDto authorizeUser(String userName,String password);
//     PersonDto getUserByUserName(String userName);

}
