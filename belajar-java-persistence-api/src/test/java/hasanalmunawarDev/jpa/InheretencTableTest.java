package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.*;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class InheretencTableTest {

    @Test
    void singgleInheretance() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Employee employee = new Employee();
        employee.setId("Udin");
        employee.setName("Udin Rantara");
        entityManager.persist(employee);

        Manager manager = new Manager();
        manager.setId("Kuc");
        manager.setName("Kucing oren");
        manager.setTotalEmployee(10);
        entityManager.persist(manager);

        VicePresident vc = new VicePresident();
        vc.setId("Wed");
        vc.setName("Wedos Nalandos");
        vc.setTotalMaager(4);
        entityManager.persist(vc);

        transaction.commit();
    }
    @Test
    void singgleInheretanceFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Manager manager = entityManager.find(Manager.class, "Kuc");
//        System.out.println(manager.getName());

        Employee employee = entityManager.find(Employee.class, "Wed");
        VicePresident vc = (VicePresident) employee;
        System.out.println(vc.getName());

        transaction.commit();
    }

    @Test
    void joinedTableInheretance() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        PaymentGopay gopay = new PaymentGopay();
        gopay.setId("gopay1");
        gopay.setGopayId("082269030045");
        gopay.setAmount(1_000_000L);
        entityManager.persist(gopay);

        PaymentCreditCard creditCard = new PaymentCreditCard();
        creditCard.setId("card1");
        creditCard.setMaskedCard("4442-9024");
        creditCard.setAmount(500_000L);
        creditCard.setBank("BNI");
        entityManager.persist(creditCard);

        transaction.commit();
    }
     @Test
    void joinedTableInheretanceFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

         Payment gopay1 = entityManager.find(Payment.class, "gopay1");
         PaymentGopay gopay = (PaymentGopay) gopay1;
         System.out.println(gopay.getGopayId());

         transaction.commit();
    }

    @Test
    void inheretancePerClass() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Transaction transaction1 = new Transaction();
        transaction1.setId("t1");
        transaction1.setBalance(1_000_000L);
        transaction1.setCreateAt(LocalDateTime.now());
        entityManager.persist(transaction1);

        TransactionCredit credit = new TransactionCredit();
        credit.setId("t2");
        credit.setBalance(500_000L);
        credit.setCreaditAmount(250_000L);
        credit.setCreateAt(LocalDateTime.now());
        entityManager.persist(credit);

        TransactionDebit debit = new TransactionDebit();
        debit.setId("t3");
        debit.setBalance(3_000_000L);
        debit.setDebitAmount(1_500_000L);
        debit.setCreateAt(LocalDateTime.now());
        entityManager.persist(debit);

        transaction.commit();
    }
     @Test
    void inheretancePerClassFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

         Transaction t2 = entityManager.find(Transaction.class, "t2"); // TIDAK DI REKOMENDASIKAN KARENA AKAN MENGECEK SATU PERSATU
         TransactionCredit debit = (TransactionCredit) t2;

         transaction.commit();
    }
 @Test
    void mappedsupperClass() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = new Brand();
        brand.setId("Vivo");
        brand.setName("Vivo inter");
        entityManager.persist(brand);
        transaction.commit();
    }
@Test
    void mappedsupperClassUpdate() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

    Brand brand = entityManager.find(Brand.class, "Samsung");
    brand.setName("Samsung Indonesia");

    transaction.commit();
}


}
