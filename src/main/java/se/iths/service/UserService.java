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
            entityManager.persist(user);
        return user;
    }

    public User updateUser(User user) {
        entityManager.merge(user);
        return user;
    }

    public List<User> getAllUsers() {
        // JPQL query
        return entityManager.createQuery("SELECT u from User u", User.class).getResultList();
    }

    public void deleteUser(Long id) {
        User deleteThisUser = entityManager.find(User.class, id);
        entityManager.remove(deleteThisUser);
    }



}
