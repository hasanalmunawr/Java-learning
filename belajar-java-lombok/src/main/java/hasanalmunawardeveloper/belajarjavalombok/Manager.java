package hasanalmunawardeveloper.belajarjavalombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Manager extends Employee {

    private Integer totalEmployee;

}
