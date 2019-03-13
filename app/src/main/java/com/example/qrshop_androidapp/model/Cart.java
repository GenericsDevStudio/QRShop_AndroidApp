package com.example.qrshop_androidapp.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    // INITIALIZATION

    private List<Product> productsInCart = new ArrayList<>();

    private int productsInCartCount = productsInCart.size();

    // METHODS

    public void addToCart(Product toAdd){
        productsInCart.add(toAdd);
        productsInCartCount++;
    }

    public void removeFromCart(int position){
        productsInCart.remove(position);
        productsInCartCount--;
    }

    // GETTERS

    public int getProductsInCartCount() { return productsInCartCount; }

    public List<Product> getProductsInCart() { return productsInCart; }
}
