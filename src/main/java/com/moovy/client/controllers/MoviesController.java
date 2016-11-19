package com.moovy.client.controllers;

import com.moovy.client.editors.DirectorEditor;
import com.moovy.client.entities.Director;
import com.moovy.client.entities.Movie;
import com.moovy.client.services.DirectorsService;
import com.moovy.client.services.MoviesService;
import com.moovy.client.utils.DateUtils;
import com.moovy.client.validators.MovieValidator;
import org.apache.commons.lang.StringEscapeUtils;
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
import java.util.Date;

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
    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.setValidator(new MovieValidator());
        binder.registerCustomEditor(Director.class, new DirectorEditor());
        binder.registerCustomEditor(Date.class, new CustomDateEditor(DateUtils.FORMAT_SHORT, false));
    }

    /**
     * Displays a list of movies.
     *
     * @return The view to render.
     */
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public ModelAndView list()
    {
        // Set up some fake data
        ModelMap model = new ModelMap();
        MoviesService moviesService = new MoviesService();

        model.addAttribute("_flashMessages", this.getAndClearFlashList());
        model.addAttribute("moviesList", moviesService.fetchAll());

        return this.render("movies/list", model);
    }

    /**
     * Displays the form to add a movie.
     *
     * @return The view to render.
     */
    @RequestMapping(value = "/movies/add", method = RequestMethod.GET)
    public ModelAndView add()
    {
        // Build model
        ModelMap model = new ModelMap();
        DirectorsService directorsService = new DirectorsService();

        model.addAttribute("_flashMessages", this.getAndClearFlashList());
        model.addAttribute("_page_current", "movies_add");
        model.addAttribute("_page_title", "Ajouter un film");
        model.addAttribute("_body_title", "Ajouter un film");
        model.addAttribute("movie", new Movie());
        model.addAttribute("directorsList", directorsService.fetchAll());

        return this.render("movies/form", model);
    }

    /**
     * Displays the form to edit a movie.
     *
     * @param id The movie's id.
     * @return The view to render or a redirection.
     */
    @RequestMapping(value = "/movies/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id)
    {
        // Initialize vars
        MoviesService moviesService = new MoviesService();
        Movie movie = moviesService.fetch(id);

        if(movie != null)
        {
            // Build model
            ModelMap model = new ModelMap();
            DirectorsService directorsService = new DirectorsService();

            model.addAttribute("_flashMessages", this.getAndClearFlashList());
            model.addAttribute("_page_current", "movies_edit");
            model.addAttribute("_page_title", "Éditer un film");
            model.addAttribute("_body_title", "Éditer un film");
            model.addAttribute("movie", movie);
            model.addAttribute("directorsList", directorsService.fetchAll());

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
    public ModelAndView submit(
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

            model.addAttribute("_flashMessages", this.getAndClearFlashList());
            model.addAttribute("_page_current", isNew ? "movies_add" : "movies_edit");
            model.addAttribute("_page_title", isNew ? "Ajouter un film" : "Éditer un film");
            model.addAttribute("_body_title", isNew ? "Ajouter un film" : "Éditer un film");
            model.addAttribute("movie", movie);
            model.addAttribute("directorsList", directorsService.fetchAll());

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
    public ModelAndView delete(@PathVariable int id)
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
}
