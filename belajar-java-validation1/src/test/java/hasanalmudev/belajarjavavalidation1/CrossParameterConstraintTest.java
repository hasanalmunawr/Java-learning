package hasanalmudev.belajarjavavalidation1;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class CrossParameterConstraintTest extends AbstractValidatorTest {

    @Test
    void testCroosParamter() throws NoSuchMethodException {
        UserService userService = new UserService();

        Method method = UserService.class.getMethod("register", String.class, String.class, String.class);
        String username = "hasan";
        String password = "1234";
        String retypePassword = "12341";

        Set<ConstraintViolation<UserService>> constraintViolations = executableValidator.
                validateParameters(userService, method, new Object[]{
                        username, password, retypePassword
                });
        for (ConstraintViolation<UserService> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getPropertyPath());
            System.out.println(constraintViolation.getMessage());
        }
    }
}
