package com.moovy.client.services;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class ServiceException extends RuntimeException
{
    /**
     * Creates a new {@code ServiceException} with the given message and stack trace extracted
     * from the service call.
     *
     * @param message The exception's message.
     * @param stackTrace The exception's stack trace.
     */
    public ServiceException(String message, StackTraceElement[] stackTrace)
    {
        super(message);
        this.setStackTrace(stackTrace);
    }
}
