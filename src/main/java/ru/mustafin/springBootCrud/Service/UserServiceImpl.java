package ru.mustafin.springBootCrud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mustafin.springBootCrud.DAO.UserDAO;
import ru.mustafin.springBootCrud.Model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public User getById(long id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDAO.delete(id);
    }
}
