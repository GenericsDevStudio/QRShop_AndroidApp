package com.example.qrshop_androidapp.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Link {
    @FormUrlEncoded
    @POST("api/adduserqr")
    Call<Object> registerUser(
            @Field("login") String login,
            @Field("password") String password,
            @Field("name") String name
    );
    @FormUrlEncoded
    @POST("api/fdqr")
    Call<Object> loginUser(
            @Field("login") String login,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST("api/buy")
    Call<Object> findProduct(
            @Field("code") String code,
            @Field("id") String id
    );
}
