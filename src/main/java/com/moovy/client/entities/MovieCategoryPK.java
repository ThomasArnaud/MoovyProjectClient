package com.moovy.client.entities;

import java.io.Serializable;

/**
 * Created by thomas on 07/11/2016.
 */
public class MovieCategoryPK implements Serializable {
    private int idMovie;
    private String codeCategory;

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getCodeCategory() {
        return codeCategory;
    }

    public void setCodeCategory(String codeCategory) {
        this.codeCategory = codeCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieCategoryPK that = (MovieCategoryPK) o;

        if (idMovie != that.idMovie) return false;
        if (codeCategory != null ? !codeCategory.equals(that.codeCategory) : that.codeCategory != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMovie;
        result = 31 * result + (codeCategory != null ? codeCategory.hashCode() : 0);
        return result;
    }
}
