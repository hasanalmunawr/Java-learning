package hasanalmunawardeveloper.belajarjavalombok;

import lombok.Value;
import lombok.With;

@Value // membuat menjadi final dan privat otomatise
@With
public class Register {

    String email;
    String password;
}
