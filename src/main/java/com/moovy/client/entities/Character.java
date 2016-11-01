package com.moovy.client.entities;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class Character
{
    protected String name;

    protected Movie movie;

    protected Actor actor;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Movie getMovie()
    {
        return this.movie;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

    public Actor getActor()
    {
        return this.actor;
    }

    public void setActor(Actor actor)
    {
        this.actor = actor;
    }
}
