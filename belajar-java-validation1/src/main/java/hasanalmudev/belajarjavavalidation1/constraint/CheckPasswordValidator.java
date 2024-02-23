package hasanalmudev.belajarjavavalidation1.constraint;

import hasanalmudev.belajarjavavalidation1.Register;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    private String messageTemplate;
    @Override
    public boolean isValid(Register register, ConstraintValidatorContext context) {
        if(register.getPassword() == null || register.getRetypePassword() == null) {
            return  true;
        }
        boolean isValid = register.getPassword().equals(register.getRetypePassword());


        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("password")
                    .addConstraintViolation();

            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("retypePassword")
                    .addConstraintViolation();
        }
        return  isValid;
    }

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        messageTemplate = constraintAnnotation.message();
    }
}
