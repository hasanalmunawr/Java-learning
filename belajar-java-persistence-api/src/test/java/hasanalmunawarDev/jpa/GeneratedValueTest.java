package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Category;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneratedValueTest {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Category category = new Category();
        category.setName("Minuman");
        category.setDescription("Minuman dingin");
        entityManager.persist(category);

        Assertions.assertNotNull(category.getId());

        transaction.commit();

    }
}
