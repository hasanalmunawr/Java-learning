package hasanalmudev.belajarjavavalidation1.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class CheckPasswordParamterValidator implements ConstraintValidator<CheckPasswordParameter, Object[]> {

    private int passwordParam;
    private int retypePasswordParam;

    @Override
    public void initialize(CheckPasswordParameter constraintAnnotation) {
        this.passwordParam = constraintAnnotation.passwordParam();
        this.retypePasswordParam = constraintAnnotation.retypePasswordParam();
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        String password = (String) value[passwordParam];
        String retypePasswrod = (String) value[retypePasswordParam];

        return  password.equals(retypePasswrod);
    }
}
