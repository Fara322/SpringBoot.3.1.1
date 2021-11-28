package ru.mustafin.springBootCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mustafin.springBootCrud.Model.User;
import ru.mustafin.springBootCrud.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestTestController {

    private final UserService userService;

    @Autowired
    public RestTestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> showAllUsers() {
        List<User> allUsers = userService.getAllUsers();

        return allUsers;
    }

    @GetMapping("/users/{id}")
    public User showUserById(@PathVariable long id) {
        User user = userService.getById(id);

        return user;
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        userService.save(user);

        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.save(user);

        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.delete(id);

        return "User with ID" + id + " was deleted";
    }


}