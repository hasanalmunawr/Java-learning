package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.*;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class QueryLanguageTest {

    @Test
    void selectQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Brand> query = entityManager.createQuery("select b from Brand b", Brand.class);
        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println("Id : "+brand.getId()+ " name : "+ brand.getName());
        }
    }

    @Test
    void whereClause() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Member> query = entityManager.createQuery("select m from Member m where m.name.firstName = :firstName " +
                "and m.name.lastName = :lastName", Member.class);
        query.setParameter("firstName", "Hasan");
        query.setParameter("lastName", "Agus");
        List<Member> resultList = query.getResultList();
        for (Member member : resultList) {
            System.out.println(member.getId()+" "+member.getFullName());
        }
    }

     @Test
    void joinClause() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

//         TypedQuery<Product> query = entityManager
//                 .createQuery("select p from Product p join p.brand b where b.name = :brand", Product.class);
//         query.setParameter("brand", "Samsung");
         TypedQuery<Product> query = entityManager
                 .createQuery("select p from Product p join p.brand b where b.name = :brand", Product.class);
         query.setParameter("brand", "Samsung");
         List<Product> resultList = query.getResultList();
         System.out.println(resultList);

         transaction.commit();
         entityManager.close();
     }
 @Test
    void joinPetch() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

     TypedQuery<User> query = entityManager.createQuery("select u from User u join fetch u.likes p where p.name = :product", User.class);
     query.setParameter("product", "Xiaomi note 12");

//     TypedQuery<User> query = entityManager.createQuery("select u from User u join fetch u.likes p where p.name = :product", User.class);
//     query.setParameter("product", "Samsung Galaxy 1");

     List<User> resultList = query.getResultList();
     for (User user : resultList) {
         System.out.println(user.getName());
     }

     transaction.commit();
         entityManager.close();
     }

    @Test
    void orderBy() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Brand> query = entityManager
                .createQuery("select b from Brand b order by b.name desc", Brand.class);

        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getId()+" : "+brand.getName());
        }
    }

    @Test
    void insertBrand() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        for (int i = 0; i < 100; i++) {
            Brand brand = new Brand();
            brand.setId(String.valueOf(i));
            brand.setName("Brand-"+i);
            entityManager.persist(brand);
        }
        transaction.commit();
    }

    @Test
    void limitOffset() throws InterruptedException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Brand> query = entityManager
                .createQuery("select b from Brand b order by b.name desc", Brand.class);
//        query.setFirstResult(10); // UNTUK MENGATUR LIMIT
         query.setMaxResults(10); // UNTUK MENGATUR RESULT/ YANG DIKELUARKAN/ OFFSET

        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getId()+" : "+brand.getName());
            Thread.sleep(1000L);
        }
    }

    @Test
    void namedQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Brand> query = entityManager.createNamedQuery("Brand.findAll", Brand.class);
        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getId()+ " : "+ brand.getName());
        }
        transaction.commit();
    }
    @Test
    void namedQueryWithParameter() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Brand> query = entityManager.createNamedQuery("Brand.findAllWhere", Brand.class);
        query.setParameter("name", "Xiaomi Indonesia");
        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getId()+ " : "+ brand.getName()+" : "+brand.getProducts().toString());
        }
        transaction.commit();
    }

    @Test
    void selectSomeFiled() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Object[]> query = entityManager.createQuery("select b.id, b.name from Brand b where b.id = :id", Object[].class);
        query.setParameter("id", "realme");
        List<Object[]> resultList = query.getResultList();
        for (Object[] objects : resultList) {
            System.out.println(objects[0]+" : "+objects[1]);
        }
    }
    @Test
    void constractorExpresion() { // LEBIH DI SARANKAN INI DARI PADA "SELECTSOMEFIELD"
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<SimpleBrand> query = entityManager.createQuery("select new hasanalmunawarDev.jpa.entity.SimpleBrand(b.id, b.name) " +
                "from Brand b where b.name = :name", SimpleBrand.class);

        query.setParameter("name", "realme local");
        List<SimpleBrand> resultList = query.getResultList();
        for (SimpleBrand simpleBrand : resultList) {
            System.out.println(simpleBrand.getId()+" : "+simpleBrand.getName());
        }
    }

    @Test
    void agregatQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Object[]> query = entityManager.createQuery("select min(p.price), max(p.price), avg(p.price) from Product p", Object[].class);
        List<Object[]> resultList = query.getResultList();
        for (Object[] objects : resultList) {
            System.out.println("min : "+objects[0]);
            System.out.println("max : "+objects[1]);
            System.out.println("average : "+objects[2]);
        }
    }
    @Test
    void groupBy() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Object[]> query = entityManager.createQuery("select b.id, min(p.price), max(p.price), avg(p.price) " +
                "from Product p join p.brand b group by b.id having min(p.price) > :price", Object[].class);
        query.setParameter("price", 2_000_000L);

        List<Object[]> resultList = query.getResultList();
        for (Object[] objects : resultList) {
            System.out.println(objects[0]);
            System.out.println(objects[1]);
            System.out.println(objects[2]);
            System.out.println(objects[3]);
        }
    }

    @Test
    void nativeQuary() { // TIDAK DIREKOMENDASIKAN UNTUK GET QUERY MANUAL
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query nativeQuery = entityManager.createNativeQuery("select * from brands  where brands.updated_At is not null ", Brand.class);
        List<Brand> resultList = nativeQuery.getResultList();
        for (Brand brand : resultList) {
            System.out.println(brand.getId()+" : "+brand.getName()+ "  "+brand.getUpdatedAt());
        }
    }

    @Test
    void namedNativeQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Product> namedQuery = entityManager.createNamedQuery("Product.native.findAll", Product.class);
        List<Product> brands = namedQuery.getResultList();
        for (Product brand : brands) {
            System.out.println(brand.getId()+" : "+brand.getName());
        }
    }
    @Test
    void updateNonQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createQuery("update Brand b set b.name = :name where b.id = :id");
        query.setParameter("name", "Xiaomi Indo");
        query.setParameter("id", "Xiaomi");

        int impact = query.executeUpdate();
        System.out.println("Succes "+impact+ " Update");
    }




}

