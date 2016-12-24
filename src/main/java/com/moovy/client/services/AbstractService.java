package com.moovy.client.services;

import com.moovy.client.utils.RestUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        Response response = AbstractService.returnUnlessError(
            target
            .request()
            .accept(MediaType.APPLICATION_JSON_TYPE)
            .get()
        );
        T entity = response.readEntity(type);
        response.close();

        return entity;
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
        Response response = AbstractService.returnUnlessError(
            target
            .request()
            .accept(MediaType.APPLICATION_JSON_TYPE)
            .get()
        );
        T entity = response.readEntity(type);
        response.close();

        return entity;
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

        return AbstractService.returnUnlessError(response);
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

        return AbstractService.returnUnlessError(response);
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
        Response response = target
            .request()
            .accept(MediaType.APPLICATION_JSON)
            .delete()
        ;

        return AbstractService.returnUnlessError(response);
    }

    /**
     * Returns the response unless an error happened server-side.
     *
     * @param response The server's response.
     * @throws ServiceException If an error happened server-side.
     * @throws RuntimeException If a parsing error happened, or if the contents isn't JSON.
     * @see <a href="http://stleary.github.io/JSON-java/index.html">org.json</a>
     */
    private static Response returnUnlessError(Response response)
    {
        if(response.getStatus() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
        {
            if(response.getMediaType().equals(MediaType.APPLICATION_JSON_TYPE))
            {
                // Initialize vars
                JSONObject exceptionObject = new JSONObject(response.readEntity(String.class));
                String message = null;
                StackTraceElement[] stackTrace = new StackTraceElement[0];

                // Read JSON object
                if(exceptionObject.has("localizedMessage"))
                {
                    message = exceptionObject.getString("localizedMessage");
                }
                else if(exceptionObject.has("message"))
                {
                    message = exceptionObject.getString("message");
                }
                else
                {
                    throw new RuntimeException("L'erreur renvoyé par le service ne contient aucun message descriptif.");
                }

                if(exceptionObject.has("stackTrace"))
                {
                    JSONArray stackTraceObject = exceptionObject.getJSONArray("stackTrace");
                    stackTrace = new StackTraceElement[stackTraceObject.length()];

                    for(int i = 0, j = stackTraceObject.length(); i < j; i++)
                    {
                        JSONObject stackTraceElementObject = stackTraceObject.getJSONObject(i);

                        try
                        {
                            stackTrace[i] = new StackTraceElement(
                                stackTraceElementObject.getString("className"),
                                stackTraceElementObject.getString("methodName"),
                                stackTraceElementObject.getString("fileName"),
                                stackTraceElementObject.getInt("lineNumber")
                            );
                        }
                        catch(JSONException e)
                        {
                            throw new RuntimeException("L'analyse de la pile d'appels ne comporte pas toutes les informations nécessaires.", e);
                        }
                    }
                }

                throw new ServiceException(message, stackTrace);
            }
            else
            {
                throw new RuntimeException("Une erreur est survenue côté serveur.");
            }
        }

        return response;
    }
}
