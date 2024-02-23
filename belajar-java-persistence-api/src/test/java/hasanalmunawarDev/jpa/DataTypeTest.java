package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Customer;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class DataTypeTest {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = new Customer();
        customer.setId("2");
        customer.setName("Udin");
        customer.setAge((byte) 30);
        customer.setMarried(true);

        entityManager.persist(customer);
        transaction.commit();
    }
}
