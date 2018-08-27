package model.service;

import model.dto.EmailDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmailService extends BaseService<EmailDto> {
    List<EmailDto> getEmailsByToAccount(String toUser);

    void sendEmail(EmailDto emailDto);

    void changeEmailReadStatus(int id);
}
