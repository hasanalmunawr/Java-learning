package hasanalmunawarDev.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "credentials")
@Setter
@Getter
public class Credential {

    @Id
    private String id;

    private String email;

    private String password;

    @OneToOne(mappedBy = "credential")
    private User user;
}
