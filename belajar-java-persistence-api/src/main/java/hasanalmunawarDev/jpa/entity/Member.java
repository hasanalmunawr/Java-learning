package hasanalmunawarDev.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "members")
@Setter
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    @Embedded
    private Name name;

    @ElementCollection
    @CollectionTable(name = "hobbies", joinColumns = @JoinColumn(
            name = "member_id", referencedColumnName = "id"
    ))
    @Column(name = "name")
    private List<String> hobby;

    @ElementCollection
    @CollectionTable(name = "skills", joinColumns = @JoinColumn(
            name = "member_id", referencedColumnName = "id"
    ))
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    private Map<String, Integer> skill;

    @Transient
    private String fullName;

    @PostLoad // ketika loat akan secara otomatis dibikin nama full nya
    public void postLoad() {
        fullName = getName().getTitle() +"."+ getName().getFirstName()+" "+ getName().getMiddleName()+" "+getName().getLastName();
    }

}
