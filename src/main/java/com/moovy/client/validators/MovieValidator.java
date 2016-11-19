package com.moovy.client.validators;

import com.moovy.client.entities.Movie;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author bruno.
 */
public class MovieValidator implements Validator
{
    /**
     * Tests if this validator can be used for that class.
     *
     * @param clazz The class to test.
     * @return {@code true} if the validator supports this class, {@code false} otherwise.
     */
    @Override
    public boolean supports(Class<?> clazz)
    {
        return Movie.class.equals(clazz);
    }

    /**
     * Validates an object.
     *
     * @param target The object to validate.
     * @param errors The errors list.
     */
    @Override
    public void validate(Object target, Errors errors)
    {
        if(target instanceof Movie)
        {
            /*
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", null, "Vous devez préciser le prénom.");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", null, "Vous devez préciser le nom.");
            */
        }
    }
}
