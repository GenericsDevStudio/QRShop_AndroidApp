package com.example.qrshop_androidapp.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Resources {
    private final String SERVER_URL = "Link here";
    Gson gson = new GsonBuilder().create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
class User {
    private String id;
    private String name;
    private String login;
    private String password;
    private String cash;

    //
    //

    public String getCash() {
        return cash;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //
    //

}


class Product {
    private String identifier;
    private String name;
    private String price;

    //
    //


    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdentifier(String identifier) {

    }

    public void setPrice(String price) {
        this.price = price;
    }
}

