package hasanalmudev.belajarjavavalidation1.ekstractor;

import hasanalmudev.belajarjavavalidation1.Container.Data;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SampleData {

    @NotNull
    private Data<@NotBlank @Max(10) String> data;

    public Data<String> getData() {
        return data;
    }

    public void setData(Data<String> data) {
        this.data = data;
    }
}
