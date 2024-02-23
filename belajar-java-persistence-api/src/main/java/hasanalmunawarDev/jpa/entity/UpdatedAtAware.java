package hasanalmunawarDev.jpa.entity;

import java.time.LocalDateTime;
import java.util.Calendar;

public interface UpdatedAtAware {

    void setUpdateAt(LocalDateTime dateTime);

    void setCreateAt(Calendar calendar);
}
