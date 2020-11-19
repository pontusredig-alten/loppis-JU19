package se.iths.util;

import se.iths.entity.Item;
import se.iths.entity.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {

        User user1 = new User("Kalle", "Anka", "kalle@ankeborg.com");
        User user2 = new User("Kajsa", "Anka", "kajsa@ankeborg.com");
        User user3 = new User("Klarabella", "Ko", "klarabella@ankeborg.com");

        Item item1 = new Item("Soffa", "Möbler", 1, 150.00);
        Item item2 = new Item("Stol", "Möbler", 1, 100.00);
        Item item3 = new Item("Mössa", "Kläder", 1, 123.00);
        Item item4 = new Item("Processen", "Böcker", 1, 150.00);
        Item item5 = new Item("Studsboll", "Leksaker", 1, 15.00);

        user1.addItem(item1);
        user1.addItem(item5);
        user2.addItem(item2);
        user2.addItem(item1);
        user3.addItem(item4);
        user3.addItem(item1);
        user3.addItem(item3);

        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(user3);

//        entityManager.persist(new Item("Soffa", "Möbler", 1, 150.00));
//        entityManager.persist(new Item("Stol", "Möbler", 1, 100.00));
//        entityManager.persist(new Item("Pall", "Möbler", 1, 50.00));
//        entityManager.persist(new Item("Mössa", "Kläder", 1, 123.00));
//        entityManager.persist(new Item("Vantar", "Kläder", 2, 95.00));
//        entityManager.persist(new Item("Tröja", "Kläder", 1, 150.00));
//        entityManager.persist(new Item("Processen", "Böcker", 1, 150.00));
//        entityManager.persist(new Item("Krig och fred", "Böcker", 1, 50.00));
//        entityManager.persist(new Item("Äcklet", "Böcker", 1, 75.00));
//        entityManager.persist(new Item("Studsboll", "Leksaker", 1, 15.00));


    }


}
