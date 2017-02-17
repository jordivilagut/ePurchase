package com.jordivilagut.epurchase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {

    List<Product> products;

    public ShoppingCart() { this.products = new ArrayList<Product>(); }

    public void addProduct(Product product) { this.products.add(product); }

    public List<Product> getProducts() { return products; }

    public double getCartPrice() {
        double cartPrice = 0.0;
        for(Product product : products) {
            cartPrice += product.getPrice();
        }
        return cartPrice;
    }
}