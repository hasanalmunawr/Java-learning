package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Customer;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class ColumnTest {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("Hasan Almunawar");
        customer.setPrimaryEmail("contoh@gmail.com");

        entityManager.persist(customer);
        transaction.commit();
    }
}
