package hasanalmunawarDev.jpa.entity;

import hasanalmunawarDev.jpa.listener.UpdatedAtListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "brands")
@Setter
@Getter
@NamedQueries({
        @NamedQuery(name = "Brand.findAll", query = "select b from Brand b"),
        @NamedQuery(name = "Brand.findAllWhere", query = "select b from Brand b where b.name = :name")
})
public class Brand extends AudiTableEntity<String>{

    private String name;

    private String description;

    @OneToMany(mappedBy = "brand")
    private List<Product> products;

    @Version
    private Long version;

}
