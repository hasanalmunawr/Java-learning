package hasanalmudev.belajarjavavalidation1.constraint;

import hasanalmudev.belajarjavavalidation1.enums.CaseMode;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {CheckCaseValidator.class}
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {

    CaseMode mode();
    String message() default "Invalid format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
