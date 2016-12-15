package com.moovy.client.utils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.UriBuilder;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class RestUtils
{
    /**
     *
     */
    protected static Client client = ClientBuilder.newClient();

    /**
     * Gets a URI builder to be used to perform a REST call.
     *
     * @return The new URI builder.
     */
    public static UriBuilder getUriBuilder()
    {
        return UriBuilder.fromUri("http://192.168.0.15:8080/MoovyServer/");
    }

    /**
     *
     * @return
     */
    public static Client getClient()
    {
        return RestUtils.client;
    }

    /**
     *
     */
    public static void clearClient()
    {
        RestUtils.client.close();
        RestUtils.client = null;
    }
}
