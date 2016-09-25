package org.coursera.petsproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import org.coursera.petsproject.adapters.PetAdapterLCVLP;
import org.coursera.petsproject.adapters.PetAdapterLCVP;
import org.coursera.petsproject.model.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class PetLikeActivity extends AppCompatActivity {

    //Atributos de la actividad.
    private RecyclerView rvPetAPL;

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
        establishToolbar();
        initializePetRecyclerView();
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
    public void initializePetRecyclerView() {
        rvPetAPL = (RecyclerView) findViewById(R.id.rvPetAPL);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvPetAPL.setLayoutManager(linearLayoutManager);

        generatePetList();
    }

    /**
     * Método que genera la lista de mascotas
     */
    public void generatePetList() {

        ArrayList<Pet> petsList = new ArrayList<>();

        for (Pet pet : MainActivity.petsList) {
            if(pet.isFavoritePet()) {
                petsList.add(pet);
            }
        }

        organizePetList(petsList);
    }

    /**
     * Método que organiza la lista de mascotas
     */
    public void organizePetList(ArrayList<Pet> petsList) {

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

        lastFivePets(petsList);
    }

    /**
     * Método que elige las ultimas cinco mascotas.
     */
    public void lastFivePets (ArrayList<Pet> petsList) {

        for(int i=petsList.size()-1; i > 4; i--) {
            petsList.remove(i);
        }

        initializePetAdapter(petsList);
    }

    /**
     * Método que permite inicializar el petAdapter.
     */
    public void initializePetAdapter(ArrayList<Pet> petsList) {
        PetAdapterLCVLP petAdapterLCVLP = new PetAdapterLCVLP(petsList);
        rvPetAPL.setAdapter(petAdapterLCVLP);
    }
}
