package org.coursera.petsproject.rest.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.coursera.petsproject.rest.KeysJson;
import org.coursera.petsproject.rest.model.PetGram;
import org.coursera.petsproject.rest.model.PetResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Victor Daniel Cortés Restrepo on 17/10/16.
 */

public class PetDeserializer implements JsonDeserializer<PetResponse>{


    @Override
    public PetResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PetResponse petResponse = gson.fromJson(json, PetResponse.class);
        JsonArray petResponseData = json.getAsJsonObject().getAsJsonArray(KeysJson.MEDIA_RESPONSE_ARRAY);
        petResponse.setPets(deserializePetJSon(petResponseData));
        return petResponse;
    }

    private ArrayList<PetGram> deserializePetJSon(JsonArray petResponseData) {
        ArrayList<PetGram> pets = new ArrayList<>();

        for (int i=0; i<petResponseData.size(); i++) {
            JsonObject petObject = petResponseData.get(i).getAsJsonObject();

            JsonObject userObject   = petObject.getAsJsonObject(KeysJson.USER);
            String id               = userObject.get(KeysJson.USER_ID).getAsString();
            String nombre           = userObject.get(KeysJson.USER_FULL_NAME).getAsString();

            JsonObject imgObject        = petObject.getAsJsonObject(KeysJson.MEDIA_IMAGES);
            JsonObject imgResolution    = imgObject.getAsJsonObject(KeysJson.MEDIA_STANDARD);
            String imgURL               = imgResolution.get(KeysJson.MEDIA_URL).getAsString();

            JsonObject likeObject   = petObject.getAsJsonObject(KeysJson.PET_LIKES);
            int likeCount           = likeObject.get(KeysJson.PET_LIKES_COUNT).getAsInt();

            PetGram petGram = new PetGram(id, nombre, imgURL, likeCount);
            pets.add(petGram);
        }

        return pets;
    }
}
