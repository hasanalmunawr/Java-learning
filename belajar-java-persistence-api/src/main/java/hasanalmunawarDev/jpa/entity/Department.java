package hasanalmunawarDev.jpa.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "departments")
public class Department {

    @EmbeddedId
    private DepertmentId id;

    private String name;
}
