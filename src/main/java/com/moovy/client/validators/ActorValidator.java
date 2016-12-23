package com.moovy.client.validators;

import com.moovy.client.entities.Actor;
import com.moovy.client.utils.DateUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class ActorValidator implements Validator
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
        return Actor.class.equals(clazz);
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
        if(target instanceof Actor)
        {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", null, "Vous devez préciser le prénom.");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", null, "Vous devez préciser le nom.");

            // More specific validations
            Actor actor = (Actor) target;

            if(actor.getBirthDate() != null && actor.getDeathDate() != null)
            {
                if(actor.getBirthDate().after(actor.getDeathDate()))
                {
                    errors.rejectValue("deathDate", null, "La date de décès ne peut pas se situer après la date de naissance.");
                }
                else if(DateUtils.isSameDay(actor.getBirthDate(), actor.getDeathDate()))
                {
                    errors.rejectValue("deathDate", null, "La date de décès ne peut pas être égale à la date de naissance.");
                }
            }
        }
    }
}
