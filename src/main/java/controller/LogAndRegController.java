package controller;

import model.Email;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

@Controller
@RequestMapping(value = "/logandreg")
public class LogAndRegController {

    @Qualifier("UserService")
    @Autowired
    private UserService userService;

    private User user;

    @RequestMapping(value = "/index")
    public String showLogin(Model model) {
        model.addAttribute("login", new User());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("login") User user) {
        User authUser = userService.authorizeUser(user.getEmail(), user.getPassword());
        if (authUser != null) {
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("user", authUser);
            mav.addObject("email", new Email());
            return mav;
        }
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/showReg")
    public ModelAndView showRegForm(Model model) {
        model.addAttribute("user-reg", new User());
        return new ModelAndView("register");
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("user-reg") User user, Model model) {
        User saved = userService.saveNewUser(user);
        model.addAttribute("login", new User());
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(Model model) {
        ModelAndView mav = new ModelAndView("index");
        model.addAttribute("login", new User());
        return mav;
    }
}
