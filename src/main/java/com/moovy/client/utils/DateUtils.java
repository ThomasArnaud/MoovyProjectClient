package com.moovy.client.utils;

import com.moovy.client.text.DateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public abstract class DateUtils
{
    /**
     * A date formatter for a short format.
     */
    public static final DateFormat FORMAT_SHORT = new DateFormat("dd/MM/yyyy");

    /**
     * Tests if two dates happen on the same day.
     *
     * @param a The first date.
     * @param b The second date.
     * @return {@code true} if both dates happen on the same day, {@code false} otherwise.
     */
    public static boolean isSameDay(Date a, Date b)
    {
        Calendar calendarA = Calendar.getInstance();
        calendarA.setTime(a);
        Calendar calendarB = Calendar.getInstance();
        calendarB.setTime(b);

        return
            calendarA.get(Calendar.YEAR) == calendarB.get(Calendar.YEAR)
            && calendarA.get(Calendar.MONTH) == calendarB.get(Calendar.MONTH)
            && calendarA.get(Calendar.DAY_OF_MONTH) == calendarB.get(Calendar.DAY_OF_MONTH)
        ;
    }
}
