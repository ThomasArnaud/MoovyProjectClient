package com.moovy.client.services;

import com.moovy.client.entities.Category;
import com.moovy.client.utils.RestUtils;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class CategoriesService extends AbstractService
{
    /**
     * Fetches a single category from the database thanks to its code.
     *
     * @param id The category's id.
     * @return The wanted category, or {@code null} if there are no matching categories.
     */
    public Category fetch(int id)
    {
        // Build URI
        UriBuilder uriBuilder = RestUtils.getUriBuilder();
        uriBuilder.path("/categories/" + id);

        return this.doGet(uriBuilder.build(), Category.class);
    }

    /**
     * Fetches every existing category from the database.
     *
     * @return The list of categories.
     */
    public List<Category> fetchAll()
    {
        // Build URI
        UriBuilder uriBuilder = RestUtils.getUriBuilder();
        uriBuilder.path("/categories");

        return this.doGet(uriBuilder.build(), new GenericType<List<Category>>(){});
    }

    /**
     * Saves a category into the database.
     *
     * @param category The category to save.
     */
    public void save(Category category)
    {
        // Build URI
        UriBuilder uriBuilder = RestUtils.getUriBuilder();

        if(category.getId() != 0)
        {
            uriBuilder.path("/categories/" + category.getId());
            this.doPut(uriBuilder.build(), category).close();
        }
        else
        {
            uriBuilder.path("/categories");
            this.doPost(uriBuilder.build(), category).close();
        }
    }

    /**
     * Deletes a category from the database.
     *
     * @param category The category to delete.
     */
    public void delete(Category category)
    {
        // Build URI
        UriBuilder uriBuilder = RestUtils.getUriBuilder();
        uriBuilder.path("/categories/" + category.getId());

        this.doDelete(uriBuilder.build()).close();
    }
}
