package hasanalmuDev.Belajarjavareflection.Annotations;

import java.lang.annotation.*;

@Documented
@Target({
        ElementType.FIELD
})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlank {

    boolean allowEmpetyString() default false;

}
