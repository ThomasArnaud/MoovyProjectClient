package com.moovy.client.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 * @see <a href="https://www.tutorialspoint.com/jsp/jsp_custom_tags.htm">TutorialsPoint</a>
 */
public class FormatMinutesTag extends SimpleTagSupport
{
    /**
     * The value, in minutes, to output.
     */
    protected int value;

    /**
     * Sets the value, in minutes, to output.
     *
     * @param value The value.
     */
    public void setValue(int value)
    {
        this.value = value;
    }

    /**
     * Prints the isRequired formatted in hours and minutes.
     *
     * @throws JspException If a JSP error happens.
     * @throws IOException If a I/O error happens.
     */
    @Override
    public void doTag()
    throws JspException, IOException
    {
        // Initialize vars
        JspWriter writer = this.getJspContext().getOut();
        StringBuilder stringBuilder = new StringBuilder();

        if(this.value > 60)
        {
            stringBuilder.append((int) (this.value / 60));
            stringBuilder.append("h");

            this.value = this.value % 60;
        }
        else if(this.value < 0)
        {
            writer.println(this.value);

            return;
        }

        stringBuilder.append(String.format(
            "%1$02d",
            this.value
        ));
        stringBuilder.append("min");

        writer.println(stringBuilder.toString());
    }
}
