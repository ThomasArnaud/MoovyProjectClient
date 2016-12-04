package com.moovy.client.entities;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class MovieCategory {

    protected Movie movie;
    protected Category category;
    private int idMovie;
    private String codeCategory;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

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

        MovieCategory that = (MovieCategory) o;

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
