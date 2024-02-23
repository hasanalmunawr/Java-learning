package hasanalmudev.belajarjavavalidation1.constraint;

import hasanalmudev.belajarjavavalidation1.group.CreditCardPaymentGroup;
import hasanalmudev.belajarjavavalidation1.group.VirtualAccountPaymentGroup;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.*;


@NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
        message = "{order.id.notblank}")
@Size(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
        min = 1, max = 10, message = "{order.id.size}")
@Documented
@Constraint(
        validatedBy = {}
)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation // menjadi satukan error
public @interface CheckOrderId {

    String message() default "Invalid Order Id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
