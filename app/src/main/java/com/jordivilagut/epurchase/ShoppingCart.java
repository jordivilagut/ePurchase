package com.jordivilagut.epurchase;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
        NumberFormat formatter = new DecimalFormat("#0.00");

        for (Map.Entry<String, Product> product : products.entrySet()) {
            String price = formatter.format(product.getValue().getPrice());
            String name = product.getValue().getName();
            int emptyPositions = 14 - String.valueOf(price).length();
            String space = "";

            for (int i = 0; i < emptyPositions ; i++) {
                space += "\u2007";
            }

            builder.append(space + price + " € " + name + "\n");
        }
        return builder.toString();
    }

    public void clearBasket() {
        products.clear();
    }
}