package com.moovy.client.controllers;

import com.moovy.client.entities.Actor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
@Controller
public class ActorsController extends AbstractController
{
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
        List<Actor> actorsList = new ArrayList<>();
        Actor fakeActor = null;
        Calendar calendar = Calendar.getInstance();

        fakeActor = new Actor();
        fakeActor.setId(1);
        fakeActor.setFirstName("Jeremy");
        fakeActor.setLastName("Renner");
        calendar.set(1971, 0, 7);
        fakeActor.setBirthDate(calendar.getTime());
        fakeActor.setDeathDate(null);
        actorsList.add(fakeActor);

        fakeActor = new Actor();
        fakeActor.setId(2);
        fakeActor.setFirstName("Louis");
        fakeActor.setLastName("De Funès");
        calendar.set(1914, 6, 31);
        fakeActor.setBirthDate(calendar.getTime());
        calendar.set(1983, 0, 27);
        fakeActor.setDeathDate(calendar.getTime());
        actorsList.add(fakeActor);

        fakeActor = new Actor();
        fakeActor.setId(3);
        fakeActor.setFirstName("Tye");
        fakeActor.setLastName("Sheridan");
        calendar.set(1996, 10, 11);
        fakeActor.setBirthDate(calendar.getTime());
        fakeActor.setDeathDate(null);
        actorsList.add(fakeActor);

        model.addAttribute("actorsList", actorsList);

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
        model.addAttribute("_page_current", "actors_add");
        model.addAttribute("_body_title", "Ajouter un acteur");

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
        // Build model
        ModelMap model = new ModelMap();
        model.addAttribute("_page_current", "actors_edit");
        model.addAttribute("_body_title", "Éditer un acteur");

        return this.render("actors/form", model);
    }

    /**
     * Handles the submission of a form to add or edit an actor.
     *
     * @return
     */
    @RequestMapping(value = "/actors/submit", method = RequestMethod.POST)
    public ModelAndView submit()
    {
        return this.render("actors/form");
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
        return this.redirect("/actors");
    }
}
