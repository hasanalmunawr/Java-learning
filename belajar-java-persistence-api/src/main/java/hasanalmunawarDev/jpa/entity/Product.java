package hasanalmunawarDev.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "products")
@Setter
@Getter
@NamedNativeQueries({
        @NamedNativeQuery(name = "Product.native.findAll", query = "select * from products",
                resultClass = Product.class)
})
public class Product {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.EAGER) // default eager, lazy quary tanpa join left, namun dapat menyebabkan kerja 2x
    @JoinColumn(name = "brand_id",
            referencedColumnName = "id")
    private Brand brand;

    private String name;

    private Long price;

    private String description;

    @ManyToMany(mappedBy = "likes")
    private Set<User> likedBy;
}
