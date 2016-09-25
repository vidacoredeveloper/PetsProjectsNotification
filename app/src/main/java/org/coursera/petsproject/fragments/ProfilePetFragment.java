package org.coursera.petsproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import org.coursera.petsproject.MainActivity;
import org.coursera.petsproject.R;
import org.coursera.petsproject.adapters.PhotoPetAdapter;
import org.coursera.petsproject.model.Pet;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilePetFragment extends Fragment {

    //Atributos del fragmento
    private RecyclerView rvPhotoProfilePetFPP;
    private CircularImageView civProfilePetFPP;
    private TextView tvNameProfilePetFPP;

    public ProfilePetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_pet, container, false);

        initializeComponents(view);

        return view;
    }

    private void initializeComponents(View view) {

        civProfilePetFPP = (CircularImageView) view.findViewById(R.id.civProfilePetFPP);
        tvNameProfilePetFPP = (TextView) view.findViewById(R.id.tvNameProfilePetFPP);

        initializePetRecyclerView(view);
    }

    /**
     * Método que permite inicializar el recycler view.
     */
    private void initializePetRecyclerView(View view) {
        rvPhotoProfilePetFPP = (RecyclerView) view.findViewById(R.id.rvPhotoProfilePetFPP);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), 3);
        rvPhotoProfilePetFPP.setLayoutManager(layoutManager);

        generatePetList();
    }

    /**
     * Método que genera la lista de mascotas
     */
    public void generatePetList() {

        ArrayList<Pet> pets = MainActivity.petsList;

        if(!pets.isEmpty())
        {
            civProfilePetFPP.setImageResource(pets.get(0).getImagePet());
            tvNameProfilePetFPP.setText(pets.get(0).getNamePet());

            pets.remove(0);

            initializePetAdapter(pets);
        }
    }

    /**
     * Método que permite inicializar el petAdapter.
     */
    public void initializePetAdapter(ArrayList<Pet> pets) {
        PhotoPetAdapter photoPetAdapter = new PhotoPetAdapter(pets);
        rvPhotoProfilePetFPP.setAdapter(photoPetAdapter);
    }

}
