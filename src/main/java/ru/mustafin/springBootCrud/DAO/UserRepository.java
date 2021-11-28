package ru.mustafin.springBootCrud.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mustafin.springBootCrud.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public interface UserRepository extends JpaRepository <User, Long> {

     User findUserByFirstName(String name);
}
