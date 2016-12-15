package com.moovy.client.text;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class DateFormat extends SimpleDateFormat
{
    /**
     * {@inheritDoc}
     */
    public DateFormat(String pattern)
    {
        super(pattern);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date parse(String input)
    throws ParseException
    {
        return new Date(super.parse(input).getTime());
    }
}
