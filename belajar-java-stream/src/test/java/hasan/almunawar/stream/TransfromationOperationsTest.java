package hasan.almunawar.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class TransfromationOperationsTest {
    @Test
    void testMap() {
//        merubah tipe data dari str ke int
        List<String> stringList = List.of("hasan", "almunawar", "Engginer");
        stringList.stream()
                .map(lengthName -> lengthName.length())
                .forEach(System.out::println);
    }

    @Test
    void testFlatMap() {
        List<String> stringList = List.of("hasan", "almunawar", "Engginer");
        stringList.stream()
                .map(upper -> upper.toUpperCase())
                .flatMap(name -> Stream.of(name, name.length()))
                .forEach(System.out::println);
    }

//    tugas hasan merubah dari int ke string apakah bisa?


    @Test
    void testMapFromIntToStr() {
        List<Integer> age = List.of(12,34,56,78);
        age.stream()
                .map(umur -> umur.toString())
                .forEach(System.out::println);
    }
}
