package service;

import model.Email;
import java.util.List;


public interface EmailService {
    List<Email> getEmailsByReceiver(String receiver);

    Email sendEmail(Email emailDto);
    void changeEmailReadStatus(int id);
}
