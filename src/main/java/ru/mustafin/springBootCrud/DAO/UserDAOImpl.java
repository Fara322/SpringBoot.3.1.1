package ru.mustafin.springBootCrud.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mustafin.springBootCrud.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = entityManager.createQuery("from User ", User.class)
                .getResultList();
        return allUsers;
    }

    @Override
    public void save(User user) {
        entityManager.merge(user);

    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(getById(id));
    }
}
