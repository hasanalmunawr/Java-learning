package PersonTestMok;

import data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.PersonRepository;
import service.PersonService;

@Extensions(
        @ExtendWith(MockitoExtension.class)
)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetNoFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get("not found");
        });
    }

    @Test
    void testRegisterSucces() {
        var person = personService.register("hasan");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("hasan", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "hasan"));

    }
}
