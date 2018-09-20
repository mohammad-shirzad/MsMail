package controller;

import model.dao.PersonDao;
import model.daoImpl.PersonDaoImpl;
import model.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Qualifier("PersonDao")
    @Autowired
    private PersonDao personDao;

    @ModelAttribute("users")
    public List<String> getUsers(){
        List<PersonDto> list = personDao.getAll();
        List<String> users = new ArrayList();
        Iterator<PersonDto> iterator = list.iterator();
        while (iterator.hasNext()) {
            String userName = iterator.next().getEmail();
            users.add(userName);
        }
        return users;
    }
}
