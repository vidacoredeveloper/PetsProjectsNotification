package org.coursera.petsproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.coursera.petsproject.R;
import org.coursera.petsproject.model.Pet;
import org.coursera.petsproject.rest.model.PetGram;

import java.util.ArrayList;

/**
 * Created by Victor Daniel Cortés Restrepo on 23/09/16.
 */

public class PhotoPetAdapter extends RecyclerView.Adapter<PhotoPetAdapter.PhotoPetViewHolder> {

    //Atributos de la clase.
    private ArrayList<PetGram> pets;
    private Context context;

    /**
     * Método contructor de la clase.
     * @param pets, lista de mascotas.
     */
    public PhotoPetAdapter(ArrayList<PetGram> pets) {
        this.pets = pets;
    }

    /**
     * Método que establece la asociacion del layout con la lógica.
     * @param parent, padre del recycler view.
     * @param viewType, tipo del view.
     * @return el view holder generado en la clase estatica.
     */
    @Override
    public PhotoPetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Asociamos el layout al recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card_view_photo_pet, parent, false);
        context = parent.getContext();
        return new PhotoPetViewHolder(view);
    }

    /**
     * Método que permite asociar cada elemento de la lista con los views.
     * @param photoPetViewHolder, contenedor de los views.
     * @param position, posicion actual del elemento de la lista.
     */
    @Override
    public void onBindViewHolder(PhotoPetViewHolder photoPetViewHolder, int position) {
        PetGram pet = pets.get(position);
        Picasso .with(context)
                .load(pet.getURLPhotoPet())
                .placeholder(R.drawable.img_pet_10)
                .into(photoPetViewHolder.ivPhotoPetLCVPP);
        photoPetViewHolder.tvRankPhotoPetLCVPP.setText(String.valueOf(pet.getLikesPet()));
    }

    /**
     * Método que permite consultar la cantidad de elementos que contiene mi lista.
     * @return pets.size, tamanho de la lista.
     */
    @Override
    public int getItemCount() {
        return pets.size();
    }

    /**
     * Clase que permite generar la lógica que le va a dar vida a los views.
     */
    public static class PhotoPetViewHolder extends RecyclerView.ViewHolder {

        //Views correspondientes al card view.
        private ImageView ivPhotoPetLCVPP;
        private TextView tvRankPhotoPetLCVPP;

        /**
         * Método constructor por defecto de la clase.
         * @param itemView, contendor de todos los views.
         */
        public PhotoPetViewHolder(View itemView) {
            super(itemView);

            ivPhotoPetLCVPP = (ImageView) itemView.findViewById(R.id.ivPhotoPetLCVPP);
            tvRankPhotoPetLCVPP = (TextView) itemView.findViewById(R.id.tvRankPhotoPetLCVPP);
        }
    }
}
