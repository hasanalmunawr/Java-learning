package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Brand;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.LockModeType;
import org.junit.jupiter.api.Test;

public class LockingTest {

    @Test
    void OptimisticLocking() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = new Brand();
        brand.setId("apple");
        brand.setName("apple inter");
        entityManager.persist(brand);

        transaction.commit();
    }
    @Test
    void OptimisticLockingUpdateVersion() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = entityManager.find(Brand.class, "apple");
        brand.setName("apple Local");
        brand.setDescription("Producklocal");

        entityManager.merge(brand);
        transaction.commit();
    }
  @Test
    void OptimisticLockingDemo1() throws InterruptedException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = entityManager.find(Brand.class, "apple");
        brand.setName("apple Demo 1");
        brand.setDescription("Producklocal");

        Thread.sleep(10 * 1000L);
        entityManager.merge(brand);
        transaction.commit();
    }
 @Test
    void OptimisticLockingDemo2() throws InterruptedException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = entityManager.find(Brand.class, "apple");
        brand.setName("apple Demo 2");
        brand.setDescription("Producklocal");

        entityManager.merge(brand);
        transaction.commit();
    }

    // Kenapa bernama Optimistic Locking, hal ini dikarenakan transaksi yang pertama selesai
    // akan optimis bahwa datanya tidak akan diubah oleh transaksi lain

    @Test
    void PessimisticLockDemo1() throws InterruptedException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = entityManager.find(Brand.class, "apple",
                LockModeType.PESSIMISTIC_WRITE);
        brand.setName("apple Demo 1");
        brand.setDescription("Producklocal");

        Thread.sleep(10 * 1000L);
        entityManager.merge(brand);
        transaction.commit();
    }
    @Test
    void PessimisticLockDemo2() throws InterruptedException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = entityManager.find(Brand.class, "apple");
        brand.setName("apple Demo 2");
        brand.setDescription("Producklocal");

        entityManager.merge(brand);
        transaction.commit();
    }

}
