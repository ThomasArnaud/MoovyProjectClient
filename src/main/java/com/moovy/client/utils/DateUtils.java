package com.moovy.client.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
    public static final DateFormat FORMAT_SHORT = new SimpleDateFormat("dd/MM/yyyy");
}