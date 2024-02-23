package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityManagerFactoryTest {

    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        Assertions.assertNotNull(entityManagerFactory);
        entityManagerFactory.close();
    }
}
