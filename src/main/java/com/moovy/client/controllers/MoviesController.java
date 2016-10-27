package com.moovy.client.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
@Controller
public class MoviesController extends AbstractController
{
    /**
     * Displays a list of movies.
     *
     * @return
     */
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public ModelAndView list()
    {
        return this.render("movies/list");
    }

    /**
     * Displays the form to add a movie.
     *
     * @return
     */
    @RequestMapping(value = "/movies/add", method = RequestMethod.GET)
    public ModelAndView add()
    {
        // Build model
        ModelMap model = new ModelMap();
        model.addAttribute("_page_current", "movies_add");
        model.addAttribute("_body_title", "Ajouter un film");

        return this.render("movies/form", model);
    }

    /**
     * Displays the form to edit a movie.
     *
     * @param id The movie's id.
     * @return
     */
    @RequestMapping(value = "/movies/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id)
    {
        // Build model
        ModelMap model = new ModelMap();
        model.addAttribute("_page_current", "movies_edit");
        model.addAttribute("_body_title", "Éditer un film");

        return this.render("movies/form", model);
    }

    /**
     * Handles the submission of a form to add or edit a movie.
     *
     * @return
     */
    @RequestMapping(value = "/movies/submit", method = RequestMethod.POST)
    public ModelAndView submit()
    {
        return this.render("movies/form");
    }

    /**
     * Handles the deletion of a single movie.
     *
     * @param id The movie's id.
     * @return
     */
    @RequestMapping(value = "/movies/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id)
    {
        return this.redirect("/movies");
    }
}
