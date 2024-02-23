package hasan.almunawar.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class LazyValuetionTest {

    @Test
    void testIntermediateOperation() {
        List<String> stringList = List.of("hasan", "almunawar", "engginer");
        stringList.stream()
                .map(upper -> upper.toUpperCase())
                .map(Mr -> {
                    System.out.println("mr " + Mr);
                    return Mr.toLowerCase();
                })
                .forEach(name -> {
            System.out.println("nama nya adalah " + name);
        });


    }
}
