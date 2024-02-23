package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Brand;
import hasanalmunawarDev.jpa.entity.Product;
import hasanalmunawarDev.jpa.entity.SimpleBrand;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CreteriaTest {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteria = builder.createQuery(Brand.class);
        Root<Brand> b = criteria.from(Brand.class);
        criteria.select(b);
        // select b from Brand b;

        TypedQuery<Brand> query = entityManager.createQuery(criteria);
        List<Brand> brands = query.getResultList();
        brands.forEach(brand -> System.out.println(brand.getId()+ " : "+brand.getName()));
    }
     @Test
    void criteriaNonEntity() { // JIKA INGIN MENGAMBIL FIELD NYA SAJA
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

         CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
         CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
         Root<Brand> b = query.from(Brand.class);
         query.select(criteriaBuilder.array(b.get("id"), b.get("name")));
         // SELECT b.id, b.name FROM BRAND b

         TypedQuery<Object[]> query1 = entityManager.createQuery(query);
         List<Object[]> resultList = query1.getResultList();
         for (Object[] objects : resultList) {
             System.out.println(objects[0]+" : "+objects[1]);
         }
     }
    @Test
    void constractorExpresion() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SimpleBrand> query = builder.createQuery(SimpleBrand.class);
        Root<Brand> b = query.from(Brand.class);
        query.select(builder.construct(SimpleBrand.class, b.get("id"), b.get("name")));

        TypedQuery<SimpleBrand> query1 = entityManager.createQuery(query);
        List<SimpleBrand> resultList = query1.getResultList();
        resultList.forEach(simpleBrand -> System.out.println(simpleBrand.getId()+" : "+simpleBrand.getName()));
    }

    @Test
    void whereClause() { // DEFAULT USE AND
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> query = builder.createQuery(Brand.class);
        Root<Brand> b = query.from(Brand.class);
        query.where(
                builder.equal(b.get("id"), "Vivo"),
                builder.isNotNull(b.get("createdAt"))
        );

        TypedQuery<Brand> query1 = entityManager.createQuery(query);
        query1.getResultList().forEach(brand -> System.out.println(brand.getId()+" : "+brand.getName()));
    }
     @Test
    void whereClauseUseOr() { // DEFAULT USE AND
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> query = builder.createQuery(Brand.class);
        Root<Brand> b = query.from(Brand.class);
        query.where(
                builder.or(
                        builder.equal(b.get("id"), "Xiaomi"),
                        builder.equal(b.get("id"), "Samsung")
                )
        );
        // SELECT * FROM BRAND WHERE ID = XIAOMI OR ID = SAMSUNG

        TypedQuery<Brand> query1 = entityManager.createQuery(query);
        query1.getResultList().forEach(brand -> System.out.println(brand.getId()+" : "+brand.getName()));
    }
 @Test
    void joinClause() { // DEFAULT USE AND
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

     CriteriaBuilder builder = entityManager.getCriteriaBuilder();
     CriteriaQuery<Product> productCriteriaQuery = builder.createQuery(Product.class);
     Root<Product> p = productCriteriaQuery.from(Product.class);
     Join<Product, Brand> brand = p.join("brand");

     productCriteriaQuery.select(p);
     productCriteriaQuery.where(builder.equal(brand.get("id"), "Xiaomi"));
     // SELECT * FROM PRODUCT JOIN BRAND

     TypedQuery<Product> query = entityManager.createQuery(productCriteriaQuery);
     query.getResultList().forEach(product -> System.out.println(product.getId()+" : "+product.getName()+" : "+product.getBrand()));
 }
    @Test
    void creteriaParameter() { // DEFAULT USE AND
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

     CriteriaBuilder builder = entityManager.getCriteriaBuilder();
     CriteriaQuery<Product> productCriteriaQuery = builder.createQuery(Product.class);
     Root<Product> p = productCriteriaQuery.from(Product.class);
     Join<Product, Brand> brand = p.join("brand");

        ParameterExpression<String> parameterName = builder.parameter(String.class);

        productCriteriaQuery.select(p);
     productCriteriaQuery.where(builder.equal(brand.get("id"), parameterName));
     // SELECT * FROM PRODUCT JOIN BRAND

     TypedQuery<Product> query = entityManager.createQuery(productCriteriaQuery);
     query.setParameter(parameterName, "Xiaomi");
     query.getResultList().forEach(product -> System.out.println(product.getId()
             +" : "+product.getName()+" : "+product.getBrand().getName()));
 }
    @Test
    void aggregateQuery() { // DEFAULT USE AND
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

     CriteriaBuilder builder = entityManager.getCriteriaBuilder();
     CriteriaQuery<Object[]> productCriteriaQuery = builder.createQuery(Object[].class);
     Root<Product> p = productCriteriaQuery.from(Product.class);
     Join<Product, Brand> brand = p.join("brand");

//     productCriteriaQuery.select(builder.array(
//             brand.get("id"),
//             builder.min(p.get("price")),
//             builder.max(p.get("price")),
//             builder.avg(p.get("price"))
//     ));

     productCriteriaQuery.select(builder.array(
             brand.get("id"),
             builder.min(p.get("price")),
             builder.max(p.get("price")),
             builder.avg(p.get("price"))
     ));

     productCriteriaQuery.groupBy(brand.get("id"));
     productCriteriaQuery.having(builder.greaterThan(builder.min(p.get("price")), 500_000L));

        TypedQuery<Object[]> query = entityManager.createQuery(productCriteriaQuery);
        query.getResultList().forEach(objects -> {
            System.out.println(objects[0]);
            System.out.println(objects[1]);
            System.out.println(objects[2]);
            System.out.println(objects[3]);
        });
    }

    @Test
    void creteriaNonQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Brand> criteriaUpdate = builder.createCriteriaUpdate(Brand.class);
        Root<Brand> b = criteriaUpdate.from(Brand.class);

        criteriaUpdate.set(b.get("name"), "Vivo updated");
        criteriaUpdate.where(
                builder.equal(b.get("id"), "Vivo")
        );

        Query query = entityManager.createQuery(criteriaUpdate);
        int firstResult = query.executeUpdate();
        System.out.println("succes updated "+firstResult+" procces");

        transaction.commit();
    }

    @Test
    void criteriaNonQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Brand> criteria = builder.createCriteriaUpdate(Brand.class);
        Root<Brand> b = criteria.from(Brand.class);

        criteria.set(b.get("name"), "Xiaomi Updated");
        criteria.set(b.get("description"), "Xiaomi Company");

        criteria.where(
                builder.equal(b.get("id"), "Xiaomi")
        );

        Query query = entityManager.createQuery(criteria);
        int impactedRecords = query.executeUpdate();
        System.out.println("Success update " + impactedRecords + " records");

        entityTransaction.commit();
        entityManager.close();
    }
}
