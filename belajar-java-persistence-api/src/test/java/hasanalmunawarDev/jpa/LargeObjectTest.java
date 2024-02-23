package hasanalmunawarDev.jpa;

import hasanalmunawarDev.jpa.entity.Image;
import hasanalmunawarDev.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LargeObjectTest {

    @Test
    void createImage() throws IOException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Image image = new Image();
        image.setName("cow picture");
        image.setDescription("this is black cow picture");
        byte[] bytes = Files.readAllBytes(Path.of(getClass().getResource("/image/cowPicture.jpeg").getPath()));
        image.setImage(bytes);

        entityManager.persist(image);
        transaction.commit();
    }

}
