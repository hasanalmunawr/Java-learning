package hasanalmunawardeveloper.belajarjavalombok;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Merchant {

    private final String id;
    private String name;
}
