package ru.mustafin.springBootCrud.service;

import ru.mustafin.springBootCrud.model.User;
import java.util.List;

public interface UserService {

    List<User> findAll ();

    User getById(long id);

    void save(User user);

    void deleteById(long id);

    User findByUsername(String username);

    void update(User user);

    User passwordCoder(User user);
}
