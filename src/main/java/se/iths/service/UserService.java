package se.iths.service;

import se.iths.entity.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserService {

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    private Pbkdf2PasswordHash passwordEncoder;





    public User createUser(User user) {
        user.setPassword(passwordEncoder.generate(user.getPassword().toCharArray()));
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
