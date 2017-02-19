package com.jordivilagut.epurchase;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart implements Serializable {

    private Map<String, Product> products;

    public ShoppingCart() { products = new TreeMap<>(); }

    public void addProduct(Product product) { products.put(product.getName(), product); }

    public Map<String, Product> getProducts() { return products; }

    public void clearBasket() { products.clear(); }

    public double getPrice() {

        double cartPrice = 0.0;

        for(Map.Entry<String, Product> product : products.entrySet()) {

            cartPrice += product.getValue().getPrice();
        }

        return cartPrice;
    }

    public String toString() {

        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, Product> product : products.entrySet()) {

            String name = product.getValue().getName();
            FormattedPrice formattedPrice = new FormattedPrice(product.getValue().getPrice());
            String price = formattedPrice.toString();

            builder.append(price + " € " + name + "\n");
        }

        return builder.toString();
    }
}