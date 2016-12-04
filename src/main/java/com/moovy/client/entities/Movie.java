package com.moovy.client.entities;

import java.lang.*;
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
    protected List<Category> categories;
    private int benefit;

    public void setReleaseDate(java.sql.Date releaseDate) {
        this.releaseDate = releaseDate;
    }

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

    public List<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public int getBenefit() {
        return benefit;
    }

    public void setBenefit(int benefit) {
        this.benefit = benefit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (duration != movie.duration) return false;
        if (budget != movie.budget) return false;
        if (benefit != movie.benefit) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (releaseDate != null ? !releaseDate.equals(movie.releaseDate) : movie.releaseDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + duration;
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + budget;
        result = 31 * result + benefit;
        return result;
    }
}
