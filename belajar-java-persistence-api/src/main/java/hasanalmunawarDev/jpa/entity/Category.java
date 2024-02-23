package hasanalmunawarDev.jpa.entity;

import hasanalmunawarDev.jpa.listener.UpdatedAtListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
@Table(name = "categories")
@Setter
@Getter
@EntityListeners({
        UpdatedAtListener.class
})
public class Category implements UpdatedAtAware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Integer id;

    private String name;

    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Calendar createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;


}
