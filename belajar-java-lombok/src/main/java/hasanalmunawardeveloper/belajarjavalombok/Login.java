package hasanalmunawardeveloper.belajarjavalombok;

import lombok.*;

@Getter
@NoArgsConstructor(staticName = "createEmpety")
@AllArgsConstructor(staticName = "create")
@ToString(exclude = {
        "password"
})
public class Login {

    @Setter(value = AccessLevel.PROTECTED)
    private String username;

    @Setter(value = AccessLevel.PROTECTED)
    private String password;
}
