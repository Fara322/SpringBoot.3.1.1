package ru.mustafin.springBootCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mustafin.springBootCrud.Model.User;
import ru.mustafin.springBootCrud.Service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class MyController {


    private UserService userService;

    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/admin/main")
    public String showUsers(@ModelAttribute("user") User user,Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsersPage", allUsers);
        return "home";
    }


    @PutMapping("/admin/main/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user",user);
        return "/info_for_save";
    }

    @DeleteMapping("/admin/main/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/admin/main";
    }

    @PostMapping("/admin/save-user")
    public String saveUser(User user) {
        userService.save(user);
        return "redirect:/admin/main";
    }

    @GetMapping("/admin/personal-page/{id}")
    public String personalPage(@PathVariable("id") Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user",user);
        return "personal_page";
    }

    @GetMapping("/user/main")
    public String showUser(Model model, Principal principal) {
        model.addAttribute("userPage", userService.findByUsername(principal.getName()));
        return "home_user";
    }
}
