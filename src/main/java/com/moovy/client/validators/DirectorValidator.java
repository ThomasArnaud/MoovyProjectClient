package com.moovy.client.validators;

import com.moovy.client.entities.Director;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class DirectorValidator implements Validator
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
        return Director.class.equals(clazz);
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
        if(target instanceof Director)
        {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", null, "Vous devez préciser le prénom.");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", null, "Vous devez préciser le nom.");
        }
    }
}
