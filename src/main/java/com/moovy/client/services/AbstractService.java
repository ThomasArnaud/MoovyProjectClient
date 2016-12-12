package com.moovy.client.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

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

    /*
     * @see http://stackoverflow.com/questions/17366266/jax-rs-2-0-change-default-implementation
     */
    static
    {
        AbstractService.client = ClientBuilder.newClient();
    }

    /**
     * Performs a GET HTTP request.
     *
     * @param uri The service's URI.
     * @param type The response's type.
     */
    protected <T> T doGet(URI uri, Class<T> type)
    {
        // Initialize vars
        WebTarget target = AbstractService.client.target(uri);

        System.out.println("GET " + uri.toString());

        // Perform request
        return target
            .request()
            .accept(MediaType.APPLICATION_JSON)
            .get(type)
        ;
    }

    /**
     * Performs a GET HTTP request.
     *
     * @param uri The service's URI.
     * @param type The response's type.
     */
    protected <T> T doGet(URI uri, GenericType<T> type)
    {
        // Initialize vars
        WebTarget target = AbstractService.client.target(uri);

        System.out.println("GET " + uri.toString());

        // Perform request
        return target
            .request()
            .accept(MediaType.APPLICATION_JSON)
            .get(type)
        ;
    }

    /**
     * Performs a POST HTTP request.
     *
     * @param uri The service's URI.
     * @param entity The entity to send with the request.
     */
    protected <T> Response doPost(URI uri, Object entity)
    {
        // Initialize vars
        WebTarget target = AbstractService.client.target(uri);

        System.out.println("POST " + uri.toString());

        // Perform request
        return target
            .request()
            .accept(MediaType.APPLICATION_JSON)
            .post(Entity.json(entity))
        ;
    }

    /**
     * Performs a PUT HTTP request.
     *
     * @param uri The service's URI.
     * @param entity The entity to send with the request.
     */
    protected <T> Response doPut(URI uri, Object entity)
    {
        // Initialize vars
        WebTarget target = AbstractService.client.target(uri);

        System.out.println("PUT " + uri.toString());

        // Perform request
        return target
            .request()
            .accept(MediaType.APPLICATION_JSON)
            .put(Entity.json(entity))
        ;
    }

    /**
     * Performs a DELETE HTTP request.
     *
     * @param uri
     */
    protected Response doDelete(URI uri)
    {
        // Initialize vars
        WebTarget target = AbstractService.client.target(uri);

        System.out.println("DELETE " + uri.toString());

        // Perform request
        return target
            .request()
            .accept(MediaType.APPLICATION_JSON)
            .delete()
        ;
    }
}
