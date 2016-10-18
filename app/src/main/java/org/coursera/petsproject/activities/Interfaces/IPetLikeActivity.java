package org.coursera.petsproject.activities.Interfaces;

import android.support.v7.widget.RecyclerView;

import org.coursera.petsproject.database.Interactor;
import org.coursera.petsproject.model.Pet;

import java.util.ArrayList;

/**
 * Created by Victor Daniel Cortés Restrepo on 17/10/16.
 */

public interface IPetLikeActivity {

    public void initializePetRecyclerView();

    public ArrayList<Pet> generatePetList(ArrayList<Pet> pets);

    public ArrayList<Pet> organizePetList(ArrayList<Pet> petsList);

    public ArrayList<Pet> lastFivePets (ArrayList<Pet> petsList, Interactor interactor);

    public void initializePetAdapter(ArrayList<Pet> petsList);
}
