package se.iths.service;

import se.iths.entity.Item;
import se.iths.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserService {

    @PersistenceContext
    EntityManager entityManager;

    public User createUser(User user) {
        user.addItem(new Item("Soffa", "Möbler", 1, 500.00));
        user.addItem(new Item("Strumpor", "Kläder", 10, 45.00));
        entityManager.persist(user);
        return user;
    }

    public List<User> getAllUsers() {
        // JPQL query
        return entityManager.createQuery("SELECT u from User u", User.class).getResultList();
    }


}
