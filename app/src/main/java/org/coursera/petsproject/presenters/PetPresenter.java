package org.coursera.petsproject.presenters;

import android.content.Context;

import org.coursera.petsproject.activities.Interfaces.IPetLikeActivity;
import org.coursera.petsproject.database.Interactor;
import org.coursera.petsproject.model.Pet;
import org.coursera.petsproject.presenters.interfaces.IPetPresenter;

import java.util.ArrayList;

/**
 * Created by Victor Daniel Cortés Restrepo on 17/10/16.
 */

public class PetPresenter implements IPetPresenter{

    //Atributos del presentador
    private IPetLikeActivity iPetLikeActivity;
    private Context context;
    private Interactor interactor;
    private ArrayList<Pet> pets;

    public PetPresenter(IPetLikeActivity iPetLikeActivity, Context context, Interactor interactor) {
        this.iPetLikeActivity = iPetLikeActivity;
        this.context = context;
        this.interactor = interactor;
        pets = interactor.getAllPets();
        getPetsDataBase();
    }

    @Override
    public void getPetsDataBase() {
        iPetLikeActivity.initializePetRecyclerView();
        pets = iPetLikeActivity.generatePetList(pets);
        pets = iPetLikeActivity.organizePetList(pets);
        pets = iPetLikeActivity.lastFivePets(pets, interactor);
        iPetLikeActivity.initializePetAdapter(pets);
    }
}
