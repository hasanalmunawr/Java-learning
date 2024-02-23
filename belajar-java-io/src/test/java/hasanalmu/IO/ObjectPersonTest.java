package hasanalmu.IO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ObjectPersonTest {

    @Test
    void create() {
        Person person = new Person();
        person.setId(1);
        person.setName("hasan");

        Path path = Path.of("hasan.person");
        try (OutputStream outputStream = Files.newOutputStream(path)) {
            ObjectOutputStream stream = new ObjectOutputStream(outputStream);
            stream.writeObject(person);
            stream.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void get() {
        Path path = Path.of("hasan.person");
        try (InputStream inputStream = Files.newInputStream(path)) {
            ObjectInputStream stream = new ObjectInputStream(inputStream);
            Person person = (Person) stream.readObject();
            Assertions.assertEquals(1, person.getId());
            Assertions.assertEquals("hasan", person.getName());

            System.out.println(person.getId());
            System.out.println(person.getName());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testSuka() {
        Person person = new Person();
        person.setId(2);
        person.setName("deva");
        Path path = Path.of("hasanPerson.Person");

        try (OutputStream outputStream = Files.newOutputStream(path,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            ObjectOutputStream stream = new ObjectOutputStream(outputStream);
            stream.writeObject(person);
            stream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
