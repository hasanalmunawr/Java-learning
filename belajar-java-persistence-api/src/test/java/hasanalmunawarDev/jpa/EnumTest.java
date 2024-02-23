package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Customer;
import hasanalmunawarDev.jpa.entity.CustomerType;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class EnumTest {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = new Customer();
        customer.setId("4");
        customer.setName("Didi");
        customer.setAge((byte) 36);
        customer.setMarried(true);
        customer.setType(CustomerType.VIP);

        entityManager.persist(customer);
        transaction.commit();
    }
}
