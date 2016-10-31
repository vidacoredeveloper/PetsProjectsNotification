package org.coursera.petsproject.fragments.Interfaces;

import org.coursera.petsproject.model.Pet;
import org.coursera.petsproject.rest.model.PetGram;

import java.util.ArrayList;

/**
 * Created by Victor Daniel Cortés Restrepo on 16/10/16.
 */

public interface IProfilePetFragment {

    public void generatePetList(ArrayList<PetGram> pets);

    public void initializePetAdapter(ArrayList<PetGram> pets);

    public void getPetRecentMedia();
}
