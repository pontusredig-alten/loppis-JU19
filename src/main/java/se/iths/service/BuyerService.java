package se.iths.service;

import se.iths.entity.Buyer;
import se.iths.entity.Item;
import se.iths.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Transactional
public class BuyerService {

    @PersistenceContext
    EntityManager entityManager;


    public Set<User> getSpecificUsersForItem(String buyerName, String itemName) {

       // Hämta item med relaterad data
        Item item = (Item) entityManager
                .createQuery("SELECT DISTINCT i FROM Item i INNER JOIN FETCH i.buyer b INNER JOIN FETCH i.users u WHERE b.firstName = :buyerName AND i.name = :itemName")
                .setParameter("buyerName", buyerName).setParameter("itemName", itemName).getSingleResult();

        // Här hämtas Set med USERS från vårat hämtade ITEM
        Set<User> userResult = item.getUsers();

        return userResult;


    }


}
