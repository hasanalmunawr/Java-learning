package hasanalmudev.belajarjavavalidation1;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Set;

public class MessageI18NTest extends AbstractValidatorTest {

    @Test
    void testI18N() {
        Person person = new Person();
        person.setAddress(new Address());

        Locale.setDefault(new Locale("in", "ID"));
        validate(person);
    }

    @Test
    void testMessageInterpolator() {
       Locale Indonesia = new Locale("in", "ID");

        Person person = new Person();

        Set<ConstraintViolation<Object>> validate = validator.validate(person);
        for (ConstraintViolation<Object> violation : validate) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("============");

            MessageInterpolator.Context context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(), violation.getInvalidValue(), violation.getRootBeanClass(),
                    violation.getPropertyPath(), violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES, true
            );

            String newMessage = messageInterpolator.interpolate(violation.getMessageTemplate(), context, Indonesia);
            System.out.println(newMessage);
        }
    }
}
