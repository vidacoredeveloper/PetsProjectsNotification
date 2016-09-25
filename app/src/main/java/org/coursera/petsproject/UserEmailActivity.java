package org.coursera.petsproject;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import org.coursera.petsproject.model.User;

public class UserEmailActivity extends AppCompatActivity {

    /*Atributos de la actividad*/
    public static User user;
    private EditText tietEmailUserEmialUEA, tietPasswordUserEmialUEA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_email);

        initializeComponents();
    }

    /**
     * Método que permite inicializar los componentes correspondientes a la actividad.
     */
    public void initializeComponents () {
        establishToolbar();

        tietEmailUserEmialUEA = (EditText) findViewById(R.id.tietEmailUserEmialUEA);
        tietPasswordUserEmialUEA = (EditText) findViewById(R.id.tietPasswordUserEmialUEA);
    }

    /**
     * Método que asigna la barra de herramientas a la vista.
     */
    public void establishToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.ltbUserEmialUEA);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    /**
     * Método que permite contunuar con la instancia para enviar el mensaje por medio del correo.
     * @param view, vista desde la cual se realiza la invocación del método.
     */
    public void continueMessage(View view) {

        user = new User(tietEmailUserEmialUEA.getText().toString(), tietPasswordUserEmialUEA.getText().toString());

        if(user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            Snackbar.make(view, getResources().getString(R.string.activity_contact_error_message), Snackbar.LENGTH_SHORT)
                    .show();
        }
        else {
            if(!user.getEmail().toLowerCase().contains("@gmail.com")) {
                Snackbar.make(view, getResources().getString(R.string.activity_user_email_error_email), Snackbar.LENGTH_SHORT)
                        .show();
            }
            else {
                Intent intent = new Intent(this, ContactActivity.class);
                startActivity(intent);
            }
        }
    }
}
