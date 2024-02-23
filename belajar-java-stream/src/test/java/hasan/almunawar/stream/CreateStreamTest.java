package hasan.almunawar.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamTest {

    @Test
    void testCreateEmpetyOrSingleStream() {

        Stream<String> singleStream = Stream.of("hasan");
        singleStream.forEach(value -> System.out.println(value));
        
        Stream<String> empetyStream = Stream.empty();
        empetyStream.forEach(value -> System.out.println(value));

        String name = null;
        Stream<String> ofNullStream = Stream.ofNullable(name);
        ofNullStream.forEach(value -> System.out.println(value));
    }

    @Test
    void testCreateStreamFromArray() {

        Stream<String> arrayStream = Stream.of("hasan", "almunawar", "devloper");
        arrayStream.forEach(System.out::println);

        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        intStream.forEach(value -> System.out.print("value ke-" + value ));

       String[] names = {"hasan", "almunawar", "engginer"};

       Stream<String> namesStream = Arrays.stream(names);
       namesStream.forEach(System.out::println);
    }

    @Test
    void testCreateStreamFromColection() {

        Collection<String> collectionStr = List.of("Hasan", "almunawar", "engginer");
        Stream<String> collectionToStream = collectionStr.stream();

        collectionToStream.forEach(System.out::println);
    }

    @Test
    void testCreateStreamInfinte() {
        String name = "hasan";
        Stream<String> stringStream = Stream.generate( () -> name);
//        stringStream.forEach(System.out::println);

        int angka = 0;
        Stream<Integer> integerStream = Stream.iterate(angka, value -> value + angka);
        integerStream.forEach(System.out::println);
    }

    
}



