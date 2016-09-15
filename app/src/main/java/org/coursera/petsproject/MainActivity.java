package org.coursera.petsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.coursera.petsproject.adapters.PetAdapterLCVP;
import org.coursera.petsproject.model.Pet;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Atibutos de la actividad.
    public static ArrayList<Pet> petsList;
    private RecyclerView rvPetAM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.ltbPetAM);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    /**
     * Método que permite inicializar el recycler view.
     */
    public void initializePetRecyclerView() {
        rvPetAM = (RecyclerView) findViewById(R.id.rvPetAM);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvPetAM.setLayoutManager(linearLayoutManager);

        generatePetList();
    }

    /**
     * Método que genera la lista de mascotas
     */
    public void generatePetList() {

        petsList = new ArrayList<>();

        petsList.add(new Pet("Maya", R.drawable.img_pet_1, genetateRandomRating(), R.drawable.ico_huesoblanco));
        petsList.add(new Pet("Lennon", R.drawable.img_pet_2, genetateRandomRating(), R.drawable.ico_huesoblanco));
        petsList.add(new Pet("Mia", R.drawable.img_pet_3, genetateRandomRating(), R.drawable.ico_huesoblanco));
        petsList.add(new Pet("Balto", R.drawable.img_pet_4, genetateRandomRating(), R.drawable.ico_huesoblanco));
        petsList.add(new Pet("Lola", R.drawable.img_pet_5, genetateRandomRating(), R.drawable.ico_huesoblanco));
        petsList.add(new Pet("Thor", R.drawable.img_pet_6, genetateRandomRating(), R.drawable.ico_huesoblanco));
        petsList.add(new Pet("Rufo", R.drawable.img_pet_7, genetateRandomRating(), R.drawable.ico_huesoblanco));
        petsList.add(new Pet("Bruno", R.drawable.img_pet_8, genetateRandomRating(), R.drawable.ico_huesoblanco));
        petsList.add(new Pet("Manchas", R.drawable.img_pet_9, genetateRandomRating(), R.drawable.ico_huesoblanco));
        petsList.add(new Pet("Zick", R.drawable.img_pet_10, genetateRandomRating(), R.drawable.ico_huesoblanco));

        initializePetAdapter();
    }

    /**
     * Método que permite generar una claificación al azar a la mascota entre uno y cuatro.
     * @return random, número generado al azar.
     */
    public int genetateRandomRating() {
        return (int) (Math.floor(Math.random()*(4-1+1)+1));
    }

    /**
     * Método que permite inicializar el petAdapter.
     */
    public void initializePetAdapter() {
        PetAdapterLCVP petAdapterLCVP = new PetAdapterLCVP(petsList);
        rvPetAM.setAdapter(petAdapterLCVP);
    }

    /**
     * Método que genera un menu de opciones.
     * @param menu, que se va a mostrar en la vista.
     * @return true, si se genero correctamente.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    /**
     * Método que controla las accione de los diferentes elementos que hacen parte del menu de opciones.
     * @param item, elemento del menu seleccionado por el usuario.
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mFavorites:

                goFavoritePets();

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Método que nos permite ingresar a la vista de mascotas favoritas.
     */
    public void goFavoritePets() {
        Intent intent = new Intent(this, PetLikeActivity.class);
        startActivity(intent);
    }
}
