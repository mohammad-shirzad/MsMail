package model.dao;

import model.dto.EmailDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmailDao extends BaseDao<EmailDto,String>{
     List<EmailDto> getEmailsByToAccount(String toUser);
}
