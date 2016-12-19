package com.moovy.client.services;

import com.moovy.client.entities.Character;
import com.moovy.client.utils.RestUtils;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class CharactersService extends AbstractService
{
    /**
     *
     * @param movieId
     * @return
     */
    public List<Character> fetchByMovieId(int movieId)
    {
        // Build URI
        UriBuilder uriBuilder = RestUtils.getUriBuilder();
        uriBuilder.path("/characters/movies/" + movieId);

        return this.doGet(uriBuilder.build(), new GenericType<List<Character>>(){});
    }

    /**
     *
     * @param movieId
     * @param characters
     * @return
     */
    public void save(int movieId, List<Character> characters)
    {
        // Build URI
        UriBuilder uriBuilder = RestUtils.getUriBuilder();
        uriBuilder.path("/characters/movies/" + movieId);

        this.doPut(uriBuilder.build(), characters).close();
    }
}
