package iuh.fit.duongdinhlong_week6.frontend.controllers;

import iuh.fit.duongdinhlong_week6.backend.models.User;
import iuh.fit.duongdinhlong_week6.backend.repositories.UserRepository;
import iuh.fit.duongdinhlong_week6.backend.services.UserService;
import jakarta.servlet.http.HttpSession;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @RequestMapping("/login")
    public String login(){
        return "login-form";
    }

    @PostMapping("/login")
    public String Login(String email, Model model, HttpSession session){
        boolean login = userService.checkLogin(email);
        User user = userRepository.findByEmail(email);
        if(login){
            model.addAttribute("user",user);
            session.setAttribute("loginUser",user);
            return "redirect:/blog";
        }
        else {
            return "login-form";
        }
    }

    @GetMapping("/signup")
    public  String showSignUp(Model model){
        User user = new User();
        model.addAttribute("signup", user);
        return  "addUser";
    }
    @PostMapping("/addUser")
    public String add(@ModelAttribute("signup")User user){
        User user1 = new User(
                user.getFirstName(),user.getMiddleName(),user.getLastName(),user.getMobile(),
                user.getEmail(),user.getPasswordHash(), Instant.now(),Instant.now(),user.getIntro(),user.getProfile());
        userRepository.save(user1);
        return "redirect:/login";
    }
}
