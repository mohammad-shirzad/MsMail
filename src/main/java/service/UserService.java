package service;

import model.User;

import java.util.List;


public interface UserService {
    User authorizeUser(String email, String password);

    User saveNewUser(User user);

    void updateََUserInfo(User user);

    User getUserByEmail(String email);

    List<User> getAllUsers();
}
