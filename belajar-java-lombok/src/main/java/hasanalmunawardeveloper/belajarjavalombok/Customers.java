package hasanalmunawardeveloper.belajarjavalombok;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {
        "username" // username di notaktifkan
})
public class Customers {

    private String id;

    private String username;

}
