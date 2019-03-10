package com.example.qrshop_androidapp.model;

public class User {
    // INITIALIZATION

    private String id;
    private String name;
    private String login;
    private String password;
    private String cash;

    public User(String login, String password, String id, String name, String cash){
        this.login = login; this.password = password; this.id = id;
        this.name = name; this.cash = cash;
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
