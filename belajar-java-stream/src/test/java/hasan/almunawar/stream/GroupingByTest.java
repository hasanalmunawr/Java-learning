package hasan.almunawar.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByTest {

    List<Integer> getNumbers() {
        return  List.of(1,2,3,4,5,6,7,8,9);
    }
    List<String> getNames() {
        return  List.of("hasan", "almunawar", "andi", "udin", "dudung", "anto");
    }


    @Test
    void testGroupingBy() {
        Map<String, List<Integer>> map1 = getNumbers().stream().collect(Collectors.groupingBy(
                number -> (number % 2 != 0) ? "Ganjil" : "Genap"
        ));
        System.out.println(map1);
    }

    @Test
    void testGroupingBy1() {
       Map<String, List<String>> map2 = getNames().stream().collect(Collectors.groupingBy(
               name -> (name.length() >= 5) ? "Long" : "short"));
        System.out.println(map2);
    }

    @Test
    void testPaetitioningBy() {
        Map<Boolean, List<Integer>> Ganjil = getNumbers().stream().collect(Collectors.partitioningBy(number -> number % 2 != 0));
        System.out.println(Ganjil);
    }
}
