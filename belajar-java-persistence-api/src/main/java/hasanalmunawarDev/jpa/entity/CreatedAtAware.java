package hasanalmunawarDev.jpa.entity;

import java.time.LocalDateTime;
import java.util.Calendar;

public interface CreatedAtAware {
    void setUpdatedAt(LocalDateTime dateTime);

    void setCreatedAt(LocalDateTime dateTime);
}
