package org.coursera.petsproject.rest.model;

import org.coursera.petsproject.model.Pet;

import java.util.ArrayList;

/**
 * Created by Victor Daniel Cortés Restrepo on 17/10/16.
 */

public class PetResponse {

    private ArrayList<PetGram> pets;

    public ArrayList<PetGram> getPets() {
        return pets;
    }

    public void setPets(ArrayList<PetGram> pets) {
        this.pets = pets;
    }
}
