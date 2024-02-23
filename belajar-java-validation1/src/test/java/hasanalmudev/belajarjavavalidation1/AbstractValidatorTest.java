package hasanalmudev.belajarjavavalidation1;

import hasanalmudev.belajarjavavalidation1.ekstractor.DataIntergerValueExctractor;
import hasanalmudev.belajarjavavalidation1.ekstractor.DataValueExtractor;
import hasanalmudev.belajarjavavalidation1.ekstractor.EntryValueExtractorKey;
import hasanalmudev.belajarjavavalidation1.ekstractor.EntryValueExtractorValue;
import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public abstract class AbstractValidatorTest {

    protected ValidatorFactory validatorFactory;
    protected Validator validator;
    protected ExecutableValidator executableValidator;
    protected MessageInterpolator messageInterpolator;

    @BeforeEach
    void setUp() {
//        validatorFactory = Validation.buildDefaultValidatorFactory();

        //mendaftarkan  extractor
        validatorFactory = Validation.byDefaultProvider().configure()
                .addValueExtractor(new DataValueExtractor()) //mandftarkan
                .addValueExtractor(new EntryValueExtractorKey())
                .addValueExtractor(new EntryValueExtractorValue())
                .addValueExtractor(new DataIntergerValueExctractor())
                .buildValidatorFactory();


        validator = validatorFactory.getValidator();
        executableValidator = validator.forExecutables();
        messageInterpolator = validatorFactory.getMessageInterpolator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    void validate(Object o) {
        Set<ConstraintViolation<Object>> validate = validator.validate(o);
        for (ConstraintViolation<Object> violation : validate) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("============");

        }
    }
    void validateWithException(Object o) {
        Set<ConstraintViolation<Object>> validate = validator.validate(o);
        if(!validate.isEmpty()) {
            throw new ConstraintViolationException(validate);
        }
    }

    void validateWithGroups(Object o, Class<?> groups) {
        Set<ConstraintViolation<Object>> validate = validator.validate(o, groups);
        for (ConstraintViolation<Object> violation : validate) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("============");

        }
    }

}
