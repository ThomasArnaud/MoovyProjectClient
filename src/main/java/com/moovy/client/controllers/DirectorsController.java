package com.moovy.client.controllers;

import com.moovy.client.services.DirectorsService;
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
public class DirectorsController extends AbstractController
{
    /**
     * Displays a list of directors.
     *
     * @return
     */
    @RequestMapping(value = "/directors", method = RequestMethod.GET)
    public ModelAndView list()
    {
        // Set up some fake data
        ModelMap model = new ModelMap();
        DirectorsService directorsService = new DirectorsService();

        model.addAttribute("directorsList", directorsService.fetchAll());

        return this.render("directors/list", model);
    }

    /**
     * Displays the form to add a director.
     *
     * @return
     */
    @RequestMapping(value = "/directors/add", method = RequestMethod.GET)
    public ModelAndView add()
    {
        // Build model
        ModelMap model = new ModelMap();
        model.addAttribute("_page_current", "directors_add");
        model.addAttribute("_body_title", "Ajouter un réalisateur");

        return this.render("directors/form", model);
    }

    /**
     * Displays the form to edit a director.
     *
     * @param id The director's id.
     * @return
     */
    @RequestMapping(value = "/directors/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id)
    {
        // Build model
        ModelMap model = new ModelMap();
        model.addAttribute("_page_current", "directors_edit");
        model.addAttribute("_body_title", "Éditer un réalisateur");

        return this.render("directors/form", model);
    }

    /**
     * Handles the submission of a form to add or edit a director.
     *
     * @return
     */
    @RequestMapping(value = "/directors/submit", method = RequestMethod.POST)
    public ModelAndView submit()
    {
        return this.render("directors/form");
    }

    /**
     * Handles the deletion of a single director.
     *
     * @param id The director's id.
     * @return
     */
    @RequestMapping(value = "/directors/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id)
    {
        return this.redirect("/directors");
    }
}
