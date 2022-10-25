package com.sparta.trainingdatabase.control;

import com.sparta.trainingdatabase.model.dao.UserDao;
import com.sparta.trainingdatabase.model.dto.UserDto;
import com.sparta.trainingdatabase.model.entity.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SecurityController {

    private final UserDao userDao;

    public SecurityController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginError", false);
        model.addAttribute("userRegistered", false);
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("newUser", new User());
        return "signup";
    }

    @GetMapping("/")
    public String main(Model model) { return "index"; }

    @PostMapping("/signup/new")
    public String signup(@ModelAttribute UserDto user, Model model) {
        UserDto saveduser = userDao.save(user);
        if (saveduser == null) {
            model.addAttribute("newUser", new User());
            model.addAttribute("userRegistered", false);
            return "signup";
        }
        model.addAttribute("newUser", user);
        model.addAttribute("userRegistered", true);
        return "login";
    }

    @GetMapping("/profile")
    public String userProfile(Model model, Authentication authentication) {
        UserDto foundUser = userDao.findByEmail(authentication.getName());
        if (foundUser.getName() != null) {
            model.addAttribute("userLoggedIn",foundUser);
            return "profile";
        }
        model.addAttribute("userLoggedIn", new UserDto());
        return "profile";
    }

    @PatchMapping("/profile")
    public String updateUserProfile(@ModelAttribute UserDto updatedUser, Model model) {
        UserDto savedUser = userDao.update(updatedUser);
        UserDto foundUser = userDao.findByEmail(savedUser.getEmail());
        model.addAttribute("userLoggedIn", updatedUser);
        return "profile";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
