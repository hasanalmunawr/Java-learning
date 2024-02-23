package hasanalmunawarDev.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("VICEPRESIDENT")
public class VicePresident extends Employee {

    @Column(name = "total_manager")
    private Integer totalMaager;

    public Integer getTotalMaager() {
        return totalMaager;
    }

    public void setTotalMaager(Integer totalMaager) {
        this.totalMaager = totalMaager;
    }
}
