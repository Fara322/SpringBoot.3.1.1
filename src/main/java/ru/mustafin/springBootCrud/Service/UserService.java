package ru.mustafin.springBootCrud.Service;


import org.springframework.security.core.userdetails.UserDetails;
import ru.mustafin.springBootCrud.Model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void save(User user);

    public User getById(Long id);

    public void delete(Long id);

    User findByUsername(String firstName);
}
