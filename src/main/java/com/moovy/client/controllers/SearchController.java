package com.moovy.client.controllers;

import com.moovy.client.services.ActorsService;
import com.moovy.client.services.DirectorsService;
import com.moovy.client.services.MoviesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
@Controller
public class SearchController extends AbstractController
{
    /**
     * {@inheritDoc}
     */
    public SearchController(HttpServletRequest request)
    {
        super(request);
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search()
    {
        // Initialize vars
        ModelMap model = new ModelMap();
        String query = this.request.getParameter("q");

        if(query != null && !query.isEmpty())
        {
            // Initialize services
            MoviesService moviesService = new MoviesService();
            ActorsService actorsService = new ActorsService();
            DirectorsService directorsService = new DirectorsService();

            model.addAttribute("_search", query);
            model.addAttribute("moviesList", moviesService.search(query));
            model.addAttribute("actorsList", actorsService.search(query));
            model.addAttribute("directorsList", directorsService.search(query));
        }
        else
        {

        }

        return this.render("search/results", model);
    }
}
