package controller;

import com.google.gson.Gson;
import model.Email;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.EmailService;
import service.UserService;

import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Qualifier("EmailService")
    @Autowired
    private EmailService emailService;

    @Qualifier("UserService")
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/sendemail",method = RequestMethod.POST)
    public ModelAndView sendEmail(@ModelAttribute(name = "email") Email email,
                                  Model model) {
        ModelAndView mav = new ModelAndView("dashboard");
        emailService.sendEmail(email);
        User user = userService.getUserByEmail(email.getSender());
        model.addAttribute("user", user);
        return mav;
    }

    @RequestMapping(value = "/getinbox")
    @ResponseBody
    public String getReceivedMessages(@RequestParam("user") String user){
        List<Email> emailDtoList = emailService.getEmailsByReceiver(user);
        String res = new Gson().toJson(emailDtoList);

        return res;
    }

    @RequestMapping(value = "/changestat")
    @ResponseBody
    public void changeRecievedMessageStat(@RequestParam("id") int id){
        emailService.changeEmailReadStatus(id);
    }
}
