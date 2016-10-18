package org.coursera.petsproject.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.coursera.petsproject.activities.Interfaces.IPetLikeActivity;
import org.coursera.petsproject.R;
import org.coursera.petsproject.adapters.PetAdapterLCVLP;
import org.coursera.petsproject.database.Interactor;
import org.coursera.petsproject.model.Pet;
import org.coursera.petsproject.presenters.PetPresenter;
import org.coursera.petsproject.presenters.interfaces.IPetPresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class PetLikeActivity extends AppCompatActivity implements IPetLikeActivity{

    //Atributos de la actividad.
    private RecyclerView rvPetAPL;
    private IPetPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_like);

        initializeComponents();
    }

    /**
     * Método que permite inicializar los componentes correspondientes a la actividad.
     */
    public void initializeComponents () {
        presenter = new PetPresenter(this, getBaseContext(), MainActivity.interactor);
        establishToolbar();
    }

    /**
     * Método que asigna la barra de herramientas a la vista.
     */
    public void establishToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.ltbPetAPL);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    /**
     * Método que permite inicializar el recycler view.
     */
    @Override
    public void initializePetRecyclerView() {
        rvPetAPL = (RecyclerView) findViewById(R.id.rvPetAPL);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvPetAPL.setLayoutManager(linearLayoutManager);
    }

    /**
     * Método que genera la lista de mascotas
     */
    @Override
    public ArrayList<Pet> generatePetList(ArrayList<Pet> pets) {

        ArrayList<Pet> petsList = new ArrayList<>();

        for (Pet pet : pets) {
            if(pet.isFavoritePet()) {
                petsList.add(pet);
            }
        }

        return petsList;
    }

    /**
     * Método que organiza la lista de mascotas
     */
    @Override
    public ArrayList<Pet> organizePetList(ArrayList<Pet> petsList) {

        Collections.sort(petsList, new Comparator() {
            @Override
            public int compare(Object m1, Object m2) {

                Pet mas1 = (Pet) m1;
                Pet mas2 = (Pet) m2;

                Date d1 = mas1.getDateRatingPet();
                Date d2 = mas2.getDateRatingPet();

                if((d1 != null) && (d2 != null))
                {
                    if(d1.compareTo(d2) > 0) {
                        return -1;
                    }
                    else if(d1.compareTo(d2) < 0){
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }
                else
                {
                    return 0;
                }
            }
        });

        return petsList;
    }

    /**
     * Método que elige las ultimas cinco mascotas.
     */
    @Override
    public ArrayList<Pet> lastFivePets (ArrayList<Pet> petsList, Interactor interactor) {
        for(int i=petsList.size()-1; i > 4; i--) {
            interactor.deletePet(petsList.get(i));
            petsList.remove(i);
        }

        return petsList;
    }

    /**
     * Método que permite inicializar el petAdapter.
     */
    @Override
    public void initializePetAdapter(ArrayList<Pet> petsList) {
        PetAdapterLCVLP petAdapterLCVLP = new PetAdapterLCVLP(petsList);
        rvPetAPL.setAdapter(petAdapterLCVLP);
    }
}
