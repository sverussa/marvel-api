package api.marvel.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;

public class ParametersValidator implements ConstraintValidator<ParametersValid, Map<String, String>> {

    private String returnMessage;

    @Override
    public void initialize(ParametersValid constraintAnnotation) {
        returnMessage = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Map<String, String> parameters, ConstraintValidatorContext constraintValidatorContext) {
        if (parameters != null) {
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
                if (entry.getKey().equals("name")) {

                }

                if (entry.getKey().equals("nameStartsWith")) {

                }

                if (entry.getKey().equals("modifiedSince")) {

                }

                if (entry.getKey().equals("comics")) {

                }

                if (entry.getKey().equals("series")) {

                }

                if (entry.getKey().equals("events")) {

                }

                if (entry.getKey().equals("stories")) {

                }

                if (entry.getKey().equals("orderBy")) {

                }

                if (entry.getKey().equals("limit")) {

                }

                if (entry.getKey().equals("offset")) {

                }

                // todo parametro invalido


            }
        }

        return true;
    }
}
