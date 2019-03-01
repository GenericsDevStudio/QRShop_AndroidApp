package com.example.qrshop_androidapp.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Resources {

    // INITIALIZATION

    private static User currentUser;
    private final String SERVER_URL = "Link here";
    private Gson gson = new GsonBuilder().create();
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    private Link link = retrofit.create(Link.class);

    // METHODS

    public static boolean registerUser(String name, String login, String password){
        currentUser = new User(name, login, password);
        // return true and set currentUser if registered on server
        // return false if already exists or no internet connection
        return true;
    }
    public static boolean loginUser(String login, String password){
        // return true if login on server is successful
        // return false if no such user or no internet connection
        return true;
    }
    public static Product findProduct(String identifier){
        // find product by identifier on server
        // return Product if found
        // return null if no such product
        return new Product("1234567", "Jacket", "250");
    }

    public static User getCurrentUser(){return currentUser;}

}
class User {
    // INITIALIZATION

    private String id;
    private String name;
    private String login;
    private String password;
    private String cash;

    User(String name, String login, String password){
        this.name = name; this.login = login; this.password = password;
        // get id, cash from server
        id = "1";
        cash = "1000";
    }

    //
    // GETTERS
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

    //
    //

}


class Product {

    // INITIALIZATION

    private String identifier;
    private String name;
    private String price;

    Product(String identifier, String name, String price){
        this.identifier = identifier; this.name = name; this.price = price;
    }

    //
    // GETTERS
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
}


