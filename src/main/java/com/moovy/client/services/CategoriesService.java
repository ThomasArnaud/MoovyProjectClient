package com.moovy.client.services;

import com.moovy.client.entities.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class CategoriesService extends AbstractService
{
    public static final Map<String, Category> fakeCategories = new HashMap<>();

    static
    {
        // Initialize vars
        Category fakeCategory = null;

        // Create fake categories
        fakeCategory = new Category();
        fakeCategory.setCode("AC");
        fakeCategory.setName("Action");
        CategoriesService.fakeCategories.put("AC", fakeCategory);

        fakeCategory = new Category();
        fakeCategory.setCode("CO");
        fakeCategory.setName("Comédie");
        CategoriesService.fakeCategories.put("CO", fakeCategory);

        fakeCategory = new Category();
        fakeCategory.setCode("PO");
        fakeCategory.setName("Policier");
        CategoriesService.fakeCategories.put("PO", fakeCategory);

        fakeCategory = new Category();
        fakeCategory.setCode("WE");
        fakeCategory.setName("Western");
        CategoriesService.fakeCategories.put("WE", fakeCategory);
    }

    /**
     * Fetches a single category from the database thanks to its code.
     *
     * @param code The category's id.
     * @return The wanted category, or {@code null} if there are no matching categories.
     */
    public Category fetch(String code)
    {
        return CategoriesService.fakeCategories.getOrDefault(code, null);
    }

    /**
     * Fetches every existing category from the database.
     *
     * @return The list of categories.
     */
    public List<Category> fetchAll()
    {
        return new ArrayList<>(CategoriesService.fakeCategories.values());
    }

    /**
     * Saves a category into the database.
     *
     * @param category The category to save.
     */
    public void save(Category category)
    {

    }

    /**
     * Deletes a category from the database.
     *
     * @param category The category to delete.
     */
    public void delete(Category category)
    {

    }
}
