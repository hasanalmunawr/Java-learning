package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Brand;
import hasanalmunawarDev.jpa.entity.Product;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class ManyToOne {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = new Brand();
        brand.setId("Xiaomi");
        brand.setName("Xiaomi");
        entityManager.persist(brand);

        Product product1 = new Product();
        product1.setId("Hp1");
        product1.setBrand(brand);
        product1.setName("Xiaomi note 12");
        product1.setPrice(2_500_000L);
        entityManager.persist(product1);

        Product product2 = new Product();
        product2.setId("Hp2");
        product2.setBrand(brand);
        product2.setName("Xiaomi note 12 pro");
        product2.setPrice(3_500_000L);
        entityManager.persist(product2);

        transaction.commit();
    }

    @Test
    void find() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = entityManager.find(Brand.class, "Xiaomi");
        brand.getProducts().forEach(product -> {
            System.out.println(product.getName());
        });
    }
}
