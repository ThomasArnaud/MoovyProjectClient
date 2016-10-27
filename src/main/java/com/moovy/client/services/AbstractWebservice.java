package com.moovy.client.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public abstract class AbstractWebservice
{
    /**
     * The webservices' host.
     */
    protected static final String HOST = "http://localhost:8080/";

    /**
     *
     */
    protected static Client client;

    /**
     *
     */
    protected static WebTarget target;

    static
    {
        AbstractWebservice.client = ClientBuilder.newClient();
        AbstractWebservice.target = client.target(AbstractWebservice.HOST);
    }

    /**
     * Performs a GET HTTP call.
     *
     * @param path
     */
    protected String doGet(String path)
    {
        return AbstractWebservice.target
            .path(path)
            .request()
            .accept(MediaType.APPLICATION_JSON)
            .get(String.class)
        ;
    }

    /**
     * Performs a POST HTTP call.
     *
     * @param path
     */
    protected void doPost(String path)
    {
    }

    /**
     * Performs a PUT HTTP call.
     *
     * @param path
     */
    protected void doPut(String path)
    {
    }

    /**
     * Performs a DELETE HTTP call.
     *
     * @param path
     */
    protected void doDelete(String path)
    {
    }
}
