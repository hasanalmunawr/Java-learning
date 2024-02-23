package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Department;
import hasanalmunawarDev.jpa.entity.DepertmentId;
import hasanalmunawarDev.jpa.entity.Member;
import hasanalmunawarDev.jpa.entity.Name;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmbeddedTest {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Name name = new Name();
        name.setTitle("Prof");
        name.setFirstName("Hasan");
        name.setMiddleName("Basri");
        name.setLastName("Agus");

        Member member = new Member();
        member.setEmail("contoh@.com");
        member.setName(name);

        entityManager.persist(member);
        transaction.commit();
    }

    @Test
    void embeddedId() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        DepertmentId id = new DepertmentId();
        id.setCompanyId("UangKu");
        id.setDepartmentId("Tech");

        Department department = new Department();
        department.setId(id);
        department.setName("Teknologi");

       entityManager.persist(department);
        transaction.commit();
    }
 @Test
    void embeddedIdFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        DepertmentId id = new DepertmentId();
        id.setCompanyId("UangKu");
        id.setDepartmentId("Tech");

         Department department = entityManager.find(Department.class, id);
         Assertions.assertEquals("Teknologi", department.getName());

     entityManager.persist(department);
        transaction.commit();
    }

}
