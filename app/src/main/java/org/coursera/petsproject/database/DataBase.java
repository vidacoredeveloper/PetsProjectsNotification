package org.coursera.petsproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.coursera.petsproject.model.Pet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Victor Daniel Cortés Restrepo on 2/10/16.
 */

public class DataBase extends SQLiteOpenHelper {

    /*Atributos de la clase*/
    private Context context;

    /**
     * Constructor de la clase.
     * @param context, contexto en el cual se esta trabajando.
     */
    public DataBase(Context context) {
        super(context, ConstantDataBase.DATABASE_NAME, null, ConstantDataBase.DATABASE_VERSION);
        this.context = context;
    }

    /**
     * Método que permite crear la base de datos
     * @param db, base de datos en la cual se generaran las tablas y estructura.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCreateTablePet = "CREATE TABLE " + ConstantDataBase.TABLE_PETS + "(" +
                ConstantDataBase.TABLE_PETS_ID              + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantDataBase.TABLE_PETS_NAME            + " TEXT, "     +
                ConstantDataBase.TABLE_PETS_IMAGE           + " INTEGER, "  +
                ConstantDataBase.TABLE_PETS_FAVORITE        + " INTEGER, "  +
                ConstantDataBase.TABLE_PETS_DATE_FAVORITE   + " TEXT, "     +
                ConstantDataBase.TABLE_PETS_ICON_FAVORITE   + " INTEGER, "  +
                ConstantDataBase.TABLE_PETS_RATING          + " INTEGER"    +
                ")";

        db.execSQL(queryCreateTablePet);
    }

    /**
     * Método que permite generar la bd.
     * @param db, base de datos a la cual se le generara la estructura.
     * @param oldVersion, versión anterior.
     * @param newVersion, versión nueva.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantDataBase.TABLE_PETS);
        onCreate(db);
    }

    /**
     * Método que permite traer la lista de mascotas.
     * @return pets, lista de las mascotas guardadas.
     */
    public ArrayList<Pet> getAllPets() {
        ArrayList<Pet> pets = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantDataBase.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Pet mascota = new Pet();
            mascota.setIdPet(registros.getInt(0));
            mascota.setNamePet(registros.getString(1));
            mascota.setImagePet(registros.getInt(2));
            mascota.setFavoritePet(convertFavoritePet(registros.getInt(3)));
            mascota.setDateRatingPet(convertDate(registros.getString(4)));
            mascota.setIconFavoritePet(registros.getInt(5));
            mascota.setRatingPet(registros.getInt(6));

            pets.add(mascota);

        }

        db.close();

        return pets;
    }

    /**
     * Método que permite la conversion del valor entero al booleano.
     * @param reg, valor entero a convertir en booleano.
     * @return true, si el valor entero es 1.
     * @return false, si el valor entero es 0.
     */
    private boolean convertFavoritePet(int reg) {
        if(reg != 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Método que permite convertir una cadena en una fecha.
     * @param reg, la cadena a convertir.
     * @return date, fecha establecida en la cadena.
     * @return null, si no se pudo establecer la fecha.
     */
    private Date convertDate(String reg) {
        DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        Date date = null;
        try {
            date = format.parse(reg);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Método que permite insertar una mascota.
     * @param contentValues, el contenerdor de valores respectivos a los campos de la tabla.
     */
    public void insertPet(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantDataBase.TABLE_PETS,null, contentValues);
        db.close();
    }

    /**
     * Método que permite eliminar el registro de una mascota con sus likes.
     * @param pet, mascota a eliminar del registro.
     */
    public void deletePet(Pet pet) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = ConstantDataBase.TABLE_PETS_ID + "=" + pet.getIdPet();
        db.delete(ConstantDataBase.TABLE_PETS, query, null);

        db.close();
    }
}
