package org.coursera.petsproject.database;

import android.content.ContentValues;
import android.content.Context;

import org.coursera.petsproject.model.Pet;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Victor Daniel Cortés Restrepo on 2/10/16.
 */

public class Interactor {

    /*Atributos de la clase*/
    private Context context;
    private DataBase dataBase;

    /**
     * Método constructor de la clase.
     * @param context, contexto de trabajo en el cual se está trabajando.
     */
    public Interactor(Context context) {
        this.context = context;
        dataBase = new DataBase(context);
    }

    /**
     * Método que permite obtener la lista de mascotas.
     * @return pets, lista de mascotas.
     */
    public ArrayList<Pet> getAllPets() {
        return dataBase.getAllPets();
    }

    /**
     * Método que permite insertar una mascota.
     * @param name, nombre de la mascota a insertar.
     * @param image, path de la imagen de la mascota a insertar.
     * @param favorite, estado de la mascota a insertar.
     * @param date, fecha de la actualización del estado de la mascota a insertar.
     * @param icon, path del icono de representación del estado de la mascota a insertar.
     */
    public void insertPet(String name, int image, boolean favorite, Date date, int icon, int rating) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantDataBase.TABLE_PETS_NAME, name);
        contentValues.put(ConstantDataBase.TABLE_PETS_IMAGE, image);
        contentValues.put(ConstantDataBase.TABLE_PETS_FAVORITE, favorite);
        contentValues.put(ConstantDataBase.TABLE_PETS_DATE_FAVORITE, date.toString());
        contentValues.put(ConstantDataBase.TABLE_PETS_ICON_FAVORITE, icon);
        contentValues.put(ConstantDataBase.TABLE_PETS_RATING, rating);

        dataBase.insertPet(contentValues);
    }

    /**
     * Método que permite eliminar una mascota.
     * @param pet, mascota que se desea eliminar.
     */
    public void deletePet(Pet pet) {
        dataBase.deletePet(pet);
    }
}
