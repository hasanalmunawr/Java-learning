package hasanalmunawarDev.jpa.listener;

import hasanalmunawarDev.jpa.entity.CreatedAtAware;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class CreatedAtListener {

    @PrePersist
    public void createdAt(CreatedAtAware object) {
        object.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void UpdatedAt(CreatedAtAware object) {
        object.setUpdatedAt(LocalDateTime.now());
    }
}
