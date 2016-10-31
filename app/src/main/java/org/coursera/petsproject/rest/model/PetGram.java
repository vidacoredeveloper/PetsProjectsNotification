package org.coursera.petsproject.rest.model;

/**
 * Created by Victor Daniel Cortés Restrepo on 17/10/16.
 */

public class PetGram {

    private String idPet;
    private String namePet;
    private String URLPhotoPet;
    private int likesPet;

    public PetGram() {
    }

    public PetGram(String idPet, String namePet, String URLPhotoPet, int likesPet) {
        this.idPet = idPet;
        this.namePet = namePet;
        this.URLPhotoPet = URLPhotoPet;
        this.likesPet = likesPet;
    }

    public String getIdPet() {
        return idPet;
    }

    public void setIdPet(String idPet) {
        this.idPet = idPet;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public String getURLPhotoPet() {
        return URLPhotoPet;
    }

    public void setURLPhotoPet(String URLPhotoPet) {
        this.URLPhotoPet = URLPhotoPet;
    }

    public int getLikesPet() {
        return likesPet;
    }

    public void setLikesPet(int likesPet) {
        this.likesPet = likesPet;
    }
}
