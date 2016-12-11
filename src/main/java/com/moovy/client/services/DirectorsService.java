package com.moovy.client.services;

import com.moovy.client.entities.Director;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class DirectorsService extends AbstractService
{
    public static final Map<Integer, Director> fakeDirectors = new HashMap<>();

    static
    {
        // Initialize vars
        Director fakeDirector = null;

        // Create fake directors
        fakeDirector = new Director();
        fakeDirector.setId(1);
        fakeDirector.setFirstName("Gérard");
        fakeDirector.setLastName("Oury");
        DirectorsService.fakeDirectors.put(1, fakeDirector);

        fakeDirector = new Director();
        fakeDirector.setId(2);
        fakeDirector.setFirstName("Claude");
        fakeDirector.setLastName("Chabrol");
        DirectorsService.fakeDirectors.put(2, fakeDirector);

        fakeDirector = new Director();
        fakeDirector.setId(3);
        fakeDirector.setFirstName("Luc");
        fakeDirector.setLastName("Besson");
        DirectorsService.fakeDirectors.put(3, fakeDirector);

        fakeDirector = new Director();
        fakeDirector.setId(4);
        fakeDirector.setFirstName("Eric");
        fakeDirector.setLastName("Besnard");
        DirectorsService.fakeDirectors.put(4, fakeDirector);

        fakeDirector = new Director();
        fakeDirector.setId(5);
        fakeDirector.setFirstName("Joss");
        fakeDirector.setLastName("Whedon");
        DirectorsService.fakeDirectors.put(5, fakeDirector);
    }

    /**
     * Fetches a single director from the database thanks to its id.
     *
     * @param id The director's id.
     * @return The wanted director, or {@code null} if there are no matching directors.
     */
    public Director fetch(int id)
    {
        return DirectorsService.fakeDirectors.getOrDefault(id, null);
    }

    /**
     * Fetches every existing director from the database.
     *
     * @return The list of directors.
     */
    public List<Director> fetchAll()
    {
        return new ArrayList<>(DirectorsService.fakeDirectors.values());
    }

    /**
     * Searches directors in the database according to a query.
     *
     * @param query The query to use.
     * @return A list of directors matching the query.
     */
    public List<Director> search(String query)
    {
        // Build fake data
        List<Director> fakeDirectors = new ArrayList<>();
        Pattern queryPattern = Pattern.compile(".*" + query + ".*", Pattern.CASE_INSENSITIVE);

        for(Map.Entry<Integer, Director> entry : DirectorsService.fakeDirectors.entrySet())
        {
            if(
                queryPattern.matcher(entry.getValue().getFirstName()).matches()
                || queryPattern.matcher(entry.getValue().getLastName()).matches()
            )
            {
                fakeDirectors.add(entry.getValue());
            }
        }

        return fakeDirectors;
    }

    /**
     * Saves a director into the database.
     *
     * @param director The director to save.
     */
    public void save(Director director)
    {

    }

    /**
     * Deletes a director from the database.
     *
     * @param director The director to delete.
     */
    public void delete(Director director)
    {

    }
}
