package com.moovy.client.services;

import com.moovy.client.entities.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class UsersService extends AbstractService
{
    public final Map<Integer, User> fakeUsers = new HashMap<>();

    public UsersService()
    {
        // Initialize vars
        User fakeUser = null;
        Calendar calendar = Calendar.getInstance();

        // Create fake users
        fakeUser = new User();
        fakeUser.setId(1);
        fakeUser.setFirstName("Bruno");
        fakeUser.setLastName("Buiret");
        fakeUser.setEmail("bruno.buiret@etu.univ-lyon1.fr");
        calendar.set(2016, 8, 1, 14, 0, 0);
        fakeUser.setCreatedAt(new Date(calendar.getTimeInMillis()));
        this.fakeUsers.put(1, fakeUser);

        fakeUser = new User();
        fakeUser.setId(2);
        fakeUser.setFirstName("Thomas");
        fakeUser.setLastName("Arnaud");
        fakeUser.setEmail("thomas.arnaud@etu.univ-lyon1.fr");
        calendar.set(2016, 8, 1, 14, 5, 0);
        fakeUser.setCreatedAt(new Date(calendar.getTimeInMillis()));
        this.fakeUsers.put(2, fakeUser);

        fakeUser = new User();
        fakeUser.setId(3);
        fakeUser.setFirstName("Alexis");
        fakeUser.setLastName("Rabilloud");
        fakeUser.setEmail("alexis.rabilloud@etu.univ-lyon1.fr");
        calendar.set(2016, 8, 1, 14, 10, 0);
        fakeUser.setCreatedAt(new Date(calendar.getTimeInMillis()));
        this.fakeUsers.put(3, fakeUser);
    }

    /**
     * Fetches a single user from the database thanks to its id.
     *
     * @param id The user's id.
     * @return The wanted user, or {@code null} if there are no matching users.
     */
    public User fetch(int id)
    {
        return this.fakeUsers.getOrDefault(id, null);
    }

    /**
     * Fetches every existing user from the database.
     *
     * @return The list of users.
     */
    public List<User> fetchAll()
    {
        return new ArrayList<>(this.fakeUsers.values());
    }

    /**
     * Performs a call to log in an user, that is to say, fetches an user from the database according to their email.
     *
     * @return The wanted user, or {@code null} if there are no matching users.
     */
    public User login(String email, String password)
    {
        for(Map.Entry<Integer, User> entry : this.fakeUsers.entrySet())
        {
            if(entry.getValue().getEmail().equals(email) && entry.getValue().getFirstName().equals(password))
            {
                return entry.getValue();
            }
        }

        return null;
    }

    /**
     * Saves an user into the database.
     *
     * @param user The user to save.
     */
    public void save(User user)
    {

    }

    /**
     * Deletes an user from the database.
     *
     * @param user The user to delete.
     */
    public void delete(User user)
    {

    }
}
