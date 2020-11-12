package se.iths.service;

import se.iths.entity.Item;
import se.iths.entity.User;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
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

    public void deleteItem(Long id) {
        Item deleteThisItem = entityManager.find(Item.class, id);
        entityManager.remove(deleteThisItem);
    }

    public Item findItemById(Long id) {
        return entityManager.find(Item.class, id);
    }

    public List<Item> getAllItems() {
         return entityManager.createQuery("SELECT i FROM Item i", Item.class).getResultList();
    }

    // Dynamic
    public List<Item> getByNameDynamicQuery(String name) {
        String query = "SELECT i FROM Item i WHERE i.name = '" + name + "'";
        return entityManager.createQuery(query, Item.class).getResultList();
    }

    // Named Parameters
    public List<Item> getByNameNamedParameters(String name) {
        String query = "SELECT i FROM Item i WHERE i.name = :name";
        return entityManager.createQuery(query, Item.class).setParameter("name", name).getResultList();
    }

    // Positional Parameters
    public List<Item> getByNamePositionalParameters(String name) {
        String query = "SELECT i FROM Item i WHERE i.name = ?1";
        return entityManager.createQuery(query, Item.class).setParameter(1, name).getResultList();
    }

    public List<Item> getAllItemsSortedByCategory() {
        String query = "SELECT i FROM Item i ORDER BY i.category";
        return entityManager.createQuery(query, Item.class).getResultList();
    }

    public List<Item> getAllItemsBetweenPrice(double minPrice, double maxPrice) {
        String query = "SELECT i FROM Item i WHERE i.price BETWEEN :minPrice AND :maxPrice";
        return entityManager.createQuery(query, Item.class).setParameter("minPrice", minPrice)
                .setParameter("maxPrice", maxPrice).getResultList();
    }




}
