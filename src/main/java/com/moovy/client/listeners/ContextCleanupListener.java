package com.moovy.client.listeners;

import com.moovy.client.utils.RestUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class ContextCleanupListener implements ServletContextListener
{
    /**
     * Called when the context is initialized.
     *
     * @param sce The event.
     */
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        // Do nothing
    }

    /**
     * Called when the context is destroyed.
     *
     * @param sce The event.
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
        RestUtils.getClient().close();
        RestUtils.client.set(null);
        RestUtils.client.remove();
        RestUtils.client = null;
    }
}
