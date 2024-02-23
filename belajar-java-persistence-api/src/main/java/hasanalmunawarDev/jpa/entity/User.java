package hasanalmunawarDev.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
public class User {

    @Id
    private String id;

    private String name;

    @OneToOne
    @JoinColumn(name = "id" , referencedColumnName = "id")
    private Credential credential;

    @OneToOne(mappedBy = "user")
    private Wallet wallet;

    @ManyToMany
    @JoinTable(name = "users_likes_products",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private Set<Product> likes;
}
