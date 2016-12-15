package com.moovy.client.services;

import com.moovy.client.entities.User;
import com.moovy.client.utils.RestUtils;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
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
    /*
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
    */

    /**
     * Fetches a single user from the database thanks to its id.
     *
     * @param id The user's id.
     * @return The wanted user, or {@code null} if there are no matching users.
     */
    public User fetch(int id)
    {
        throw new UnsupportedOperationException("This method hasn't been implemented yet.");
    }

    /**
     * Fetches every existing user from the database.
     *
     * @return The list of users.
     */
    public List<User> fetchAll()
    {
        throw new UnsupportedOperationException("This method hasn't been implemented yet.");
    }

    /**
     * Performs a call to log in an user, that is to say, fetches an user from the database according to their email.
     *
     * @return The wanted user, or {@code null} if there are no matching users.
     */
    public User login(String email, String password)
    {
        // Build URI
        UriBuilder uriBuilder = RestUtils.getUriBuilder();
        uriBuilder.path("/users/login");

        // Build login data
        Map<String, String> loginData = new HashMap<>();
        loginData.put("email", email);
        loginData.put("password", password);

        // Try logging in
        Response response = this.doPost(uriBuilder.build(), loginData);
        User user = null;

        System.out.println(response);

        if(response.getStatus() == Response.Status.OK.getStatusCode())
        {
            // User has successfully logged in
            user = response.readEntity(User.class);
        }
        else if(response.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode())
        {
            // Bad credentials
        }
        else if(response.getStatus() == Response.Status.BAD_REQUEST.getStatusCode())
        {
            // Missing login data
        }
        else
        {
            // An error happened
        }

        response.close();

        return user;
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
        throw new UnsupportedOperationException("This method hasn't been implemented yet.");
    }
}
