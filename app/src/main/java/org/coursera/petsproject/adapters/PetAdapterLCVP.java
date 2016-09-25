package org.coursera.petsproject.adapters;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.coursera.petsproject.R;
import org.coursera.petsproject.model.Pet;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Victor Daniel Cortés Restrepo on 14/09/16.
 */
public class PetAdapterLCVP extends RecyclerView.Adapter<PetAdapterLCVP.PetViewHolderLCVP> {

    //Atributos de la clase.
    private ArrayList<Pet> pets;

    /**
     * Método contructor de la clase.
     * @param pets, lista de mascotas.
     */
    public PetAdapterLCVP(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    /**
     * Método que establece la asociacion del layout con la lógica.
     * @param parent, padre del recycler view.
     * @param viewType, tipo del view.
     * @return el view holder generado en la clase estatica.
     */
    @Override
    public PetViewHolderLCVP onCreateViewHolder(ViewGroup parent, int viewType) {
        //Asociamos el layout al recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card_view_pet, parent, false);
        return new PetViewHolderLCVP(view);
    }

    /**
     * Método que permite asociar cada elemento de la lista con los views.
     * @param petViewHolder, contenedor de los views.
     * @param position, posicion actual del elemento de la lista.
     */
    @Override
    public void onBindViewHolder(final PetViewHolderLCVP petViewHolder, int position) {
        final Pet pet = pets.get(position);

        petViewHolder.tvNamePetLCVP.setText(pet.getNamePet());
        petViewHolder.tvRankPetLCVP.setText(String.valueOf(pet.getRatingPet()));
        petViewHolder.ivPetLCVP.setImageResource(pet.getImagePet());
        petViewHolder.ivWhiteBoneLCVP.setImageResource(pet.getIconFavoritePet());

        petViewHolder.ivWhiteBoneLCVP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!pet.isFavoritePet()) {
                    pet.setIconFavoritePet(R.drawable.ico_huesomorado);
                    pet.setRatingPet(pet.getRatingPet() + 1);
                    pet.setFavoritePet(true);
                    pet.setDateRatingPet(Calendar.getInstance().getTime());
                    petViewHolder.ivWhiteBoneLCVP.setImageResource(pet.getIconFavoritePet());
                    petViewHolder.tvRankPetLCVP.setText(String.valueOf(pet.getRatingPet()));

                    Snackbar.make(view, pet.getNamePet() + " es mascota favoria.", Snackbar.LENGTH_SHORT)
                            .show();
                }
                else {
                    pet.setIconFavoritePet(R.drawable.ico_huesoblanco);
                    pet.setRatingPet(pet.getRatingPet() - 1);
                    pet.setFavoritePet(false);
                    pet.setDateRatingPet(null);
                    petViewHolder.ivWhiteBoneLCVP.setImageResource(pet.getIconFavoritePet());
                    petViewHolder.tvRankPetLCVP.setText(String.valueOf(pet.getRatingPet()));

                    Snackbar.make(view, pet.getNamePet() + " no es mascota favoria.", Snackbar.LENGTH_SHORT)
                            .show();
                }
            }
        });
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
    public static class PetViewHolderLCVP extends RecyclerView.ViewHolder {

        //Views correspondientes al card view.
        private ImageView ivPetLCVP, ivWhiteBoneLCVP;
        private TextView tvNamePetLCVP, tvRankPetLCVP;

        /**
         * Método constructor por defecto de la clase.
         * @param itemView, contendor de todos los views.
         */
        public PetViewHolderLCVP(View itemView) {
            super(itemView);

            ivPetLCVP = (ImageView) itemView.findViewById(R.id.ivPetLCVP);
            ivWhiteBoneLCVP = (ImageView) itemView.findViewById(R.id.ivWhiteBoneLCVP);
            tvNamePetLCVP = (TextView) itemView.findViewById(R.id.tvNamePetLCVP);
            tvRankPetLCVP = (TextView) itemView.findViewById(R.id.tvRankPetLCVP);
        }
    }
}
