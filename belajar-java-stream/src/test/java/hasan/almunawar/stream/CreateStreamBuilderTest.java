package hasan.almunawar.stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class CreateStreamBuilderTest {

    @Test
    void testCreateStreamBuilder() {

        Stream.Builder<String> stringBuilder = Stream.builder();
        stringBuilder.accept("hasan"); //void
        stringBuilder.add("almunawar").add("programer");

        Stream<String> builderToStram = stringBuilder.build();
        builderToStram.forEach(System.out::println);
    }

    @Test
    void testCreateStreamBuilderSimply() {
        Stream<Integer> strBuild = Stream.<Integer>builder()
                .add(1).add(2).add(3).build();
        strBuild.forEach(System.out::println);
    }
}
