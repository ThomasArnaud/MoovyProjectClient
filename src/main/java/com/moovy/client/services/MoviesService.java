package com.moovy.client.services;

import com.moovy.client.entities.Category;
import com.moovy.client.entities.Character;
import com.moovy.client.entities.CharacterPK;
import com.moovy.client.entities.Movie;

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
public class MoviesService extends AbstractService
{
    public static final Map<Integer, Movie> fakeMovies = new HashMap<>();

    static
    {
        // Initialize vars
        Movie fakeMovie = null;
        Character fakeCharacter = null;
        CharacterPK fakePrimaryKey = null;
        Category fakeCategory = null;
        Calendar calendar = Calendar.getInstance();
        DirectorsService directorsService = new DirectorsService();
        ActorsService actorsService = new ActorsService();
        List<Character> fakeCharactersList = null;
        List<Category> fakeCategoriesList = null;

        // Create fake movies
        fakeMovie = new Movie();
        fakeMovie.setId(1);
        fakeMovie.setTitle("Léon");
        fakeMovie.setDuration(110);
        calendar.set(1994, 3, 14);
        fakeMovie.setReleaseDate(new Date(calendar.getTimeInMillis()));
        fakeMovie.setBudget(17531000);
        fakeMovie.setBenefit(69250000);
        fakeMovie.setDirector(directorsService.fetch(3));
        fakeCharactersList = new ArrayList<>();
        fakeCharacter = new Character();
        fakePrimaryKey = new CharacterPK();
        fakePrimaryKey.setMovie(fakeMovie);
        fakePrimaryKey.setActor(actorsService.fetch(1));
        fakeCharacter.setId(fakePrimaryKey);
        fakeCharacter.setName("Léon");
        fakeCharactersList.add(fakeCharacter);
        fakeCharacter = new Character();
        fakePrimaryKey = new CharacterPK();
        fakePrimaryKey.setMovie(fakeMovie);
        fakePrimaryKey.setActor(actorsService.fetch(5));
        fakeCharacter.setId(fakePrimaryKey);
        fakeCharacter.setName("Mathilda");
        fakeCharactersList.add(fakeCharacter);
        fakeMovie.setCharacters(fakeCharactersList);
        fakeCategoriesList = new ArrayList<>();
        fakeCategory = new Category();
        fakeCategory.setCode("PO");
        fakeCategory.setName("Policier");
        fakeCategoriesList.add(fakeCategory);
        fakeMovie.setCategories(fakeCategoriesList);
        MoviesService.fakeMovies.put(1, fakeMovie);

        fakeMovie = new Movie();
        fakeMovie.setId(2);
        fakeMovie.setTitle("Cash");
        fakeMovie.setDuration(100);
        calendar.set(2008, 3, 23);
        fakeMovie.setReleaseDate(new Date(calendar.getTimeInMillis()));
        fakeMovie.setBudget(18340000);
        fakeMovie.setBenefit(60340000);
        fakeMovie.setDirector(directorsService.fetch(4));
        fakeCharactersList = new ArrayList<>();
        fakeCharacter = new Character();
        fakePrimaryKey = new CharacterPK();
        fakePrimaryKey.setMovie(fakeMovie);
        fakePrimaryKey.setActor(actorsService.fetch(1));
        fakeCharacter.setId(fakePrimaryKey);
        fakeCharacter.setName("Maxime Dubreuil");
        fakeCharactersList.add(fakeCharacter);
        fakeCharacter = new Character();
        fakePrimaryKey = new CharacterPK();
        fakePrimaryKey.setMovie(fakeMovie);
        fakePrimaryKey.setActor(actorsService.fetch(7));
        fakeCharacter.setId(fakePrimaryKey);
        fakeCharacter.setName("Cash");
        fakeCharactersList.add(fakeCharacter);
        fakeMovie.setCharacters(fakeCharactersList);
        fakeCategoriesList = new ArrayList<>();
        fakeCategory = new Category();
        fakeCategory.setCode("PO");
        fakeCategory.setName("Policier");
        fakeCategoriesList.add(fakeCategory);
        fakeMovie.setCategories(fakeCategoriesList);
        MoviesService.fakeMovies.put(2, fakeMovie);

        fakeMovie = new Movie();
        fakeMovie.setId(3);
        fakeMovie.setTitle("La grande vadrouille");
        fakeMovie.setDuration(132);
        calendar.set(1966, 11, 1);
        fakeMovie.setReleaseDate(new Date(calendar.getTimeInMillis()));
        fakeMovie.setBudget(7227000);
        fakeMovie.setBenefit(51258000);
        fakeMovie.setDirector(directorsService.fetch(2));
        fakeCharactersList = new ArrayList<>();
        fakeCharacter = new Character();
        fakePrimaryKey = new CharacterPK();
        fakePrimaryKey.setMovie(fakeMovie);
        fakePrimaryKey.setActor(actorsService.fetch(8));
        fakeCharacter.setId(fakePrimaryKey);
        fakeCharacter.setName("Augustin Bouvet");
        fakeCharactersList.add(fakeCharacter);
        fakeCharacter = new Character();
        fakePrimaryKey = new CharacterPK();
        fakePrimaryKey.setMovie(fakeMovie);
        fakePrimaryKey.setActor(actorsService.fetch(12));
        fakeCharacter.setId(fakePrimaryKey);
        fakeCharacter.setName("Stanislas Lefort");
        fakeCharactersList.add(fakeCharacter);
        fakeMovie.setCharacters(fakeCharactersList);
        fakeCategoriesList = new ArrayList<>();
        fakeCategory = new Category();
        fakeCategory.setCode("AC");
        fakeCategory.setName("Action");
        fakeCategoriesList.add(fakeCategory);
        fakeMovie.setCategories(fakeCategoriesList);
        MoviesService.fakeMovies.put(3, fakeMovie);

        fakeMovie = new Movie();
        fakeMovie.setId(4);
        fakeMovie.setTitle("Subway");
        fakeMovie.setDuration(104);
        calendar.set(1985, 3, 10);
        fakeMovie.setReleaseDate(new Date(calendar.getTimeInMillis()));
        fakeMovie.setBudget(10567000);
        fakeMovie.setBenefit(70500000);
        fakeMovie.setDirector(directorsService.fetch(3));
        fakeCharactersList = new ArrayList<>();
        fakeCharacter = new Character();
        fakePrimaryKey = new CharacterPK();
        fakePrimaryKey.setMovie(fakeMovie);
        fakePrimaryKey.setActor(actorsService.fetch(1));
        fakeCharacter.setId(fakePrimaryKey);
        fakeCharacter.setName("Le Batteur");
        fakeCharactersList.add(fakeCharacter);
        fakeCharacter = new Character();
        fakePrimaryKey = new CharacterPK();
        fakePrimaryKey.setMovie(fakeMovie);
        fakePrimaryKey.setActor(actorsService.fetch(13));
        fakeCharacter.setId(fakePrimaryKey);
        fakeCharacter.setName("Le Roller");
        fakeCharactersList.add(fakeCharacter);
        fakeCharacter = new Character();
        fakePrimaryKey = new CharacterPK();
        fakePrimaryKey.setMovie(fakeMovie);
        fakePrimaryKey.setActor(actorsService.fetch(15));
        fakeCharacter.setId(fakePrimaryKey);
        fakeCharacter.setName("Fred");
        fakeCharactersList.add(fakeCharacter);
        fakeMovie.setCharacters(fakeCharactersList);
        fakeCategoriesList = new ArrayList<>();
        fakeCategory = new Category();
        fakeCategory.setCode("PO");
        fakeCategory.setName("Policier");
        fakeCategoriesList.add(fakeCategory);
        fakeMovie.setCategories(fakeCategoriesList);
        MoviesService.fakeMovies.put(4, fakeMovie);

        fakeMovie = new Movie();
        fakeMovie.setId(5);
        fakeMovie.setTitle("The Avengers");
        fakeMovie.setDuration(143);
        calendar.set(2012, 3, 25);
        fakeMovie.setReleaseDate(new Date(calendar.getTimeInMillis()));
        fakeMovie.setBudget(220000000);
        fakeMovie.setBenefit(1518594000);
        fakeMovie.setDirector(directorsService.fetch(5));
        fakeCharactersList = new ArrayList<>();
        fakeCharacter = new Character();
        fakePrimaryKey = new CharacterPK();
        fakePrimaryKey.setMovie(fakeMovie);
        fakePrimaryKey.setActor(actorsService.fetch(16));
        fakeCharacter.setId(fakePrimaryKey);
        fakeCharacter.setName("Iron Man");
        fakeCharactersList.add(fakeCharacter);
        fakeCharacter = new Character();
        fakePrimaryKey = new CharacterPK();
        fakePrimaryKey.setMovie(fakeMovie);
        fakePrimaryKey.setActor(actorsService.fetch(17));
        fakeCharacter.setId(fakePrimaryKey);
        fakeCharacter.setName("Captain America");
        fakeCharactersList.add(fakeCharacter);
        fakeMovie.setCharacters(fakeCharactersList);
        fakeCategoriesList = new ArrayList<>();
        fakeCategory = new Category();
        fakeCategory.setCode("AC");
        fakeCategory.setName("Action");
        fakeCategoriesList.add(fakeCategory);
        fakeMovie.setCategories(fakeCategoriesList);
        MoviesService.fakeMovies.put(5, fakeMovie);
    }

