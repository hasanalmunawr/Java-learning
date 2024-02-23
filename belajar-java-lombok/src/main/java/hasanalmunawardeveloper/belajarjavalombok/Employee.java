package hasanalmunawardeveloper.belajarjavalombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Employee {

    private String id;
    private String name;
}
