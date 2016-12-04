package com.moovy.client.services;

import com.moovy.client.entities.Actor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class ActorsService extends AbstractService
{
    protected static final Map<Integer, Actor> fakeActors = new HashMap<>();

    static
    {
        // Initialize vars
        Actor fakeActor = null;
        Calendar calendar = Calendar.getInstance();

        // Create fake actors
        fakeActor = new Actor();
        fakeActor.setId(1);
        fakeActor.setFirstName("Jean");
        fakeActor.setLastName("Reno");
        calendar.set(1948, 6, 30);
        fakeActor.setBirthDate(new Date(calendar.getTimeInMillis()));
        fakeActor.setDeathDate(null);
        ActorsService.fakeActors.put(1, fakeActor);

        fakeActor = new Actor();
        fakeActor.setId(5);
        fakeActor.setFirstName("Nathalie");
        fakeActor.setLastName("Portman");
        calendar.set(1981, 5, 9);
        fakeActor.setBirthDate(new Date(calendar.getTimeInMillis()));
        fakeActor.setDeathDate(null);
        ActorsService.fakeActors.put(5, fakeActor);

        fakeActor = new Actor();
        fakeActor.setId(7);
        fakeActor.setFirstName("Jean");
        fakeActor.setLastName("Dujardin");
        calendar.set(1972, 5, 19);
        fakeActor.setBirthDate(new Date(calendar.getTimeInMillis()));
        fakeActor.setDeathDate(null);
        ActorsService.fakeActors.put(7, fakeActor);

        fakeActor = new Actor();
        fakeActor.setId(8);
        fakeActor.setFirstName("");
        fakeActor.setLastName("Bourvil");
        calendar.set(1917, 6, 27);
        fakeActor.setBirthDate(new Date(calendar.getTimeInMillis()));
        calendar.set(1970, 8, 23);
        fakeActor.setDeathDate(new Date(calendar.getTimeInMillis()));
        ActorsService.fakeActors.put(8, fakeActor);

        fakeActor = new Actor();
        fakeActor.setId(12);
        fakeActor.setFirstName("Louis");
        fakeActor.setLastName("De Funès");
        calendar.set(1914, 6, 31);
        fakeActor.setBirthDate(new Date(calendar.getTimeInMillis()));
        calendar.set(1983, 0, 27);
        fakeActor.setDeathDate(new Date(calendar.getTimeInMillis()));
        ActorsService.fakeActors.put(12, fakeActor);

        fakeActor = new Actor();
        fakeActor.setId(13);
        fakeActor.setFirstName("Jean");
        fakeActor.setLastName("Anglade");
        calendar.set(1955, 6, 29);
        fakeActor.setBirthDate(new Date(calendar.getTimeInMillis()));
        fakeActor.setDeathDate(null);
        ActorsService.fakeActors.put(13, fakeActor);

        fakeActor = new Actor();
        fakeActor.setId(15);
        fakeActor.setFirstName("Christophe");
        fakeActor.setLastName("Lambert");
        calendar.set(1957, 2, 29);
        fakeActor.setBirthDate(new Date(calendar.getTimeInMillis()));
        fakeActor.setDeathDate(null);
        ActorsService.fakeActors.put(15, fakeActor);

        fakeActor = new Actor();
        fakeActor.setId(16);
        fakeActor.setFirstName("Robert Jr.");
        fakeActor.setLastName("Downey");
        calendar.set(1965, 3, 4);
        fakeActor.setBirthDate(new Date(calendar.getTimeInMillis()));
        fakeActor.setDeathDate(null);
        ActorsService.fakeActors.put(16, fakeActor);

        fakeActor = new Actor();
        fakeActor.setId(17);
        fakeActor.setFirstName("Chris");
        fakeActor.setLastName("Evans");
        calendar.set(1981, 5, 13);
        fakeActor.setBirthDate(new Date(calendar.getTimeInMillis()));
        fakeActor.setDeathDate(null);
        ActorsService.fakeActors.put(17, fakeActor);
    }

    /**
     * Fetches a single actor from the database thanks to its id.
     *
     * @param id The actor's id.
     * @return The wanted actor, or {@code null} if there are no matching actors.
     */
    public Actor fetch(int id)
    {
        return ActorsService.fakeActors.getOrDefault(id, null);
    }

    /**
     * Fetches every existing actor from the database.
     *
     * @return The list of actors.
     */
    public List<Actor> fetchAll()
    {
        return new ArrayList<>(ActorsService.fakeActors.values());
    }

    /**
     * Searches actors in the database according to a query.
     *
     * @param query The query to use.
     * @return A list of actors matching the query.
     */
    public List<Actor> search(String query)
    {
        // Build fake data
        List<Actor> fakeActors = new ArrayList<>();
        Pattern queryPattern = Pattern.compile(".*" + query + ".*", Pattern.CASE_INSENSITIVE);

        for(Map.Entry<Integer, Actor> entry : ActorsService.fakeActors.entrySet())
        {
            if(
                queryPattern.matcher(entry.getValue().getFirstName()).matches()
                || queryPattern.matcher(entry.getValue().getLastName()).matches()
            )
            {
                fakeActors.add(entry.getValue());
            }
        }

        return fakeActors;
    }

    /**
     * Saves an actor into the database.
     *
     * @param actor The actor to save.
     */
    public void save(Actor actor)
    {

    }

    /**
     * Deletes an actor from the database.
     *
     * @param actor The actor to delete.
     */
    public void delete(Actor actor)
    {

    }
}
