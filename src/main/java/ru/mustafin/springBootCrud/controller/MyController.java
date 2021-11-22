package ru.mustafin.springBootCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mustafin.springBootCrud.Model.User;
import ru.mustafin.springBootCrud.Service.UserService;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsersPage", allUsers);
        return "all_users";
    }

    @GetMapping("/add-new-user")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user_info";
    }

    @PostMapping("/save-user")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/update-user/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user",user);
        return "/update_user";
    }
    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") long id){
        userService.delete(id);
        return "redirect:/";
    }

}