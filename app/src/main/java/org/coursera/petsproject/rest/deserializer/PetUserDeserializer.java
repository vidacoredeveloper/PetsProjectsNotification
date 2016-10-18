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
import org.coursera.petsproject.rest.model.PetUserResponse;

import java.lang.reflect.Type;

/**
 * Created by Victor Daniel Cortés Restrepo on 18/10/16.
 */

public class PetUserDeserializer implements JsonDeserializer<PetUserResponse> {

    @Override
    public PetUserResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PetUserResponse petResponse = gson.fromJson(json, PetUserResponse.class);
        JsonArray petResponseData = json.getAsJsonObject().getAsJsonArray(KeysJson.MEDIA_RESPONSE_ARRAY);
        petResponse.setPet(deserializePetJSon(petResponseData));
        return petResponse;
    }

    private PetGram deserializePetJSon(JsonArray petResponseData) {

        JsonObject petObject = petResponseData.get(0).getAsJsonObject();

        String id               = petObject.get(KeysJson.USER_ID).getAsString();
        String nombre           = petObject.get(KeysJson.USER_FULL_NAME).getAsString();
        String imgURL           = petObject.get(KeysJson.USER_PROFILE).getAsString();

        PetGram petGram = new PetGram(id, nombre, imgURL, 0);

        return petGram;
    }
}
