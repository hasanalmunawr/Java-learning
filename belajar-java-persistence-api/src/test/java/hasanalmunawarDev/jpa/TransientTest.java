package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Customer;
import hasanalmunawarDev.jpa.entity.CustomerType;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class TransientTest {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = new Customer();
        customer.setId("5");
        customer.setName("joko");
        customer.setAge((byte) 23);
        customer.setMarried(false);
        customer.setType(CustomerType.REGULAR);
        customer.setFullName("joko aria kusuma");

        entityManager.persist(customer);
        transaction.commit();
    }
}
