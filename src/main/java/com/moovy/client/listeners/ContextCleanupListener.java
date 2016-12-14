package com.moovy.client.listeners;

import com.moovy.client.services.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class ContextCleanupListener implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        // Do nothing
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
        UsersService.fakeUsers.clear();
    }
}
