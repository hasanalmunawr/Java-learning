package hasanalmunawarDev.jpa.entity;

import hasanalmunawarDev.jpa.listener.CreatedAtListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
@EntityListeners({
        CreatedAtListener.class
})
public abstract class AudiTableEntity<T extends Serializable> implements CreatedAtAware{

    @Id
    private T id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
