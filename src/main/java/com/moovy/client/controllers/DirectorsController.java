package com.moovy.client.controllers;

import com.moovy.client.entities.Director;
import com.moovy.client.services.DirectorsService;
import com.moovy.client.validators.DirectorValidator;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
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
     * Initializes a binder with validators and editors.
     *
     * @param binder The binder to initialize.
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.setValidator(new DirectorValidator());
    }

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

        model.addAttribute("_flashMessages", this.getAndClearFlashList());
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

        model.addAttribute("_flashMessages", this.getAndClearFlashList());
        model.addAttribute("_page_current", "directors_add");
        model.addAttribute("_page_title", "Ajouter un réalisateur");
        model.addAttribute("_body_title", "Ajouter un réalisateur");
        model.addAttribute("director", new Director());

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
        // Initialize vars
        DirectorsService directorsService = new DirectorsService();
        Director director = directorsService.fetch(id);

        if(director != null)
        {
            // Build model
            ModelMap model = new ModelMap();

            model.addAttribute("_flashMessages", this.getAndClearFlashList());
            model.addAttribute("_page_current", "directors_edit");
            model.addAttribute("_page_title", "Éditer un réalisateur");
            model.addAttribute("_body_title", "Éditer un réalisateur");
            model.addAttribute("director", director);

            return this.render("directors/form", model);
        }
        else
        {
            // Register a flash message and redirect
            this.addFlash(
                "danger",
                String.format(
                    "Il n'existe aucun réalisateur ayant pour identifiant <strong>%d</strong>.",
                    id
                )
            );

            return this.redirect("/directors");
        }
    }

    /**
     * Handles the submission of a form to add or edit a director.
     *
     * @return
     */
    @RequestMapping(value = "/directors/submit", method = RequestMethod.POST)
    public ModelAndView submit(
        @ModelAttribute("director") @Validated Director director,
        BindingResult result,
        @RequestParam(value = "_is_new", required = false) boolean isNew
    )
    {
        if(!result.hasErrors())
        {
            // Save director
            DirectorsService directorsService = new DirectorsService();

            // Then, register a flash message and redirect
            this.addFlash(
                "success",
                String.format(
                    "Réalisateur <strong>%s %s</strong> sauvegardé.",
                    StringEscapeUtils.escapeHtml(director.getFirstName()),
                    StringEscapeUtils.escapeHtml(director.getLastName())
                )
            );

            return this.redirect("/directors");
        }
        else
        {
            // Build model
            ModelMap model = new ModelMap();

            model.addAttribute("_flashMessages", this.getAndClearFlashList());
            model.addAttribute("_page_current", isNew ? "directors_add" : "directors_edit");
            model.addAttribute("_page_title", isNew ? "Ajouter un réalisateur" : "Éditer un réalisateur");
            model.addAttribute("_body_title", isNew ? "Ajouter un réalisateur" : "Éditer un réalisateur");
            model.addAttribute("director", director);

            return this.render("directors/form", model);
        }
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
        // Initialize vars
        DirectorsService directorsService = new DirectorsService();
        Director director = directorsService.fetch(id);

        if(director != null)
        {
            // Delete director
            directorsService.delete(director);

            // Then, register a flash message
            this.addFlash(
                "success",
                String.format(
                    "Réalisateur <strong>%s %s</strong> supprimé.",
                    StringEscapeUtils.escapeHtml(director.getFirstName()),
                    StringEscapeUtils.escapeHtml(director.getLastName())
                )
            );
        }
        else
        {
            this.addFlash(
                "success",
                String.format(
                    "Il n'existe aucun réalisateur ayant pour identifiant <strong>%d</strong>.",
                    id
                )
            );
        }

        return this.redirect("/directors");
    }
}
