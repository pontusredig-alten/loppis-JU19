package se.iths.service;

import se.iths.entity.Item;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ItemService {

    @PersistenceContext
    EntityManager entityManager;

    public Item createItem(Item item) {
        entityManager.persist(item);
        return item;
    }

    public Item updateItem(Item item) {
        entityManager.merge(item);
        return item;
    }

    public Item findItemById(Long id) {
        return entityManager.find(Item.class, id);
    }

    public List<Item> getAllItems() {
        return entityManager.createQuery("SELECT i from Item i", Item.class).getResultList();
    }

}
