package ru.mustafin.springBootCrud.Service;


import ru.mustafin.springBootCrud.Model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void save(User user);

    public User getById(long id);

    public void delete(long id);
}
