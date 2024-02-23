package hasanalmunawardeveloper.belajarjavalombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data // setter, getter, toString, ect
@RequiredArgsConstructor(staticName = "create")
@AllArgsConstructor
@ToString(exclude = {
        "price"
})
public class Product {

    private final String id;
    private String name;
    private Long price;
}
