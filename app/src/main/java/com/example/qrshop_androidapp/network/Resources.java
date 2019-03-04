package com.example.qrshop_androidapp.network;

import android.util.Log;

import com.example.qrshop_androidapp.data.Product;
import com.example.qrshop_androidapp.data.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Resources {
    // INITIALIZATION

    private static User currentUser;
    private static final String SERVER_URL = "http://vasylko.zzz.com.ua/index.php/";
    private static Gson gson = new GsonBuilder().create();
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    private static Link link = retrofit.create(Link.class);
    // METHODS

    public static boolean registerUser(String name, String login, String password) {
        Call<Object> call = link.registerUser(login, password);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });
        return true;
    }

    public static boolean loginUser(final String login, final String password) {
        Call<Object> call = link.loginUser(login, password);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                User[] users = gson.fromJson(response.body().toString(), User[].class);
                currentUser = new User(login, password, users[0].getId(), users[0].getName(), users[0].getCash());
                Log.d("LOGIN : ", currentUser.getLogin());
                Log.d("PASSWORD : ", currentUser.getPassword());
                Log.d("ID : ", currentUser.getId());
                Log.d("NAME : ", currentUser.getName());
                Log.d("CASH", currentUser.getCash());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                   throw new NullPointerException();
            }
        });
        return true;
    }

    public static Product findProduct(String identifier) {
        // find product by identifier on server
        // return Product if found
        // return null if no such product
        return new Product("1234567", "Jacket", "250");
    }

}




