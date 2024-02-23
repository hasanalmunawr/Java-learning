package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Brand;
import hasanalmunawarDev.jpa.entity.Product;
import hasanalmunawarDev.jpa.entity.User;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class ManyToManyTest {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Product product1 = entityManager.find(Product.class, "Hp1");
        Product product2 = entityManager.find(Product.class, "Hp2");

        User user = entityManager.find(User.class, "Almunawar");
        user.setLikes(new HashSet<>());
        user.getLikes().add(product1);
        user.getLikes().add(product2);

        entityManager.merge(user);

        transaction.commit();
    }

    @Test
    void withoutFetch() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Product product = entityManager.find(Product.class, "Hp1");
        Brand brand = product.getBrand();
        System.out.println(brand.getName());
    }
}
