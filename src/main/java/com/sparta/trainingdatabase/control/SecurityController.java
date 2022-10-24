package com.sparta.trainingdatabase.control;

import com.sparta.trainingdatabase.model.dao.UserDao;
import com.sparta.trainingdatabase.model.dto.UserDto;
import com.sparta.trainingdatabase.model.entity.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    private final UserDao userDao;

    public SecurityController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginError", false);
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("newUser", new UserDto());
        return "signup";
    }

    @GetMapping("/")
    public String main(Model model) { return "index"; }

    @PostMapping("/signup/new")
    public String signup(@ModelAttribute UserDto user, Model model) {
        UserDto saveduser = userDao.save(user);
        if (saveduser == null || saveduser.getName() == null) {
            model.addAttribute("newUser", new UserDto());
            model.addAttribute("userRegistered", false);
            return "signup";
        }
        model.addAttribute("newUser", user);
        model.addAttribute("userRegistered", true);
        return "login";
    }
}
