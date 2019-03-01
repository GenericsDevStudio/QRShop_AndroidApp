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
    @FormUrlEncoded
    @POST("second endpoint of the link here")
    Call<Object> loginUser(
            @Field("login") String login,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST("third endpoint of the link here")
    Call<Object> findProduct(
            @Field("identifier") String identifier
    );
}