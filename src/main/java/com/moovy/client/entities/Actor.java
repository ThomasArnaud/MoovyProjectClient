package com.moovy.client.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class Actor
{
    private int id;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private Date deathDate;
    private List<Character> playedCharacters = new ArrayList<>(0);

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

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public Date getDeathDate()
    {
        return deathDate;
    }

    public void setDeathDate(Date deathDate)
    {
        this.deathDate = deathDate;
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

        Actor actor = (Actor) o;

        if (id != actor.id)
        {
            return false;
        }
        if (lastName != null ? !lastName.equals(actor.lastName) : actor.lastName != null)
        {
            return false;
        }
        if (firstName != null ? !firstName.equals(actor.firstName) : actor.firstName != null)
        {
            return false;
        }
        if (birthDate != null ? !birthDate.equals(actor.birthDate) : actor.birthDate != null)
        {
            return false;
        }
        if (deathDate != null ? !deathDate.equals(actor.deathDate) : actor.deathDate != null)
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
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (deathDate != null ? deathDate.hashCode() : 0);
        return result;
    }

    public List<Character> getPlayedCharacters()
    {
        return playedCharacters;
    }

    public void setPlayedCharacters(List<Character> playedCharacters)
    {
        this.playedCharacters = playedCharacters;
    }
}
