package hasan.almunawar.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ForEachTest {

    @Test
    void testForEachBeforePeek() {
        List.of("hasan", "almunawar", "software", "engginer").stream()
                .map(name -> {
                    System.out.println("Before change to upper :" + name);
                    String upper = name.toUpperCase();
                    System.out.println("after change to upper :" + upper);
                    return  upper;
                })
                .forEach(System.out::println);
    }

    @Test
    void testForEachAfterPeek() {
        List.of("hasan", "almunawar", "software", "engginer").stream()
                .peek(name -> System.out.println("Before change to upper " + name))
                .map(upper -> upper.toUpperCase())
                .peek(alreadyUpper -> System.out.println("after change to Upper :" + alreadyUpper))
                .forEach(System.out::println);

    }

}
