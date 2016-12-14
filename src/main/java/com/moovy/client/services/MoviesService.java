package com.moovy.client.services;

import com.moovy.client.entities.Movie;
import com.moovy.client.utils.RestUtils;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class MoviesService extends AbstractService
{
    /**
     * Fetches a single movie from the database thanks to its id.
     *
     * @param id The movie's id.
     * @return The wanted movie, or {@code null} if there are no matching movies.
     */
    public Movie fetch(int id)
    {
        // Build URI
        UriBuilder uriBuilder = RestUtils.getUriBuilder();
        uriBuilder.path("/movies/" + id);

        return this.doGet(uriBuilder.build(), Movie.class);
    }

    /**
     * Fetches every existing movie from the database.
     *
     * @return The list of movies.
     */
    public List<Movie> fetchAll()
    {
        // Build URI
        UriBuilder uriBuilder = RestUtils.getUriBuilder();
        uriBuilder.path("/movies");

        return this.doGet(uriBuilder.build(), new GenericType<List<Movie>>(){});
    }

    /**
     * Searches movies in the database according to a query.
     *
     * @param query The query to use.
     * @return A list of movies matching the query.
     */
    public List<Movie> search(String query)
    {
        // Build URI
        UriBuilder uriBuilder = RestUtils.getUriBuilder();
        uriBuilder.path("/movies");
        uriBuilder.queryParam("query", query);

        return this.doGet(uriBuilder.build(), new GenericType<List<Movie>>(){});
    }

    /**
     * Saves a movie into the database.
     *
     * @param movie The movie to save.
     */
    public void save(Movie movie)
    {
        // Build URI
        UriBuilder uriBuilder = RestUtils.getUriBuilder();

        if(movie.getId() != 0)
        {
            uriBuilder.path("/movies/" + movie.getId());
            this.doPut(uriBuilder.build(), movie).close();
        }
        else
        {
            uriBuilder.path("/movies");
            this.doPost(uriBuilder.build(), movie).close();
        }
    }

    /**
     * Deletes a movie from the database.
     *
     * @param movie The movie to delete.
     */
    public void delete(Movie movie)
    {
        // Build URI
        UriBuilder uriBuilder = RestUtils.getUriBuilder();
        uriBuilder.path("/movies/" + movie.getId());

        this.doDelete(uriBuilder.build()).close();
    }
}
