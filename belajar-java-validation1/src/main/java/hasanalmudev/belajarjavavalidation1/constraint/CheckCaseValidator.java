package hasanalmudev.belajarjavavalidation1.constraint;

import hasanalmudev.belajarjavavalidation1.enums.CaseMode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintViolation;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {
    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
       caseMode = constraintAnnotation.mode();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null) return true; // skip validation if value null

        if(caseMode == CaseMode.UPPER) {
            return  value.equals(value.toUpperCase());
        } else if (caseMode == CaseMode.LOWER) {
            return  value.equals(value.toLowerCase());
        }
        return  false;
    }
}
