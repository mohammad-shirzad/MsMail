package dao;

import model.Email;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("EmailDao")
public interface EmailDao extends org.springframework.data.jpa.repository.JpaRepository<Email, Integer> {

    List<Email> findEmailsByReceiver(String email);
}
