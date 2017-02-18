package com.jordivilagut.epurchase;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart implements Serializable {

    private Map<String, Product> products;

    public ShoppingCart() { products = new TreeMap<>(); }

    public void addProduct(Product product) { products.put(product.getName(), product); }

    public Map<String, Product> getProducts() { return products; }

    public double getCartPrice() {
        double cartPrice = 0.0;
        for(Map.Entry<String, Product> product : products.entrySet()) {
            cartPrice += product.getValue().getPrice();
        }
        return cartPrice;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Product> product : products.entrySet()) {
            builder.append(product.getValue().getPrice() + " € " + product.getValue().getName() + "\n");
        }
        return builder.toString();
    }

    public void clearBasket() {
        products.clear();
    }
}