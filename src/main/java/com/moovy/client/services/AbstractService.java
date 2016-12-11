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
public abstract class AbstractService
{
    /**
     * The webservices' host.
     */
    protected static final String HOST = "http://localhost:8080/MoovyServer/";

    /**
     *
     */
    private static Client client;

    /**
     *
     */
    private static WebTarget target;

    /*
     * @see http://stackoverflow.com/questions/17366266/jax-rs-2-0-change-default-implementation
     */
    static
    {
        AbstractService.client = ClientBuilder.newClient();
        AbstractService.target = client.target(AbstractService.HOST);
    }

    /**
     * Performs a GET HTTP call.
     *
     * @param path
     */
    protected String doGet(String path)
    {
        return AbstractService.target
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
