package com.example.qrshop_androidapp.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    // INITIALIZATION

    private int productsInCartCount = 0;

    List<Product> productsInCart = new ArrayList<>();

    // METHODS

    public void addToCart(Product toAdd){
        productsInCart.add(toAdd);
        productsInCartCount++;
    }

    // GETTERS

    public int getProductsInCartCount() { return productsInCartCount; }

    public List<Product> getProductsInCart() { return productsInCart; }
}
