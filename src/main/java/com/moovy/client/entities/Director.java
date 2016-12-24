package com.moovy.client.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class Director
{
    private int id;
    private String lastName;
    private String firstName;
    private List<Movie> directedMovies = new ArrayList<>(0);

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    @JsonIgnore
    public String getFullName()
    {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Director director = (Director) o;

        if (id != director.id)
        {
            return false;
        }
        if (lastName != null ? !lastName.equals(director.lastName) : director.lastName != null)
        {
            return false;
        }
        if (firstName != null ? !firstName.equals(director.firstName) : director.firstName != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }

    public List<Movie> getDirectedMovies()
    {
        return directedMovies;
    }

    public void setDirectedMovies(List<Movie> directedMovies)
    {
        this.directedMovies = directedMovies;
    }
}
