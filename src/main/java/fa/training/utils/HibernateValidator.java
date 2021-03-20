package fa.training.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class HibernateValidator {
	public static boolean  isValidInput(Object object) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       
        // It validates bean instances
        Validator validator = factory.getValidator();
       
       
        // Validate bean
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
       
        // Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Object> violation : constraintViolations) {
                System.err.println(violation.getMessage());
            }
            return false;
        } else {
            System.out.println("Valid Object");
            return true;
        }
    }
}
