package api.marvel.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ParametersValidator.class)
@Target( { ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ParametersValid {

    String message() default "Parameters Invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