    /**
     * Fetches a single movie from the database thanks to its id.
     *
     * @param id The movie's id.
     * @return The wanted movie, or {@code null} if there are no matching movies.
     */
    public Movie fetch(int id)
    {
        return MoviesService.fakeMovies.getOrDefault(id, null);
    }

    /**
     * Fetches every existing movie from the database.
     *
     * @return The list of movies.
     */
    public List<Movie> fetchAll()
    {
        return new ArrayList<>(MoviesService.fakeMovies.values());
    }

    /**
     * Searches movies in the database according to a query.
     *
     * @param query The query to use.
     * @return A list of movies matching the query.
     */
    public List<Movie> search(String query)
    {
        // Build fake data
        List<Movie> fakeMovies = new ArrayList<>();
        Pattern queryPattern = Pattern.compile(".*" + query + ".*", Pattern.CASE_INSENSITIVE);

        for(Map.Entry<Integer, Movie> entry : MoviesService.fakeMovies.entrySet())
        {
            if(queryPattern.matcher(entry.getValue().getTitle()).matches())
            {
                fakeMovies.add(entry.getValue());
            }
        }

        return fakeMovies;
    }

    /**
     * Saves a movie into the database.
     *
     * @param movie The movie to save.
     */
    public void save(Movie movie)
    {

    }

    /**
     * Deletes a movie from the database.
     *
     * @param movie The movie to delete.
     */
    public void delete(Movie movie)
    {

    }
}
