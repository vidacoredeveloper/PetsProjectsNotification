package org.coursera.petsproject.rest.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.coursera.petsproject.rest.Constant;
import org.coursera.petsproject.rest.deserializer.PetDeserializer;
import org.coursera.petsproject.rest.deserializer.PetUserDeserializer;
import org.coursera.petsproject.rest.interfaces.IEndPoint;
import org.coursera.petsproject.rest.model.PetResponse;
import org.coursera.petsproject.rest.model.PetUserResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Victor Daniel Cortés Restrepo on 17/10/16.
 */

public class ResponseAdapter {

    public IEndPoint instagramEstablishConnection(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IEndPoint.class);
    }

    public Gson buildsGSonDeserializeUser() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetUserResponse.class, new PetUserDeserializer());
        return gsonBuilder.create();
    }

    public Gson buildsGSonDeserializeMediaRecent() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetResponse.class, new PetDeserializer());
        return gsonBuilder.create();
    }

}
