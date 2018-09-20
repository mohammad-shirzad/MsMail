package controller;

import com.google.gson.Gson;
import model.dto.EmailDto;
import model.dto.PersonDto;
import model.service.EmailService;
import model.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Qualifier("EmailService")
    @Autowired
    private EmailService emailService;

    @Qualifier("PersonService")
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/sendemail",method = RequestMethod.POST)
    public ModelAndView sendEmail(@ModelAttribute(name = "emailDto") EmailDto emailDto,
                                  Model model) {
        ModelAndView mav = new ModelAndView("dashboard");
        emailService.sendEmail(emailDto);
        PersonDto personDto = personService.getUserByEmail(emailDto.getFrom());
        model.addAttribute("user",personDto);
        return mav;
    }

    @RequestMapping(value = "/getinbox")
    @ResponseBody
    public String getReceivedMessages(@RequestParam("user") String user){
        List<EmailDto> emailDtoList = emailService.getEmailsByToAccount(user);
        String res = new Gson().toJson(emailDtoList);

        return res;
    }

    @RequestMapping(value = "/changestat")
    @ResponseBody
    public void changeRecievedMessageStat(@RequestParam("id") int id){
        emailService.changeEmailReadStatus(id);
    }
}
