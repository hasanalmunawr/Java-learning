package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Customer;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrudTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        entityManagerFactory = JpaUtil.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
    }
    @AfterEach
    void tearDown() {
        entityManagerFactory.close();
        entityManager.close();
    }

    @Test
    void insert() {
        EntityTransaction transaction = entityManager.getTransaction();
        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("Hasan");

        transaction.begin();
        entityManager.persist(customer);
        transaction.commit();
    }

    @Test
    void read() {
        Customer customer = entityManager.find(Customer.class, "1");
        Assertions.assertNotNull(customer);
        Assertions.assertEquals("1", customer.getId());
        Assertions.assertEquals("Hasan", customer.getName());
    }

    @Test
    void update() {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Customer customer = entityManager.find(Customer.class, "1");
        customer.setName("Hasan Almunawar");
        transaction.commit();
    }

    @Test
    void delete() {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Customer customer = entityManager.find(Customer.class, "1");
        entityManager.remove(customer);
        transaction.commit();
    }
}
