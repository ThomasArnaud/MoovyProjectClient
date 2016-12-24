package com.moovy.client.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class Movie
{
    private int id;
    private String title;
    private int duration;
    private Date releaseDate;
    private int budget;
    private int benefit;
    private List<Character> characters = new ArrayList<>(0);
    private Director director;
    private List<Category> categories = new ArrayList<>(0);

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public Date getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public int getBudget()
    {
        return budget;
    }

    public void setBudget(int budget)
    {
        this.budget = budget;
    }

    public int getBenefit()
    {
        return benefit;
    }

    public void setBenefit(int benefit)
    {
        this.benefit = benefit;
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

        Movie movie = (Movie) o;

        if (id != movie.id)
        {
            return false;
        }
        if (duration != movie.duration)
        {
            return false;
        }
        if (budget != movie.budget)
        {
            return false;
        }
        if (benefit != movie.benefit)
        {
            return false;
        }
        if (title != null ? !title.equals(movie.title) : movie.title != null)
        {
            return false;
        }
        if (releaseDate != null ? !releaseDate.equals(movie.releaseDate) : movie.releaseDate != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + duration;
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + budget;
        result = 31 * result + benefit;
        return result;
    }

    public List<Character> getCharacters()
    {
        return characters;
    }

    public void setCharacters(List<Character> characters)
    {
        this.characters = characters;
    }

    public void addCharacter(Character character)
    {
        this.characters.add(character);
    }

    public Director getDirector()
    {
        return director;
    }

    public void setDirector(Director director)
    {
        this.director = director;
    }

    public List<Category> getCategories()
    {
        return categories;
    }

    public void setCategories(List<Category> categories)
    {
        this.categories = categories;
    }
}
