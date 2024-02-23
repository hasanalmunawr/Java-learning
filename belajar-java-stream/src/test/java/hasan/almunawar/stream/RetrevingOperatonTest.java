package hasan.almunawar.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class RetrevingOperatonTest {
    @Test
    void testLimit() {
        List.of("Hasan", "almunwar", "software", "engginer", "start-up").stream()
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    void skipTest() {
        List.of("Hasan", "almunwar", "software", "engginer", "start-up").stream()
                .skip(2)
                .forEach(System.out::println);

    }

    @Test
    void takeWhileTest() { //true or false
        List.of(1,2,3,4,5,6,7,8).stream()
                .takeWhile(name -> name > 1)
                .forEach(System.out::println);
    }

    @Test
    void testDropWhile() {
        List.of(1,2,3,4,5,6,7,8).stream()
                .dropWhile(number ->number > 0)
                .forEach(System.out::println);
    }

//    mengambiil satu elemen random

    @Test
    void testFindAny() {
        List<Integer> numbers = List.of(1,2,3,4,5);

        Optional<Integer> randomNumber = numbers.stream()
                .findAny();
       randomNumber.ifPresent(numb -> {
           System.out.println(numb);
       });
    }

    @Test
    void test() {
        List<Integer> numbers = List.of(1,2,3,4,5);

        Optional<Integer> number = numbers.stream().findFirst();
        number.ifPresent(numb  -> {
            System.out.println(numb);
        });
    }
}
