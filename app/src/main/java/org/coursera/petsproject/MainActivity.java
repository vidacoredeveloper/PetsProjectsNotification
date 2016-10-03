package org.coursera.petsproject;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.coursera.petsproject.adapters.PetAdapterLCVP;
import org.coursera.petsproject.adapters.ViewPagerAdapter;
import org.coursera.petsproject.database.Interactor;
import org.coursera.petsproject.fragments.PetFragment;
import org.coursera.petsproject.fragments.ProfilePetFragment;
import org.coursera.petsproject.model.Pet;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Atibutos de la actividad.
    public static ArrayList<Pet> petsList;
    public static Interactor interactor;
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
        interactor = new Interactor(getBaseContext());
        establishToolbar();
        setUPViewPager();
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
    private ArrayList<Fragment> addFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PetFragment());
        fragments.add(new ProfilePetFragment());

        return fragments;
    }

    /**
     * Método que permite inicializar el viewPager para el control de los fragmentos.
     */
    private void setUPViewPager() {
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

    /**
     * Método que nos permite ingresar a la vista de mascotas favoritas.
     */
    public void goAbout() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    /**
     * Método que nos permite ingresar a la vista de mascotas favoritas.
     */
    public void goContact() {
        Intent intent = new Intent(this, UserEmailActivity.class);
        startActivity(intent);
    }
}
