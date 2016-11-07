package com.moovy.client.controllers;

import com.moovy.client.entities.Actor;
import com.moovy.client.services.ActorsService;
import com.moovy.client.validators.ActorValidator;
import org.apache.commons.lang.StringEscapeUtils;
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

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
@Controller
public class ActorsController extends AbstractController
{
    /**
     * Initializes a binder with validators and editors.
     *
     * @param binder The binder to initialize.
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.setValidator(new ActorValidator());
    }

    /**
     * Displays a list of actors.
     *
     * @return
     */
    @RequestMapping(value = "/actors", method = RequestMethod.GET)
    public ModelAndView list()
    {
        // Set up some fake data
        ModelMap model = new ModelMap();
        ActorsService actorsService = new ActorsService();

        model.addAttribute("_flashMessages", this.getAndClearFlashList());
        model.addAttribute("actorsList", actorsService.fetchAll());

        return this.render("actors/list", model);
    }

    /**
     * Displays the form to add an actor.
     *
     * @return
     */
    @RequestMapping(value = "/actors/add", method = RequestMethod.GET)
    public ModelAndView add()
    {
        // Build model
        ModelMap model = new ModelMap();

        model.addAttribute("_flashMessages", this.getAndClearFlashList());
        model.addAttribute("_page_current", "actors_add");
        model.addAttribute("_page_title", "Ajouter un acteur");
        model.addAttribute("_body_title", "Ajouter un acteur");
        model.addAttribute("actor", new Actor());

        return this.render("actors/form", model);
    }

    /**
     * Displays the form to edit an actor.
     *
     * @param id The actor's id.
     * @return
     */
    @RequestMapping(value = "/actors/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id)
    {
        // Initialize vars
        ActorsService actorsService = new ActorsService();
        Actor actor = actorsService.fetch(id);

        if(actor != null)
        {
            // Build model
            ModelMap model = new ModelMap();

            model.addAttribute("_flashMessages", this.getAndClearFlashList());
            model.addAttribute("_page_current", "actors_edit");
            model.addAttribute("_page_title", "Éditer un acteur");
            model.addAttribute("_body_title", "Éditer un acteur");
            model.addAttribute("actor", actor);

            return this.render("actors/form", model);
        }
        else
        {
            // Register a flash message and redirect
            this.addFlash(
                "danger",
                String.format(
                    "Il n'existe aucun acteur ayant pour identifiant <strong>%d</strong>.",
                        id
                )
            );

            return this.redirect("/actors");
        }
    }

    /**
     * Handles the submission of a form to add or edit an actor.
     *
     * @return
     */
    @RequestMapping(value = "/actors/submit", method = RequestMethod.POST)
    public ModelAndView submit(
        @ModelAttribute("actor") @Validated Actor actor,
        BindingResult result,
        @RequestParam(value = "_is_new", required = false) boolean isNew
    )
    {
        if(!result.hasErrors())
        {
            // Save director
            ActorsService actorsService = new ActorsService();

            // Then, register a flash message and redirect
            this.addFlash(
                "success",
                String.format(
                    "Acteur <strong>%s %s</strong> sauvegardé.",
                    StringEscapeUtils.escapeHtml(actor.getFirstName()),
                    StringEscapeUtils.escapeHtml(actor.getLastName())
                )
            );

            return this.redirect("/directors");
        }
        else
        {
            // Build model
            ModelMap model = new ModelMap();

            model.addAttribute("_flashMessages", this.getAndClearFlashList());
            model.addAttribute("_page_current", isNew ? "actors_add" : "actors_edit");
            model.addAttribute("_page_title", isNew ? "Ajouter un acteur" : "Éditer un acteur");
            model.addAttribute("_body_title", isNew ? "Ajouter un acteur" : "Éditer un acteur");
            model.addAttribute("actor", actor);

            return this.render("actors/form", model);
        }
    }

    /**
     * Handles the deletion of a single actor.
     *
     * @param id The actor's id.
     * @return
     */
    @RequestMapping(value = "/actors/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id)
    {
        // Initialize vars
        ActorsService actorsService = new ActorsService();
        Actor actor = actorsService.fetch(id);

        if(actor != null)
        {
            // Delete director
            actorsService.delete(actor);

            // Then, register a flash message
            this.addFlash(
                "success",
                String.format(
                    "Acteur <strong>%s %s</strong> supprimé.",
                    StringEscapeUtils.escapeHtml(actor.getFirstName()),
                    StringEscapeUtils.escapeHtml(actor.getLastName())
                )
            );
        }
        else
        {
            this.addFlash(
                "success",
                String.format(
                    "Il n'existe aucun acteur ayant pour identifiant <strong>%d</strong>.",
                    id
                )
            );
        }

        return this.redirect("/actors");
    }
}
