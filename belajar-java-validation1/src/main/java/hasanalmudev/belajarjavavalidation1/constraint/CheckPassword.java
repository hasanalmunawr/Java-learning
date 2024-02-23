package hasanalmudev.belajarjavavalidation1.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPasswordValidator.class)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPassword {

    String message() default "Password and retypePassword must be same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
