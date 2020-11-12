package se.iths.util;

import se.iths.entity.Item;

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

        entityManager.persist(new Item("Soffa", "Möbler", 1, 150.00));
        entityManager.persist(new Item("Stol", "Möbler", 1, 100.00));
        entityManager.persist(new Item("Pall", "Möbler", 1, 50.00));
        entityManager.persist(new Item("Mössa", "Kläder", 1, 123.00));
        entityManager.persist(new Item("Vantar", "Kläder", 2, 95.00));
        entityManager.persist(new Item("Tröja", "Kläder", 1, 150.00));
        entityManager.persist(new Item("Processen", "Böcker", 1, 150.00));
        entityManager.persist(new Item("Krig och fred", "Böcker", 1, 50.00));
        entityManager.persist(new Item("Äcklet", "Böcker", 1, 75.00));
        entityManager.persist(new Item("Studsboll", "Leksaker", 1, 15.00));


    }


}
