package com.moovy.client.services;

import com.moovy.client.entities.Director;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class DirectorsService extends AbstractService
{
    /**
     * Fetches a single director from the database thanks to its id.
     *
     * @param id The director's id.
     * @return The wanted director, or {@code null} if there are no matching directors.
     */
    public Director fetch(int id)
    {
        // Build URI
        UriBuilder uriBuilder = UriBuilder.fromUri(AbstractService.HOST);
        uriBuilder.path("/directors/" + id);

        return this.doGet(uriBuilder.build(), Director.class);
    }

    /**
     * Fetches every existing director from the database.
     *
     * @return The list of directors.
     */
    public List<Director> fetchAll()
    {
        // Build URI
        UriBuilder uriBuilder = UriBuilder.fromUri(AbstractService.HOST);
        uriBuilder.path("/directors");

        return this.doGet(uriBuilder.build(), new GenericType<List<Director>>(){});
    }

    /**
     * Searches directors in the database according to a query.
     *
     * @param query The query to use.
     * @return A list of directors matching the query.
     */
    public List<Director> search(String query)
    {
        // Build URI
        UriBuilder uriBuilder = UriBuilder.fromUri(AbstractService.HOST);
        uriBuilder.path("/directors");
        uriBuilder.queryParam("query", query);

        return this.doGet(uriBuilder.build(), new GenericType<List<Director>>(){});
    }

    /**
     * Saves a director into the database.
     *
     * @param director The director to save.
     */
    public void save(Director director)
    {
        // Build URI
        UriBuilder uriBuilder = UriBuilder.fromUri(AbstractService.HOST);

        if(director.getId() != 0)
        {
            uriBuilder.path("/directors/" + director.getId());
            this.doPut(uriBuilder.build(), director);
        }
        else
        {
            uriBuilder.path("/directors");
            this.doPost(uriBuilder.build(), director);
        }
    }

    /**
     * Deletes a director from the database.
     *
     * @param director The director to delete.
     */
    public void delete(Director director)
    {
        // Build URI
        UriBuilder uriBuilder = UriBuilder.fromUri(AbstractService.HOST);
        uriBuilder.path("/directors/" + director.getId());

        this.doDelete(uriBuilder.build());
    }
}
