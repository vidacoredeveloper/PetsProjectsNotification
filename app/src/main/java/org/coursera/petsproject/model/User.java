package org.coursera.petsproject.model;

/**
 * Created by Victor Daniel Cortés Restrepo on 24/09/16.
 */

public class User {

    //Atributos de la clase.
    private String email;
    private String password;

    /**
     * Método constructor de la clase.
     * @param email, dirección de correo electrónico.
     * @param password, contraseña correo electrónico.
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Método accesor a la cadena almacenada en el atributo email.
     * @return email, cadena almacenada.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método modificador de la cadena almacenada en el atributo email.
     * @param email, cadena a almacenar en el atributo.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método accesor a la cadena almacenada en el atributo password.
     * @return password, cadena almacenada.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método modificador de la cadena almacenada en el atributo password.
     * @param password, cadena a almacenar en el atributo.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
