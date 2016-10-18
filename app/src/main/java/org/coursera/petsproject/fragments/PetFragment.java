package org.coursera.petsproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.coursera.petsproject.activities.MainActivity;
import org.coursera.petsproject.R;
import org.coursera.petsproject.adapters.PetAdapterLCVP;
import org.coursera.petsproject.fragments.Interfaces.IPetFragment;
import org.coursera.petsproject.model.Pet;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PetFragment extends Fragment implements IPetFragment{

    //Atributos del fragmento.
    private RecyclerView rvPetAM;

    public PetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pet, container, false);

        initializePetRecyclerView(view);

        return view;
    }

    /**
     * Método que permite inicializar el recycler view.
     */
    public void initializePetRecyclerView(View view) {
        rvPetAM = (RecyclerView) view.findViewById(R.id.rvPetAM);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvPetAM.setLayoutManager(linearLayoutManager);

        generatePetList();
    }

    /**
     * Método que genera la lista de mascotas
     */
    @Override
    public void generatePetList() {

        MainActivity.petsList = new ArrayList<>();

        MainActivity.petsList.add(new Pet("Maya", R.drawable.img_pet_1, genetateRandomRating(), R.drawable.ico_huesoblanco));
        MainActivity.petsList.add(new Pet("Lennon", R.drawable.img_pet_2, genetateRandomRating(), R.drawable.ico_huesoblanco));
        MainActivity.petsList.add(new Pet("Mia", R.drawable.img_pet_3, genetateRandomRating(), R.drawable.ico_huesoblanco));
        MainActivity.petsList.add(new Pet("Balto", R.drawable.img_pet_4, genetateRandomRating(), R.drawable.ico_huesoblanco));
        MainActivity.petsList.add(new Pet("Lola", R.drawable.img_pet_5, genetateRandomRating(), R.drawable.ico_huesoblanco));
        MainActivity.petsList.add(new Pet("Thor", R.drawable.img_pet_6, genetateRandomRating(), R.drawable.ico_huesoblanco));
        MainActivity.petsList.add(new Pet("Rufo", R.drawable.img_pet_7, genetateRandomRating(), R.drawable.ico_huesoblanco));
        MainActivity.petsList.add(new Pet("Bruno", R.drawable.img_pet_8, genetateRandomRating(), R.drawable.ico_huesoblanco));
        MainActivity.petsList.add(new Pet("Manchas", R.drawable.img_pet_9, genetateRandomRating(), R.drawable.ico_huesoblanco));
        MainActivity.petsList.add(new Pet("Zick", R.drawable.img_pet_10, genetateRandomRating(), R.drawable.ico_huesoblanco));

        initializePetAdapter();
    }

    /**
     * Método que permite generar una claificación al azar a la mascota entre uno y cuatro.
     * @return random, número generado al azar.
     */
    @Override
    public int genetateRandomRating() {
        return (int) (Math.floor(Math.random()*(4-1+1)+1));
    }

    /**
     * Método que permite inicializar el petAdapter.
     */
    @Override
    public void initializePetAdapter() {
        PetAdapterLCVP petAdapterLCVP = new PetAdapterLCVP(MainActivity.petsList);
        rvPetAM.setAdapter(petAdapterLCVP);
    }

}
