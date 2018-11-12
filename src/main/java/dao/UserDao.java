package dao;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository("UserDao")
public interface UserDao extends org.springframework.data.jpa.repository.JpaRepository<User, Integer> {

    User findUserByEmail(String email);

    @Query("select u from User u")
    List<User> getAllUsers();
}
