package com.moovy.client.services;

import com.moovy.client.utils.RestUtils;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.UriBuilder;
import java.util.Map;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class StatisticsService extends AbstractService
{
    /**
     * Fetches statistics to display on the dashboard.
     *
     * @return The wanted statistics.
     */
    public Map<String, Long> fetchAll()
    {
        // Build URI
        UriBuilder uriBuilder = RestUtils.getUriBuilder();
        uriBuilder.path("/statistics/dashboard");

        return this.doGet(uriBuilder.build(), new GenericType<Map<String, Long>>(){});
    }
}
