package org.coursera.petsproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import org.coursera.petsproject.activities.MainActivity;
import org.coursera.petsproject.R;
import org.coursera.petsproject.adapters.PhotoPetAdapter;
import org.coursera.petsproject.fragments.Interfaces.IProfilePetFragment;
import org.coursera.petsproject.model.Pet;
import org.coursera.petsproject.rest.adapter.ResponseAdapter;
import org.coursera.petsproject.rest.interfaces.IEndPoint;
import org.coursera.petsproject.rest.model.PetGram;
import org.coursera.petsproject.rest.model.PetResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilePetFragment extends Fragment implements IProfilePetFragment{

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

    /**
     * Método que permite inicializar los componentes correspondientes al fragmento.
     * @param view, vista a la cual se le generara la inicialización de componentes.
     */
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

        //generatePetList(MainActivity.petsList);
        getPetRecentMedia();
    }

    /**
     * Método que genera la lista de mascotas
     */
    @Override
    public void generatePetList(ArrayList<PetGram> pets) {

        if(!pets.isEmpty())
        {
            Picasso.with(getContext())
                    .load(MainActivity.petGram.getURLPhotoPet())
                    .placeholder(R.drawable.img_pet_10)
                    .into(civProfilePetFPP);
            tvNameProfilePetFPP.setText(MainActivity.petGram.getNamePet());

            initializePetAdapter(pets);
        }
    }

    /**
     * Método que permite inicializar el petAdapter.
     */
    @Override
    public void initializePetAdapter(ArrayList<PetGram> pets) {
        PhotoPetAdapter photoPetAdapter = new PhotoPetAdapter(pets);
        rvPhotoProfilePetFPP.setAdapter(photoPetAdapter);
    }

    @Override
    public void getPetRecentMedia() {
        ResponseAdapter responseAdapter = new ResponseAdapter();
        Gson gson = responseAdapter.buildsGSonDeserializeMediaRecent();
        IEndPoint iEndPoint = responseAdapter.instagramEstablishConnection(gson);

        Call<PetResponse> petResponseCall = iEndPoint.getRecentMediaUser(MainActivity.petGram.getIdPet());

        petResponseCall.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {
                PetResponse petResponse = response.body();
                generatePetList(petResponse.getPets());
            }

            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Problema al cargar las fotos del perfil", Toast.LENGTH_LONG).show();
                Log.e("Fallo Conexión", t.toString());
            }
        });
    }
}
