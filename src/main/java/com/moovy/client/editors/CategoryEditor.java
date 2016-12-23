package com.moovy.client.editors;

import com.moovy.client.services.CategoriesService;

import java.beans.PropertyEditorSupport;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 * @see <a href="http://stackoverflow.com/questions/12875299/spring-mvc-formselect-tag">http://stackoverflow.com/questions/12875299/spring-mvc-formselect-tag</a>
 */
//@Component
public class CategoryEditor extends PropertyEditorSupport
{
    /**
     * An instance of the directors' service to fetch them.
     */
    protected CategoriesService categoriesService = new CategoriesService();

    /**
     * Transforms an input string containing a director's id into a director instance.
     *
     * @param input The input string.
     */
    @Override
    public void setAsText(String input)
    throws NumberFormatException
    {
         this.setValue(this.categoriesService.fetch(input));
    }
}
