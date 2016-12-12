package com.moovy.client.controllers;

import com.moovy.client.annotations.RequiresLogin;
import com.moovy.client.editors.ActorEditor;
import com.moovy.client.editors.CategoryEditor;
import com.moovy.client.editors.DirectorEditor;
import com.moovy.client.entities.Actor;
import com.moovy.client.entities.Category;
import com.moovy.client.entities.Character;
import com.moovy.client.entities.CharacterPK;
import com.moovy.client.entities.Director;
import com.moovy.client.entities.Movie;
import com.moovy.client.services.ActorsService;
import com.moovy.client.services.CategoriesService;
import com.moovy.client.services.DirectorsService;
import com.moovy.client.services.MoviesService;
import com.moovy.client.utils.DateUtils;
import com.moovy.client.validators.CategoryValidator;
import com.moovy.client.validators.MovieValidator;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
@Controller
public class MoviesController extends AbstractController
{
    /**
     * {@inheritDoc}
     */
    public MoviesController(HttpServletRequest request)
    {
        super(request);
    }

    /**
     * Initializes a binder with validators and editors.
     *
     * @param binder The binder to initialize.
     */
    @InitBinder("movie")
    protected void initMovieBinder(WebDataBinder binder)
    {
        binder.setValidator(new MovieValidator());
        binder.registerCustomEditor(Director.class, new DirectorEditor());
        binder.registerCustomEditor(Actor.class, new ActorEditor());
        binder.registerCustomEditor(Category.class, new CategoryEditor());
        binder.registerCustomEditor(Date.class, new CustomDateEditor(DateUtils.FORMAT_SHORT, false));
        binder.registerCustomEditor(List.class, "categories", new CustomCollectionEditor(List.class));
    }

    /**
     * Initializes a binder with validators and editors.
     *
     * @param binder The binder to initialize.
     */
    @InitBinder("category")
    protected void initCategoryBinder(WebDataBinder binder)
    {
        binder.setValidator(new CategoryValidator());
    }

    /**
     * Displays a list of movies.
     *
     * @return The view to render.
     */
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    @RequiresLogin
    public ModelAndView moviesList()
    {
        // Set up some fake data
        ModelMap model = new ModelMap();
        MoviesService moviesService = new MoviesService();

        model.addAttribute("moviesList", moviesService.fetchAll());

        return this.render("movies/list", model);
    }

    /**
     * Displays the form to add a movie.
     *
     * @return The view to render.
     */
    @RequestMapping(value = "/movies/add", method = RequestMethod.GET)
    @RequiresLogin
    public ModelAndView moviesAdd()
    {
        // Build model
        ModelMap model = new ModelMap();
        DirectorsService directorsService = new DirectorsService();
        CategoriesService categoriesService = new CategoriesService();

        model.addAttribute("_page_current", "movies_add");
        model.addAttribute("_page_title", "Ajouter un film");
        model.addAttribute("_body_title", "Ajouter un film");
        model.addAttribute("movie", new Movie());
        model.addAttribute("directorsList", directorsService.fetchAll());
        model.addAttribute("categoriesList", categoriesService.fetchAll());

        return this.render("movies/form", model);
    }

    /**
     * Displays the form to edit a movie.
     *
     * @param id The movie's id.
     * @return The view to render or a redirection.
     */
    @RequestMapping(value = "/movies/edit/{id}", method = RequestMethod.GET)
    @RequiresLogin
    public ModelAndView moviesEdit(@PathVariable int id)
    {
        // Initialize vars
        MoviesService moviesService = new MoviesService();
        Movie movie = moviesService.fetch(id);

        if(movie != null)
        {
            // Build model
            ModelMap model = new ModelMap();
            DirectorsService directorsService = new DirectorsService();
            CategoriesService categoriesService = new CategoriesService();

            model.addAttribute("_page_current", "movies_edit");
            model.addAttribute("_page_title", "Éditer un film");
            model.addAttribute("_body_title", "Éditer un film");
            model.addAttribute("movie", movie);
            model.addAttribute("directorsList", directorsService.fetchAll());
            model.addAttribute("categoriesList", categoriesService.fetchAll());

            return this.render("movies/form", model);
        }
        else
        {
            // Register a flash message and redirect
            this.addFlash(
                "danger",
                String.format(
                    "Il n'existe aucun film ayant pour identifiant <strong>%d</strong>.",
                    id
                )
            );

            return this.redirect("/movies");
        }
    }

