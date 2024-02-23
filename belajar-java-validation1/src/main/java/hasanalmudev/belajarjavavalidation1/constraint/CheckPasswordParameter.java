package hasanalmudev.belajarjavavalidation1.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Constraint(
        validatedBy = {CheckPasswordParamterValidator.class}
)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPasswordParameter {

    int passwordParam();
    int retypePasswordParam();
    String message() default "Password and retypePassword must be same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
