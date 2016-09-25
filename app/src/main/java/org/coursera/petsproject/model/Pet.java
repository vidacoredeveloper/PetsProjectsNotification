package org.coursera.petsproject.model;

import java.util.Date;

/**
 * Created by Victor Daniel Cortés Restrepo on 14/09/16.
 */
public class Pet {

    //Atributos de la clase.
    private String namePet;
    private int imagePet;
    private int ratingPet;
    private Date dateRatingPet;
    private boolean favoritePet;
    private int iconFavoritePet;

    /**
     * Método constructor por defecto de la clase.
     */
    public Pet() {
    }

    /**
     * Método constructor de la clase.
     * @param namePet, cadena correspondiente al nombre de la mascota.
     * @param imagePet, path correspondiente a la imagen de la mascota.
     * @param ratingPet, valor correspondiente a la calificación de la mascota.
     * @param imageFavoritePet, path correspondiente al icono de mascota favorita de la mascota.
     */
    public Pet(String namePet, int imagePet, int ratingPet, int imageFavoritePet) {
        this.namePet = namePet;
        this.imagePet = imagePet;
        this.ratingPet = ratingPet;
        this.iconFavoritePet = imageFavoritePet;
        dateRatingPet = null;
        favoritePet = false;
    }

    /**
     * Método accesor a la cadena almacenada en el atributo namePet.
     * @return namePet, cadena almacenada.
     */
    public String getNamePet() {
        return namePet;
    }

    /**
     * Método modificador de la cadena almacenada en el atributo namePet.
     * @param namePet, cadena a almacenar en el atributo.
     */
    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    /**
     * Método accesor al path almacenado en el atributo imagePet.
     * @return imagePet, path almacenado.
     */
    public int getImagePet() {
        return imagePet;
    }

    /**
     * Método modificador del path almacenado en el atributo imagePet.
     * @param imagePet, path a almacenar en el atributo.
     */
    public void setImagePet(int imagePet) {
        this.imagePet = imagePet;
    }

    /**
     * Método accesor al valor almacenado en el atributo ratingPet.
     * @return ratingPet, valor almacenado.
     */
    public int getRatingPet() {
        return ratingPet;
    }

    /**
     * Método modificador del valor almacenado en el atributo ratingPet.
     * @param ratingPet, valor a almacenar en el atributo.
     */
    public void setRatingPet(int ratingPet) {
        this.ratingPet = ratingPet;
    }

    /**
     * Método accesor a la fecha almacenada en el atributo dateRatingPet.
     * @return dateRatingPet, fecha almacenada.
     */
    public Date getDateRatingPet() {
        return dateRatingPet;
    }

    /**
     * Método modificador de la fecha almacenada en el atributo dateRatingPet.
     * @param dateRatingPet, fecha a almacenar en el atributo.
     */
    public void setDateRatingPet(Date dateRatingPet) {
        this.dateRatingPet = dateRatingPet;
    }

    /**
     * Método accesor al estado de la mascota como favorita almacenado en el atributo favoritePet.
     * @return favoritePet, estado almacenado.
     */
    public boolean isFavoritePet() {
        return favoritePet;
    }

    /**
     * Método modificador del estado de la mascota almacenado en el atributo favoritePet.
     * @param favoritePet, estado de la mascota a almacenar en el atributo.
     */
    public void setFavoritePet(boolean favoritePet) {
        this.favoritePet = favoritePet;
    }

    /**
     * Método accesor al path almacenado en el atributo iconFavoritePet.
     * @return iconFavoritePet, path almacenado.
     */
    public int getIconFavoritePet() {
        return iconFavoritePet;
    }

    /**
     * Método modificador del path almacenado en el atributo iconFavoritePet.
     * @param iconFavoritePet, path a almacenar en el atributo.
     */
    public void setIconFavoritePet(int iconFavoritePet) {
        this.iconFavoritePet = iconFavoritePet;
    }
}
