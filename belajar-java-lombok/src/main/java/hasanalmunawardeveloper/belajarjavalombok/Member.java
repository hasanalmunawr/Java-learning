package hasanalmunawardeveloper.belajarjavalombok;

import lombok.Data;
import lombok.NonNull;

@Data
public class Member {

    @NonNull
    private String id;

    @NonNull
    private String nama;

    private String alamat;

    public String sayHello(@NonNull String name) {
        return "hello " + name + " my name is " + this.nama;
    }
}
