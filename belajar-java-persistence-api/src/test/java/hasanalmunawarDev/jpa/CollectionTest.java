package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Member;
import hasanalmunawarDev.jpa.entity.Name;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollectionTest {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Name name = new Name();
        name.setTitle("Doc");
        name.setFirstName("didin");
        name.setMiddleName("Basri");
        name.setLastName("mumin");

        Member member = new Member();
        member.setEmail("contoh@.com");
        member.setName(name);
        member.setHobby(new ArrayList<>());
        member.getHobby().add("Olahraga");
        member.getHobby().add("Makan");

        entityManager.persist(member);
        transaction.commit();
    }
    @Test
    void update() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Member member = entityManager.find(Member.class, 3);
        member.getHobby().add("Minum kopi");


        entityManager.merge(member);
        transaction.commit();
    }

     @Test
    void createMap() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

         Name name = new Name();
         name.setTitle("Doc");
         name.setFirstName("da");
         name.setMiddleName("ce");
         name.setLastName("fe");

         Member member = new Member();
         member.setEmail("contoh@.com");
         member.setName(name);
         member.setSkill(new HashMap<>());
         member.getSkill().put("Java", 100);
         member.getSkill().put("Python", 20);


         entityManager.persist(member);
        transaction.commit();
    }

    @Test
    void updateMap() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Member member = entityManager.find(Member.class, 3);
        member.setSkill(new HashMap<>());
        member.getSkill().put("C++", 43);
        member.getSkill().put("C#", 87);

        entityManager.merge(member);
        transaction.commit();
    }
}
