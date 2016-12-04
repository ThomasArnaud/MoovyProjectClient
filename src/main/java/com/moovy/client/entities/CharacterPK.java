package com.moovy.client.entities;

import java.io.Serializable;

/**
 * Created by thomas on 07/11/2016.
 */
public class CharacterPK implements Serializable {
    private int idMovie;
    private int idActor;

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterPK that = (CharacterPK) o;

        if (idMovie != that.idMovie) return false;
        if (idActor != that.idActor) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMovie;
        result = 31 * result + idActor;
        return result;
    }
}