    /**
     * Handles the submission of a form to add or edit a movie.
     *
     * @return The view to render or a redirection.
     */
    @RequestMapping(value = "/movies/submit", method = RequestMethod.POST)
    @RequiresLogin
    public ModelAndView moviesSubmit(
        @ModelAttribute("movie") @Validated Movie movie,
        BindingResult result,
        @RequestParam(value = "_is_new", required = false) boolean isNew
    )
    {
        if(!result.hasErrors())
        {
            // Save movie
            MoviesService moviesService = new MoviesService();
            moviesService.save(movie);

            // Then, register a flash message and redirect
            this.addFlash(
                "success",
                String.format(
                    "Film <strong>%s</strong> sauvegardé.",
                    StringEscapeUtils.escapeHtml(movie.getTitle())
                )
            );

            return this.redirect("/movies");
        }
        else
        {
            // Build model
            ModelMap model = new ModelMap();
            DirectorsService directorsService = new DirectorsService();
            CategoriesService categoriesService = new CategoriesService();

            model.addAttribute("_page_current", isNew ? "movies_add" : "movies_edit");
            model.addAttribute("_page_title", isNew ? "Ajouter un film" : "Éditer un film");
            model.addAttribute("_body_title", isNew ? "Ajouter un film" : "Éditer un film");
            model.addAttribute("movie", movie);
            model.addAttribute("directorsList", directorsService.fetchAll());
            model.addAttribute("categoriesList", categoriesService.fetchAll());

            return this.render("movies/form", model);
        }
    }

    /**
     * Handles the deletion of a single movie.
     *
     * @param id The movie's id.
     * @return A redirection.
     */
    @RequestMapping(value = "/movies/delete/{id}", method = RequestMethod.GET)
    @RequiresLogin
    public ModelAndView moviesDelete(@PathVariable int id)
    {
        // Initialize vars
        MoviesService moviesService = new MoviesService();
        Movie movie = moviesService.fetch(id);

        if(movie != null)
        {
            // Delete movie
            moviesService.delete(movie);

            // Then, register a flash message
            this.addFlash(
                "success",
                String.format(
                    "Film <strong>%s</strong> supprimé.",
                    StringEscapeUtils.escapeHtml(movie.getTitle())
                )
            );
        }
        else
        {
            this.addFlash(
                "success",
                String.format(
                    "Il n'existe aucun film ayant pour identifiant <strong>%d</strong>.",
                    id
                )
            );
        }

        return this.redirect("/movies");
    }

    /**
     * Displays a list of categories.
     *
     * @return The view to render.
     */
    @RequestMapping(value = "/movies/categories", method = RequestMethod.GET)
    @RequiresLogin
    public ModelAndView categoriesList()
    {
        // Set up some fake data
        ModelMap model = new ModelMap();
        CategoriesService categoriesService= new CategoriesService();

        model.addAttribute("categoriesList", categoriesService.fetchAll());

        return this.render("movies/categories/list", model);
    }

    /**
     * Displays the form to add a category.
     *
     * @return The view to render.
     */
    @RequestMapping(value = "/movies/categories/add", method = RequestMethod.GET)
    @RequiresLogin
    public ModelAndView categoriesAdd()
    {
        // Build model
        ModelMap model = new ModelMap();

        model.addAttribute("category", new Category());

        return this.render("movies/categories/add", model);
    }

