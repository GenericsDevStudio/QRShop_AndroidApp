package com.example.qrshop_androidapp.data;

public class Product {

    // INITIALIZATION

    private String identifier;
    private String name;
    private String price;

    public Product(String identifier, String name, String price){
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
