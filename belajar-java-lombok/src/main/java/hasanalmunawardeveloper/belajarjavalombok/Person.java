package hasanalmunawardeveloper.belajarjavalombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Person {

    private final String id;

    private String name;

    private int age;

    private List<String> hobbies;
}
