package org.coursera.petsproject.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.coursera.petsproject.R;
import org.coursera.petsproject.activities.Interfaces.IConfigurationActivity;
import org.coursera.petsproject.rest.adapter.ResponseAdapter;
import org.coursera.petsproject.rest.interfaces.IEndPoint;
import org.coursera.petsproject.rest.model.PetUserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfigurationActivity extends AppCompatActivity implements IConfigurationActivity{

    private EditText tietUsetAC;
    private String id;
    private String name;
    private String photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);



        initializeComponents();
    }

    /**
     * Método que permite inicializar los componentes correspondientes a la actividad.
     */
    public void initializeComponents () {
        establishToolbar();
        id="";
        name="";
        photo="";
        tietUsetAC = (EditText) findViewById(R.id.tietUsetAC);
    }

    /**
     * Método que asigna la barra de herramientas a la vista.
     */
    public void establishToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.ltbUserAC);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public void saveUser(View view) {
        getPetUser();
    }

    @Override
    public void getPetUser() {
        ResponseAdapter responseAdapter = new ResponseAdapter();
        Gson gson = responseAdapter.buildsGSonDeserializeUser();
        IEndPoint iEndPoint = responseAdapter.instagramEstablishConnection(gson);
        Call<PetUserResponse> petResponseCall = iEndPoint.getPetUSer(tietUsetAC.getText().toString());

        petResponseCall.enqueue(new Callback<PetUserResponse>() {
            @Override
            public void onResponse(Call<PetUserResponse> call, Response<PetUserResponse> response) {
                PetUserResponse petResponse = response.body();
                id = petResponse.getPet().getIdPet();
                name = petResponse.getPet().getNamePet();
                photo = petResponse.getPet().getURLPhotoPet();

                goMainActivity();
            }

            @Override
            public void onFailure(Call<PetUserResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Problema al cargar las fotos del perfil", Toast.LENGTH_LONG).show();
                Log.e("Fallo Conexión", t.toString());
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            goMainActivity();
        }
        return super.onKeyDown(keyCode, event);
    }

    private void goMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("name", name);
        intent.putExtra("photo", photo);
        startActivity(intent);
        finish();
    }
}
