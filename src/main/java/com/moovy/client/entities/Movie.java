package com.moovy.client.entities;

import java.util.Date;
import java.util.List;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class Movie
{
    protected int id;

    protected String title;

    protected int duration;

    protected Date releaseDate;

    protected int budget;

    protected int profit;

    protected Director director;

    protected List<Character> characters;

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getDuration()
    {
        return this.duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public Date getReleaseDate()
    {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public int getBudget()
    {
        return this.budget;
    }

    public void setBudget(int budget)
    {
        this.budget = budget;
    }

    public int getProfit()
    {
        return this.profit;
    }

    public void setProfit(int profit)
    {
        this.profit = profit;
    }

    public Director getDirector()
    {
        return this.director;
    }

    public void setDirector(Director director)
    {
        this.director = director;
    }

    public List<Character> getCharacters()
    {
        return this.characters;
    }

    public void setCharacters(List<Character> characters)
    {
        this.characters = characters;
    }
}
