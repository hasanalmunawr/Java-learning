package hasanalmunawarDev.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Transient
    private String fullName;

    @Column(name = "primary_email")
    private String primaryEmail;

    private Byte age;

    private Boolean married;

    @Enumerated(EnumType.STRING)
    private CustomerType type;
}
