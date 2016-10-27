package com.moovy.client.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
@Controller
public class StaticController extends AbstractController
{
    /**
     * Displays the home page.
     *
     * @return The view to render.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home()
    {
        return this.render("static/home");
    }

    /**
     * Displays the website's terms.
     *
     * @return
     */
    @RequestMapping(value = "/terms", method = RequestMethod.GET)
    public ModelAndView terms()
    {
        return this.render("static/terms");
    }
}
