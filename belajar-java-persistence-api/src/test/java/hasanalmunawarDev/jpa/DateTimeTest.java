package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Category;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;

public class DateTimeTest {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Category category = entityManager.find(Category.class, "3");
        category.setCreateAt(Calendar.getInstance());
        category.setUpdateAt(LocalDateTime.now());

        transaction.commit();
    }
}
