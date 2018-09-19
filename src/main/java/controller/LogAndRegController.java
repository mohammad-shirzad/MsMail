package controller;

import model.dto.EmailDto;
import model.dto.PersonDto;
import model.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/logandreg")
public class LogAndRegController {

    @Qualifier("PersonService")
    @Autowired
    private PersonService personService;

    private PersonDto personDto;

    @RequestMapping(value = "/index")
    public String showLogin(Model model) {
        model.addAttribute("loginform", new PersonDto());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("login") PersonDto personDto) {
        PersonDto authUser = personService.authorizeUser(personDto.getUserName(), personDto.getPassword());
        if (authUser != null) {
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("user", authUser);
            mav.addObject("emailDto", new EmailDto());
            return mav;
        }
        return new ModelAndView("index");
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("user") String username, @RequestParam("pass") String password,
                           @RequestParam("first") String firstName, @RequestParam("last") String lastName
    ) {
        personDto = new PersonDto(username, password, firstName, lastName);
        personService.saveEntity(personDto);

        return "index";
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(Model model) {
        ModelAndView mav = new ModelAndView("index");
        ServletRequestAttributes attr =
                (ServletRequestAttributes) RequestContextHolder
                        .currentRequestAttributes();
        attr.getRequest().getSession(false).removeAttribute("user");
        attr.getRequest().getSession(false).invalidate();
        model.addAttribute("loginform", new PersonDto());
        return mav;
    }

    @RequestMapping(value = "/checksession")
    @ResponseBody
    public String checkSession() {
        ServletRequestAttributes attr =
                (ServletRequestAttributes) RequestContextHolder
                        .currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        if (session == null) {
            return "0";
        }
        return "1";
    }
}
