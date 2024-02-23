package hasanalmunawardeveloper.belajarjavalombok;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonTest  {

    @Test
    void testConstractor() {
        List<String> hobbies = List.of("coding", "film");
        Person person = new Person("id", "hasan", 19, hobbies);
        System.out.println(person);
    }

    @Test
    void testSetter() {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("ngoding");
        hobbies.add("makan");
        hobbies.add("ngopi");

        Person person = new Person("id");
        person.setName("hasan");
        person.setAge(19);
        person.setHobbies(hobbies);

        System.out.println(person);

    }

    @Test
    void testBuilder() {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("ngoding");
        hobbies.add("makan");
        hobbies.add("ngopi");

        var person = Person.builder()
                .id("id")
                .name("hasan")
                .age(19)
                .hobbies(hobbies)
                .build();
        System.out.println(person);

        var person2 = Person.builder().id("ID").name("almunawar").age(19).hobbies(List.of("makan", "minum", "tidur")).build();
        System.out.println(person2);

    }
}
