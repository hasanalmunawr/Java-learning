package hasan.almunawar.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamOperationTest {
    @Test
    void testStreamOperation() {
        List<String> stringList = List.of("hasan", "almunawar", "Engginer");
        Stream<String> stream = stringList.stream();
        Stream<String> strUpper = stream.map(nama -> nama.toUpperCase());
        Stream<String> strMR = strUpper.map(mr -> "Mr." + mr);
        strMR.forEach(System.out::println);
        stringList.forEach(System.out::println); //stream tidak merubah data asli

    }

    @Test
    void testStreamPipeLine() {
        // LEBIH EFESIEN
        List<String> stringList = List.of("hasan", "almunawar", "Engginer");
        stringList.stream()
                .map(name -> name.toUpperCase())
                .map(upper -> "Mr." + upper)
                .forEach(System.out::println);

    }
}
