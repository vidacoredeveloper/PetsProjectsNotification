package org.coursera.petsproject.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.coursera.petsproject.activities.Interfaces.IMainActivity;
import org.coursera.petsproject.R;
import org.coursera.petsproject.adapters.ViewPagerAdapter;
import org.coursera.petsproject.database.Interactor;
import org.coursera.petsproject.fragments.PetFragment;
import org.coursera.petsproject.fragments.ProfilePetFragment;
import org.coursera.petsproject.model.Pet;
import org.coursera.petsproject.rest.model.PetGram;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    //Atibutos de la actividad.
    public static ArrayList<Pet> petsList;
    public static Interactor interactor;
    public static PetGram petGram;
    private Toolbar toolbar;
    private TabLayout tabBarAM;
    private ViewPager vpPetAM;

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
        petGram = new PetGram();
        getParametersPet(petGram);
        interactor = new Interactor(getBaseContext());
        establishToolbar();
        setUPViewPager();
    }

    public void getParametersPet(PetGram pet){
        if(getIntent().getExtras() != null){
            pet.setIdPet(getIntent().getExtras().getString("id"));
            pet.setNamePet(getIntent().getExtras().getString("name"));
            pet.setURLPhotoPet(getIntent().getExtras().getString("photo"));
        }
    }

    /**
     * Método que asigna la barra de herramientas a la vista.
     */
    public void establishToolbar() {
        toolbar = (Toolbar) findViewById(R.id.tbPetAM);
        tabBarAM = (TabLayout) findViewById(R.id.tabBarAM);
        vpPetAM = (ViewPager) findViewById(R.id.vpPetAM);

        if(toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    /**
     * Método que permite agregar los fragmentos a la lista.
     * @return fragments, lista de fragmentos.
     */
    @Override
    public ArrayList<Fragment> addFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PetFragment());
        fragments.add(new ProfilePetFragment());

        return fragments;
    }

    /**
     * Método que permite inicializar el viewPager para el control de los fragmentos.
     */
    @Override
    public void setUPViewPager() {
        vpPetAM.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), addFragments()));
        tabBarAM.setupWithViewPager(vpPetAM);

        tabBarAM.getTabAt(0).setIcon(R.drawable.icon_dog_house);
        tabBarAM.getTabAt(1).setIcon(R.drawable.icon_dog);
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
            case R.id.mContacto:

                goContact();

                break;

            case R.id.mAcercaDe:

                goAbout();

                break;

            case R.id.mFavorites:

                goFavoritePets();

                break;

            case R.id.mConfigurarCuenta:

                goConfiguration();

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Método que nos permite ingresar a la vista de mascotas favoritas.
     */
    @Override
    public void goFavoritePets() {
        Intent intent = new Intent(this, PetLikeActivity.class);
        startActivity(intent);
    }

    /**
     * Método que nos permite ingresar a la vista de mascotas favoritas.
     */
    @Override
    public void goAbout() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    /**
     * Método que nos permite ingresar a la vista de mascotas favoritas.
     */
    @Override
    public void goContact() {
        Intent intent = new Intent(this, UserEmailActivity.class);
        startActivity(intent);
    }

    /**
     * Método que nos permite ingresar a la vista de configuración de cuenta.
     */
    @Override
    public void goConfiguration() {
        Intent intent = new Intent(this, ConfigurationActivity.class);
        startActivity(intent);
        finish();
    }
}
