package hasanalmunawarDev.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "images")
@Setter
@Getter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Lob
    private String description;

    @Lob
    private byte[] image;
}
