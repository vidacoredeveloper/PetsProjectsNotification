package org.coursera.petsproject.firebase.interfaces;

import org.coursera.petsproject.firebase.Constant;
import org.coursera.petsproject.firebase.model.ResponseUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Victor Daniel Cortés Restrepo on 31/10/16.
 */

public interface EndPoint {

    @FormUrlEncoded
    @POST(Constant.KEY_POST_ID_TOKEN)
    public Call<ResponseUser> registrarUsuario(@Field("id_dispositivo") String token, @Field("id_usuario_instagram") String user);

}
