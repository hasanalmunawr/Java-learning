package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Brand;
import hasanalmunawarDev.jpa.entity.Product;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class ManagedEntityTest {

    @Test
    void managedEntityPersist() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // unmanaged entity
        Brand brand = new Brand();
        brand.setId("realme");
        brand.setName("Realme Indonesia");

        entityManager.persist(brand); // managed entity

        brand.setDescription("Made in Indonesia");

        transaction.commit();
    }
     @Test
    void managedEntityFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

         Brand brand = entityManager.find(Brand.class, "realme");
         String name = brand.getName();

         transaction.commit();
    }
@Test
    void unManagedEntity() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

         Brand brand = entityManager.find(Brand.class, "realme");
         entityManager.detach(brand); // MENGUBAH MANAGED ENTITY MENJADI UNMANAGED
        brand.setName("Realme local");

         transaction.commit();
    }

}
