package hasanalmunawarDev.jpa.listener;

import hasanalmunawarDev.jpa.entity.UpdatedAtAware;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;
import java.util.Calendar;

public class UpdatedAtListener {


    @PreUpdate
    public void setLastUpdated(UpdatedAtAware object) {
        object.setUpdateAt(LocalDateTime.now());
    }

    @PrePersist
    public void setCreated(UpdatedAtAware object) {
        object.setCreateAt(Calendar.getInstance());
    }

}
