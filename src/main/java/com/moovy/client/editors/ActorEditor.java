package com.moovy.client.editors;

import com.moovy.client.services.ActorsService;

import java.beans.PropertyEditorSupport;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 * @see <a href="http://stackoverflow.com/questions/12875299/spring-mvc-formselect-tag">http://stackoverflow.com/questions/12875299/spring-mvc-formselect-tag</a>
 */
//@Component
public class ActorEditor extends PropertyEditorSupport
{
    /**
     * An instance of the actors' service to fetch them.
     */
    protected ActorsService actorsService = new ActorsService();

    /**
     * Transforms an input string containing an actor's id into an actor instance.
     *
     * @param input The input string.
     * @throws NumberFormatException If the string can't be parsed as an integer.
     */
    @Override
    public void setAsText(String input)
    throws NumberFormatException
    {
        this.setValue(this.actorsService.fetch(Integer.parseInt(input)));
    }
}