    /**
     * Displays the form to edit a category.
     *
     * @param code The category's code.
     * @return The view to render or a redirection.
     */
    @RequestMapping(value = "/movies/categories/edit/{code}", method = RequestMethod.GET)
    @RequiresLogin
    public ModelAndView categoriesEdit(@PathVariable String code)
    {
        // Initialize vars
        CategoriesService categoriesService = new CategoriesService();
        Category category = categoriesService.fetch(code);

        if(category != null)
        {
            // Build model
            ModelMap model = new ModelMap();

            model.addAttribute("category", category);

            return this.render("movies/categories/edit", model);
        }
        else
        {
            // Register a flash message and redirect
            this.addFlash(
                "danger",
                String.format(
                    "Il n'existe aucune catégorie ayant pour code <strong>%s</strong>.",
                    code
                )
            );

            return this.redirect("/movies/categories");
        }
    }

    /**
     * Handles the submission of a form to add or edit a category.
     *
     * @return The view to render or a redirection.
     */
    @RequestMapping(value = "/movies/categories/submit", method = RequestMethod.POST)
    @RequiresLogin
    public ModelAndView categoriesSubmit(
        @ModelAttribute("category") @Validated Category category,
        BindingResult result,
        @RequestParam(value = "_is_new", required = false) boolean isNew
    )
    {
        if(!result.hasErrors())
        {
            // Save category
            CategoriesService categoriesService = new CategoriesService();
            categoriesService.save(category);

            // Then, register a flash message and redirect
            this.addFlash(
                "success",
                String.format(
                    "Catégorie <strong>%s</strong> sauvegardée.",
                    StringEscapeUtils.escapeHtml(category.getName())
                )
            );

            return this.redirect("/movies/categories");
        }
        else
        {
            // Build model
            ModelMap model = new ModelMap();

            model.addAttribute("category", category);

            return this.render("movies/categories/" + (isNew ? "add" : "edit"), model);
        }
    }

    /**
     * Handles the deletion of a single category.
     *
     * @param code The category's code.
     * @return A redirection.
     */
    @RequestMapping(value = "/movies/categories/delete/{code}", method = RequestMethod.GET)
    @RequiresLogin
    public ModelAndView categoriesDelete(@PathVariable String code)
    {
        // Initialize vars
        CategoriesService categoriesService = new CategoriesService();
        Category category = categoriesService.fetch(code);

        if(category != null)
        {
            // Delete category
            categoriesService.delete(category);

            // Then, register a flash message
            this.addFlash(
                "success",
                String.format(
                    "Catégorie <strong>%s</strong> supprimée.",
                    StringEscapeUtils.escapeHtml(category.getName())
                )
            );
        }
        else
        {
            this.addFlash(
                "success",
                String.format(
                    "Il n'existe aucune catégorie ayant pour code <strong>%s</strong>.",
                    code
                )
            );
        }

        return this.redirect("/movies/categories");
    }

    /**
     * Displays the form to edit a movie's characters.
     *
     * @param movieId The movie's id.
     * @return The view to render or a redirection.
     * @see <a href="http://viralpatel.net/blogs/spring-mvc-multi-row-submit-java-list/">http://viralpatel.net/blogs/spring-mvc-multi-row-submit-java-list/</a>
     */
    @RequestMapping(value = "/movies/{movieId}/characters", method = RequestMethod.GET)
    @RequiresLogin
    public ModelAndView charactersEdit(@PathVariable int movieId)
    {
        // Initialize vars
        MoviesService moviesService = new MoviesService();
        Movie movie = moviesService.fetch(movieId);

        if(movie != null)
        {
            // Build model
            ModelMap model = new ModelMap();
            ActorsService actorsService = new ActorsService();

            model.addAttribute("movie", movie);
            model.addAttribute("actorsList", actorsService.fetchAll());

            return this.render("movies/characters", model);
        }
        else
        {
            // Register a flash message and redirect
            this.addFlash(
                "danger",
                String.format(
                    "Il n'existe aucun film ayant pour identifiant <strong>%d</strong>.",
                    movieId
                )
            );

            return this.redirect("/movies");
        }
    }

