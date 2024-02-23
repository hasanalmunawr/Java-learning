package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Category;
import hasanalmunawarDev.jpa.entity.Member;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class ListenerTest {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Category category = new Category();
        category.setName("wajan");

        entityManager.persist(category);
        transaction.commit();
    }

    @Test
    void update() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Category category = entityManager.find(Category.class, 5);
        category.setName("Udakema");

        entityManager.merge(category);
        transaction.commit();
    }
    @Test
    void listenerEntity() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Member member = entityManager.find(Member.class, 1);
        System.out.println(member.getFullName());
        transaction.commit();
    }


}
