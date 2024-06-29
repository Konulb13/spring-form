package org.example.springmvcform.controller;
import org.example.springmvcform.model.User;
import org.example.springmvcform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/new")
    public String showSingUpForm(Model model){
        model.addAttribute("user", new User());
        return "add-user";
    }
    @PostMapping("/add")
    public String addUser(@ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "add-user";
        }
        userService.saveUser(user);
        return "redirect:/users/list";
    }

    @GetMapping("/list")
    public String showUserList(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }
}
