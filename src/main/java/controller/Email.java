package controller;

import com.google.gson.Gson;
import model.dao.EmailDao;
import model.daoImpl.EmailDaoImpl;
import model.daoImpl.PersonDaoImpl;
import model.dto.EmailDto;
import model.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/email")
public class Email {

    @Autowired
    private EmailDaoImpl emailRepository;

    @Autowired
    private PersonDaoImpl personRepository;

    @RequestMapping(value = "/sendemail",method = RequestMethod.POST)
    public String sendEmail(@ModelAttribute(name = "emailDto") EmailDto emailDto,
                            Model model) {

        emailRepository.sendEmail(emailDto);
        PersonDto personDto = (PersonDto) personRepository.getUserByUserName(emailDto.getFrom());
        model.addAttribute("user",personDto);
        return "dashboard";
    }

    @RequestMapping(value = "/getinbox")
    @ResponseBody
    public String getReceivedMessages(@RequestParam("user") String user){
        List<EmailDto> emailDtoList = emailRepository.getEmailsByToAccount(user);
        String res = new Gson().toJson(emailDtoList);

        return res;
    }

    @RequestMapping(value = "/changestat")
    @ResponseBody
    public void changeRecievedMessageStat(@RequestParam("id") int id){
        emailRepository.changeMailStatus(id);
    }
}
