package controller;

import model.dao.PersonDao;
import model.dto.EmailDto;
import model.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/logandreg")
public class LogAndReg {

    @Autowired
    private PersonDao personDao;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("user") String userName,
                        @RequestParam("pass") String password,
                              Model model){
        PersonDto personDto=personDao.authorizeUser(userName,password);
        if (personDto!=null){
            model.addAttribute("invalid","");
            model.addAttribute("user",personDto);
            return "dashboard";
        }
        model.addAttribute("invalid","invalid username/password");
        return "index";

    }

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("emailDto",new EmailDto());
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam("user") String username,@RequestParam("pass") String password,
                           @RequestParam("first") String firstName,@RequestParam("last") String lastName
                           ){
        PersonDto personDto=new PersonDto(username,password,firstName,lastName);
        personDao.saveNewAccount(personDto);

        return "index";
    }

    @RequestMapping(value = "/logout")
    public String logout(){
        ServletRequestAttributes attr =
                (ServletRequestAttributes) RequestContextHolder
                        .currentRequestAttributes();
        attr.getRequest().getSession(false).removeAttribute("user");
        attr.getRequest().getSession(false).invalidate();
        return "index";
    }
    @RequestMapping(value = "/checksession")
    @ResponseBody
    public String checkSession(){
        ServletRequestAttributes attr =
                (ServletRequestAttributes) RequestContextHolder
                        .currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        if (session==null){
            return "0";
        }
        return "1";
    }
}
