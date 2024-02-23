package hasanalmudev.belajarjavavalidation1;

import hasanalmudev.belajarjavavalidation1.constraint.CheckPasswordParameter;
import jakarta.validation.constraints.NotBlank;

public class UserService {

    @CheckPasswordParameter(
            passwordParam = 1,
            retypePasswordParam = 2
    )
    public void register(@NotBlank(message = "Can not blank") String username,
                       @NotBlank(message = "Can not blank") String password,
                       @NotBlank(message = "Can not blank") String retypePassword) {
        // TODO SOMETHNG
    }
}
