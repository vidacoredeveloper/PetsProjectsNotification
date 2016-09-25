package org.coursera.petsproject.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.coursera.petsproject.R;
import org.coursera.petsproject.model.Pet;

import java.util.ArrayList;

/**
 * Created by Victor Daniel Cotés Restrepo on 14/09/16.
 */
public class PetAdapterLCVLP extends RecyclerView.Adapter<PetAdapterLCVLP.PetViewHolderLCVLP> {

    //Atributos de la clase.
    private ArrayList<Pet> pets;

    /**
     * Método contructor de la clase.
     * @param pets, lista de mascotas.
     */
    public PetAdapterLCVLP(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    /**
     * Método que establece la asociacion del layout con la lógica.
     * @param parent, padre del recycler view.
     * @param viewType, tipo del view.
     * @return el view holder generado en la clase estatica.
     */
    @Override
    public PetViewHolderLCVLP onCreateViewHolder(ViewGroup parent, int viewType) {
        //Asociamos el layout al recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card_view_like_pet, parent, false);
        return new PetViewHolderLCVLP(view);
    }

    /**
     * Método que permite asociar cada elemento de la lista con los views.
     * @param petViewHolder, contenedor de los views.
     * @param position, posicion actual del elemento de la lista.
     */
    @Override
    public void onBindViewHolder(PetViewHolderLCVLP petViewHolder, int position) {
        Pet pet = pets.get(position);

        petViewHolder.tvNamePetLCVLP.setText(pet.getNamePet());
        petViewHolder.tvRankPetLCVLP.setText(String.valueOf(pet.getRatingPet()));
        petViewHolder.ivPetLCVLP.setImageResource(pet.getImagePet());
        petViewHolder.ivWhiteBoneLCVLP.setImageResource(pet.getIconFavoritePet());
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
    public static class PetViewHolderLCVLP extends RecyclerView.ViewHolder {

        //Views correspondientes al card view.
        private ImageView ivPetLCVLP, ivWhiteBoneLCVLP;
        private TextView tvNamePetLCVLP, tvRankPetLCVLP;

        /**
         * Método constructor por defecto de la clase.
         * @param itemView, contendor de todos los views.
         */
        public PetViewHolderLCVLP(View itemView) {
            super(itemView);

            ivPetLCVLP = (ImageView) itemView.findViewById(R.id.ivPetLCVLP);
            ivWhiteBoneLCVLP = (ImageView) itemView.findViewById(R.id.ivWhiteBoneLCVLP);
            tvNamePetLCVLP = (TextView) itemView.findViewById(R.id.tvNamePetLCVLP);
            tvRankPetLCVLP = (TextView) itemView.findViewById(R.id.tvRankPetLCVLP);
        }
    }
}
