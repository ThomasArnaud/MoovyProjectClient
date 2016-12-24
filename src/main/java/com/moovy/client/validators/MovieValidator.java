package com.moovy.client.validators;

import com.moovy.client.entities.Movie;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
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
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", null, "Vous devez préciser le titre.");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "duration", null, "Vous devez préciser la durée.");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "releaseDate", null, "Vous devez préciser la date de sortie.");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "budget", null, "Vous devez préciser le budget.");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "benefit", null, "Vous devez préciser le bénéfice réalisé.");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "director", null, "Vous devez préciser le réalisateur.");

            // More specific validations
            Movie movie = (Movie) target;

            if(movie.getDuration() < 0)
            {
                errors.rejectValue("duration", null, "La durée ne peut pas être négative.");
            }

            if(movie.getBudget() < 0)
            {
                errors.rejectValue("budget", null, "Le budget ne peut pas être négatif.");
            }

            if(movie.getBenefit() < 0)
            {
                errors.rejectValue("benefit", null, "Les bénéfices ne peuvent pas être négatifs.");
            }
        }
    }
}
