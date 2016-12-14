package com.moovy.client.services;

import com.moovy.client.entities.Actor;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class ActorsService extends AbstractService
{
    /**
     * Fetches a single actor from the database thanks to its id.
     *
     * @param id The actor's id.
     * @return The wanted actor, or {@code null} if there are no matching actors.
     */
    public Actor fetch(int id)
    {
        // Build URI
        UriBuilder uriBuilder = UriBuilder.fromUri(AbstractService.HOST);
        uriBuilder.path("/actors/" + id);

        return this.doGet(uriBuilder.build(), Actor.class);
    }

    /**
     * Fetches every existing actor from the database.
     *
     * @return The list of actors.
     */
    public List<Actor> fetchAll()
    {
        // Build URI
        UriBuilder uriBuilder = UriBuilder.fromUri(AbstractService.HOST);
        uriBuilder.path("/actors");

        return this.doGet(uriBuilder.build(), new GenericType<List<Actor>>(){});
    }

    /**
     * Searches actors in the database according to a query.
     *
     * @param query The query to use.
     * @return A list of actors matching the query.
     */
    public List<Actor> search(String query)
    {
        // Build URI
        UriBuilder uriBuilder = UriBuilder.fromUri(AbstractService.HOST);
        uriBuilder.path("/actors");
        uriBuilder.queryParam("query", query);

        return this.doGet(uriBuilder.build(), new GenericType<List<Actor>>(){});
    }

    /**
     * Saves an actor into the database.
     *
     * @param actor The actor to save.
     */
    public void save(Actor actor)
    {
        // Build URI
        UriBuilder uriBuilder = UriBuilder.fromUri(AbstractService.HOST);

        if(actor.getId() != 0)
        {
            uriBuilder.path("/actors/" + actor.getId());
            this.doPut(uriBuilder.build(), actor);
        }
        else
        {
            uriBuilder.path("/actors");
            this.doPost(uriBuilder.build(), actor);
        }
    }

    /**
     * Deletes an actor from the database.
     *
     * @param actor The actor to delete.
     */
    public void delete(Actor actor)
    {
        // Build URI
        UriBuilder uriBuilder = UriBuilder.fromUri(AbstractService.HOST);
        uriBuilder.path("/actors/" + actor.getId());

        this.doDelete(uriBuilder.build());
    }
}
