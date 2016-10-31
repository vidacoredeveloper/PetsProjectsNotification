package org.coursera.petsproject.firebase.adapters;

import org.coursera.petsproject.firebase.Constant;
import org.coursera.petsproject.firebase.interfaces.EndPoint;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Victor Daniel Cortés Restrepo on 31/10/16.
 */

public class AdapterDataUser {

    public EndPoint establecerConexionRest(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndPoint.class);
    }
}
