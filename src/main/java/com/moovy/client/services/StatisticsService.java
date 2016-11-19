package com.moovy.client.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
    public Map<String, Integer> fetchAll()
    {
        Map<String, Integer> fakeStatistics = new HashMap<>();
        Random randomizer = new Random();

        fakeStatistics.put("usersNumber", 1 + randomizer.nextInt(100));
        fakeStatistics.put("moviesNumber", 1 + randomizer.nextInt(100));
        fakeStatistics.put("actorsNumber", 1 + randomizer.nextInt(100));
        fakeStatistics.put("directorsNumber", 1 + randomizer.nextInt(100));

        return fakeStatistics;
    }
}
