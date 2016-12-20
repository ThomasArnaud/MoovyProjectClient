package com.moovy.client.services;

import com.moovy.client.utils.RestUtils;

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
     * Performs a GET HTTP request.
     *
     * @param uri The service's URI.
     * @param type The response's type.
     */
    protected <T> T doGet(URI uri, Class<T> type)
    {
        // Initialize vars
        WebTarget target = RestUtils.getClient().target(uri);

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
     * @todo Factorize duplicate code because only the parameter type changes, strategy design pattern?
     */
    protected <T> T doGet(URI uri, GenericType<T> type)
    {
        // Initialize vars
        WebTarget target = RestUtils.getClient().target(uri);

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
        WebTarget target = RestUtils.getClient().target(uri);

        System.out.println("POST " + uri.toString());

        // Perform request
        Response response = target
            .request()
            .accept(MediaType.APPLICATION_JSON)
            .post(Entity.json(entity))
        ;

        if(response.getStatus() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
        {
            throw new RuntimeException("Une erreur est survenue côté serveur.");
        }

        return response;
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
        WebTarget target = RestUtils.getClient().target(uri);

        System.out.println("PUT " + uri.toString());

        // Perform request
        Response response = target
            .request()
            .accept(MediaType.APPLICATION_JSON)
            .put(Entity.json(entity))
        ;

        if(response.getStatus() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
        {
            throw new RuntimeException("Une erreur est survenue côté serveur.");
        }

        return response;
    }

    /**
     * Performs a DELETE HTTP request.
     *
     * @param uri The service's URI.
     */
    protected Response doDelete(URI uri)
    {
        // Initialize vars
        WebTarget target = RestUtils.getClient().target(uri);

        System.out.println("DELETE " + uri.toString());

        // Perform request
        return target
            .request()
            .accept(MediaType.APPLICATION_JSON)
            .delete()
        ;
    }
}
