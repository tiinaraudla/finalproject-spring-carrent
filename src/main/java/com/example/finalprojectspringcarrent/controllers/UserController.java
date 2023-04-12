package com.example.finalprojectspringcarrent.controllers;

import com.example.finalprojectspringcarrent.exceptions.UserNotFoundException;
import com.example.finalprojectspringcarrent.models.User;
import com.example.finalprojectspringcarrent.services.AuthorityService;
import com.example.finalprojectspringcarrent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Tiina Raudla
 * @Date
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @GetMapping
    public String showAllUserPage(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "user/list-user";
    }

    @GetMapping("/signup")
    public String showSignupPage(Model model, @ModelAttribute("user") User user, @ModelAttribute("message") String message,
                                 @ModelAttribute("messageType") String messageType) {
        model.addAttribute("authorities", authorityService.findAllAuthorities());
        return "user/create-user";
    }

    @PostMapping("/signup")
    public String createUser(User user, RedirectAttributes redirectAttributes) {
        try {
            userService.findUserByUsername(user.getUsername());
            redirectAttributes.addFlashAttribute("message", String.format("User(%s) already exists!", user.getUsername()));
            redirectAttributes.addFlashAttribute("messageType", "error");
            return "redirect:/school/signup";
        } catch (UserNotFoundException e) {
            userService.createUser(user);
            redirectAttributes.addFlashAttribute("message", "Signup successful!");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/";
        }
    }
}
