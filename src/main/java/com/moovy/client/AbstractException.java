package com.moovy.client;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public abstract class AbstractException extends Exception
{
    /**
     * The title to be displayed on the page.
     */
    protected String title;

    /**
     * Gets the title to be displayed.
     *
     * @return The title.
     */
    public String getTitle()
    {
        return this.title;
    }
}
