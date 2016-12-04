package com.moovy.client.editors;

import com.moovy.client.services.CategoriesService;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 * @see http://stackoverflow.com/questions/12875299/spring-mvc-formselect-tag
 */
@Component
public class CategoriesEditor extends PropertyEditorSupport
{
    /**
     * An instance of the directors' service to fetch them.
     */
    protected CategoriesService categoriesService = new CategoriesService();

    /**
     * Transforms an input string containing a director's id into a director instance.
     *
     * @param input The input string.
     * @throws NumberFormatException If the string can't be parsed as an integer.
     */
    @Override
    public void setAsText(String input)
    throws NumberFormatException
    {
        System.out.println("Categories: " + input);
        // this.setValue(this.directorsService.fetch(Integer.parseInt(input)));
    }
}
