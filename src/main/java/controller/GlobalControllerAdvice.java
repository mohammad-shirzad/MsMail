package controller;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import service.UserService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ControllerAdvice
public class GlobalControllerAdvice {

    //    @Qualifier("PersonDao")
    @Autowired
    private UserService userService;

    @ModelAttribute("users")
    public List<String> getUsers(){
        try {
            List<User> list = userService.getAllUsers();
            List<String> users = new ArrayList();
            if (list != null) {
                Iterator<User> iterator = list.iterator();
                while (iterator.hasNext()) {
                    String userName = iterator.next().getEmail();
                    users.add(userName);
                }
                return users;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
