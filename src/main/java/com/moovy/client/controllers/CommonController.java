package com.moovy.client.controllers;

import com.moovy.client.services.StatisticsService;
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
public class CommonController extends AbstractController
{
    /**
     * {@inheritDoc}
     */
    public CommonController(HttpServletRequest request)
    {
        super(request);
    }

    /**
     * Displays the home page.
     *
     * @return The view to render.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home()
    {
        // Build model
        ModelMap model = new ModelMap();
        StatisticsService statisticsService = new StatisticsService();

        model.addAttribute("statistics", statisticsService.fetchAll());

        return this.render("common/home", model);
    }

    /**
     * Displays the website's terms.
     *
     * @return The view to render
     */
    @RequestMapping(value = "/terms", method = RequestMethod.GET)
    public ModelAndView terms()
    {
        return this.render("common/terms");
    }
}
