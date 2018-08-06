package model.dao;

import model.dto.PersonDto;
import org.springframework.stereotype.Service;

@Service
public interface PersonDao extends BaseDao<PersonDto,String>{
     PersonDto authorizeUser(String userName,String password);
     PersonDto getUserByUserName(String userName);

}
