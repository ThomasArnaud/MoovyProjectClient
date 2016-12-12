package com.moovy.client.entities;

import java.io.Serializable;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class CharacterPK implements Serializable
{
    private Actor actor;
    private Movie movie;

    public CharacterPK()
    {
    }

    public CharacterPK(Actor actor, Movie movie)
    {
        this.actor = actor;
        this.movie = movie;
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

        CharacterPK that = (CharacterPK) o;

        if (actor != null ? !actor.equals(that.actor) : that.actor != null)
        {
            return false;
        }
        return movie != null ? movie.equals(that.movie) : that.movie == null;
    }

    @Override
    public int hashCode()
    {
        int result = actor != null ? actor.hashCode() : 0;
        result = 31 * result + (movie != null ? movie.hashCode() : 0);
        return result;
    }

    public Actor getActor()
    {
        return actor;
    }

    public void setActor(Actor actor)
    {
        this.actor = actor;
    }

    public Movie getMovie()
    {
        return movie;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }
}
