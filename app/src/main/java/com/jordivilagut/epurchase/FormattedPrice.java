package com.jordivilagut.epurchase;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FormattedPrice {

    private String price;

    public FormattedPrice(double price) {

        NumberFormat formatter = new DecimalFormat("#0.00");
        this.price = formatter.format(price);
    }

    public String getPrice() { return price; }

    public String toString() {
        int emptyPositions = 14 - price.length();
        String indent = "";

        for (int i = 0; i < emptyPositions ; i++) {
            indent += "\u2007";
        }

        return indent + price;
    }
}
