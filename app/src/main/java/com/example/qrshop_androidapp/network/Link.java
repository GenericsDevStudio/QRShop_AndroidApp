package com.example.qrshop_androidapp.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Link {
    @FormUrlEncoded
    @POST("Endpoint of the link here")
    Call<Object> registerUser(
            @Field("login") String login,
            @Field("password") String password
    );
}
