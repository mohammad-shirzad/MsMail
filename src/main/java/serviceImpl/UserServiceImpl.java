package serviceImpl;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import service.UserService;
import util.DateUtil;

import java.sql.Timestamp;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User authorizeUser(String email, String password) {
        try {
            User dbPerson = userDao.findUserByEmail(email);
            if (dbPerson != null) {
                if (BCrypt.checkpw(password, dbPerson.getPassword())) {
                    return dbPerson;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public User saveNewUser(User user) {
        try {
            String pwd = user.getPassword();
            pwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
            user.setPassword(pwd);
            user.setLastChangeDate(DateUtil.getCurrentDateTime());
            return userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateََUserInfo(User user) {

        try {
            User proxy = userDao.getOne((int) user.getId());
            if (user.getFirstName() != null) {
                proxy.setFirstName(user.getFirstName());
            }
            if (user.getLastName() != null) {
                proxy.setLastName(user.getLastName());
            }
            if (user.getPassword() != null) {
                proxy.setPassword(user.getPassword());
            }
            proxy.setLastChangeDate(DateUtil.getCurrentDateTime());
            userDao.save(proxy);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            return userDao.findUserByEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userDao.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
