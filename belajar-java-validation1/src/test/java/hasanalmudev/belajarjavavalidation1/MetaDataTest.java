package hasanalmudev.belajarjavavalidation1;

import jakarta.validation.metadata.BeanDescriptor;
import jakarta.validation.metadata.ConstraintDescriptor;
import jakarta.validation.metadata.PropertyDescriptor;
import org.junit.jupiter.api.Test;

public class MetaDataTest extends AbstractValidatorTest {

    @Test
    void test() {
        BeanDescriptor beanDescriptor = validator.getConstraintsForClass(Person.class);
        for (PropertyDescriptor property : beanDescriptor.getConstrainedProperties()) {
            System.out.println(property.getPropertyName());
            for (ConstraintDescriptor<?> descriptor : property.getConstraintDescriptors()) {
                System.out.println(descriptor);
            }
        }
    }
}
