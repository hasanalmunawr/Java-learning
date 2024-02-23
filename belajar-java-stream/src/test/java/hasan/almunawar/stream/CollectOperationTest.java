package hasan.almunawar.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectOperationTest {

    Stream<String> getStream() {
        return  Stream.of("hasan", "almunawar", "andi", "udin", "dudung", "anto");
    }

    @Test
    void testCollectorCollection() {
//       merubah stream ke dalam set
        Set<String> stringSet = getStream().collect(Collectors.toSet());
        System.out.println(stringSet);
        Set<String> immutable = getStream().collect(Collectors.toUnmodifiableSet());
        System.out.println(immutable);

//        merubah stream kedalam list
        List<String> stringList = getStream().collect(Collectors.toList());
        System.out.println(stringList);
        List<String> imutbaleList = getStream().collect(Collectors.toUnmodifiableList());
        System.out.println(imutbaleList);

    }

    @Test
    void testMapWithCollectors() {
//        merubah stream kedalam Map
        Map<String, Integer> lengthName = getStream().collect(Collectors.toMap(
                name -> name,
                panjang -> panjang.length()
        ));
        System.out.println(lengthName);
    }
}
