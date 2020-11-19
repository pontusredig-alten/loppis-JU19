package se.iths.service;

import se.iths.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BuyerService {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> getAllBuyers() {

        return entityManager.createQuery("SELECT b from Buyer b", User.class).getResultList();
    }

}
