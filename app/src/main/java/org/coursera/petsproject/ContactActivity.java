package org.coursera.petsproject;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.coursera.petsproject.model.SendEmail;

public class ContactActivity extends AppCompatActivity {

    /*Atributos de la Actividad*/
    private EditText tietNameContactAC, tietEmailContactAC, tietMessageContactAC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        initializeComponents();
    }

    /**
     * Método que permite inicializar los componentes correspondientes a la actividad.
     */
    public void initializeComponents () {
        establishToolbar();

        tietNameContactAC = (EditText) findViewById(R.id.tietNameContactAC);
        tietEmailContactAC = (EditText) findViewById(R.id.tietEmailContactAC);
        tietMessageContactAC = (EditText) findViewById(R.id.tietMessageContactAC);
    }

    /**
     * Método que asigna la barra de herramientas a la vista.
     */
    public void establishToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.ltbContactAC);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    /**
     * Método para enviar un correo electronico.
     * @param view, vista desde la cual se realiza la invocación del método.
     */
    public void sendEmail(View view) {

        if( tietNameContactAC.getText().toString().isEmpty() || tietEmailContactAC.getText().toString().isEmpty()
                || tietMessageContactAC.getText().toString().isEmpty()) {

            Snackbar.make(view, getResources().getString(R.string.activity_contact_error_message), Snackbar.LENGTH_SHORT)
                    .show();
        }
        else {
            if(!tietEmailContactAC.getText().toString().toLowerCase().contains("@gmail.com")) {
                Snackbar.make(view, getResources().getString(R.string.activity_user_email_error_email), Snackbar.LENGTH_SHORT)
                        .show();
            }
            else {
                String asunto = tietNameContactAC.getText().toString() + " - " +getResources().getString(R.string.app_name);

                SendEmail sm = new SendEmail(this, tietEmailContactAC.getText().toString().trim(),
                        asunto.trim(), tietMessageContactAC.getText().toString().trim());

                sm.execute();
            }
        }
    }
}