    /**
     * Handles the submission of a form to add or edit a movie's characters.
     *
     * @return The view to render or a redirection.
     */
    @RequestMapping(value = "/movies/{movieId}/characters/submit", method = RequestMethod.POST)
    @RequiresLogin
    public ModelAndView charactersSubmit(
        @ModelAttribute("movie") @Validated Movie movie,
        BindingResult result,
        @RequestParam(value = "new_actors[]", required = false) List<Integer> newActors,
        @RequestParam(value = "new_characters[]", required = false) List<String> newCharacters,
        @PathVariable("movieId") int movieId
    )
    {
        // Perform additional validation for the new characters
        // Is there new characters to add?
        if(newActors != null && newCharacters != null)
        {
            // Is there as many actors as names?
            // Empty text inputs aren't submitted so a "<" operator is needed
            if(newActors.size() < newCharacters.size())
            {
                result.reject(null, "Vous n'avez pas renseigné autant d'acteurs que de noms de personnage.");
            }
            else
            {
                // Trim lists by removing empty characters' name
                int i = 0, newCharactersNumber = newCharacters.size();

                while(i < newCharactersNumber)
                {
                    if(newCharacters.get(i).trim().isEmpty())
                    {
                        newActors.remove(i);
                        newCharacters.remove(i);
                        newCharactersNumber--;
                    }
                    else
                    {
                        i++;
                    }
                }

                // Build new characters if needed
                if(newCharactersNumber > 0)
                {
                    ActorsService actorsService = new ActorsService();

                    for(i = 0; i < newCharactersNumber; i++)
                    {
                        Character newCharacter = new Character();
                        CharacterPK newPrimaryKey = new CharacterPK();

                        newPrimaryKey.setMovie(movie);
                        newPrimaryKey.setActor(actorsService.fetch(newActors.get(i)));
                        newCharacter.setId(newPrimaryKey);
                        newCharacter.setName(newCharacters.get(i));

                        movie.addCharacter(newCharacter);
                    }
                }

                // Do actors appear several times?
                Map<Actor, Integer> actorsCount = new HashMap<>();

                for(Character character : movie.getCharacters())
                {
                    actorsCount.put(character.getId().getActor(), actorsCount.getOrDefault(character.getId().getActor(), 0) + 1);
                }

                StringBuilder duplicatedActorsBuilder = new StringBuilder();

                for(Map.Entry<Actor, Integer> entry : actorsCount.entrySet())
                {
                    if(entry.getValue() > 1)
                    {
                        duplicatedActorsBuilder
                            .append(entry.getKey().getFullName())
                            .append(", ")
                        ;
                    }
                }

                if(duplicatedActorsBuilder.length() > 0)
                {
                    duplicatedActorsBuilder.delete(duplicatedActorsBuilder.length() - 2, duplicatedActorsBuilder.length());
                    result.reject(null, "Au moins un acteur a été défini plusieurs fois : " + duplicatedActorsBuilder.toString());
                }
            }
        }

        if(!result.hasErrors())
        {
            // Save movie
            MoviesService moviesService = new MoviesService();
            moviesService.save(movie);

            // Then, register a flash message and redirect
            this.addFlash(
                "success",
                String.format(
                    "Personnages du film <strong>%s</strong> sauvegardé.",
                    StringEscapeUtils.escapeHtml(movie.getTitle())
                )
            );

            return this.redirect("/movies");
        }
        else
        {
            // Build model
            ModelMap model = new ModelMap();
            ActorsService actorsService = new ActorsService();

            model.addAttribute("movie", movie);
            model.addAttribute("actorsList", actorsService.fetchAll());

            return this.render("movies/characters", model);
        }
    }
}
