package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Credential;
import hasanalmunawarDev.jpa.entity.User;
import hasanalmunawarDev.jpa.entity.Wallet;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneToOneTest {

    @Test
    void oneToOneId() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Credential credential = new Credential();
        credential.setId("Almunawar");
        credential.setEmail("contoh@gmail.com");
        credential.setPassword("rahasia");
        entityManager.persist(credential);

        User user = new User();
        user.setId("Almunawar");
        user.setName("hasan");
        entityManager.persist(user);

        transaction.commit();
    }
    @Test
    void find() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user = entityManager.find(User.class, "Almunawar");
        Assertions.assertEquals("hasan", user.getName());
        Assertions.assertEquals("contoh@gmail.com", user.getCredential().getEmail());


        transaction.commit();
    }
      @Test
    void oneToOneForgn() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user = entityManager.find(User.class, "Almunawar");
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setBalance(1_00_000L);
        entityManager.persist(wallet);

        transaction.commit();
    }
 @Test
    void find2() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user = entityManager.find(User.class, "Almunawar");
        Assertions.assertEquals(1_00_000L, user.getWallet().getBalance());
        transaction.commit();
    }



}
