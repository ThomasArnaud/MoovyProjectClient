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
public class SecurityController extends AbstractController
{
    /**
     * Displays the login form
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login()
    {
        return this.render("security/login");
    }

    /**
     * Handles the login process.
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView doLogin()
    {
        return this.render("security/login");
    }

    /**
     * Handles the logging out process.
     *
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView doLogout()
    {
        return this.redirect("/login");
    }

    /**
     * Displays the registration form.
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register()
    {
        return this.render("security/register");
    }

    /**
     * Handles the registration process.
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView doRegister()
    {
        return this.render("security/register");
    }
}
