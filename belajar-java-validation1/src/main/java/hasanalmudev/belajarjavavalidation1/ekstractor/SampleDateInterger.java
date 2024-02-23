package hasanalmudev.belajarjavavalidation1.ekstractor;

import hasanalmudev.belajarjavavalidation1.Container.DateInterger;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class SampleDateInterger {

    @Min(value = 10)
    @NotNull
    private DateInterger dateInterger;

    public DateInterger getDateInterger() {
        return dateInterger;
    }

    public void setDateInterger(DateInterger dateInterger) {
        this.dateInterger = dateInterger;
    }
}
