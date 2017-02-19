package com.jordivilagut.epurchase;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FormatUtil {

    public static String getIndentedPrice(double price) {

        NumberFormat formatter = new DecimalFormat("#0.00");
        String formattedPrice = formatter.format(price);
        int maxPricePositions = 14;
        int emptyPositions = maxPricePositions - formattedPrice.length();
        String indent = "";
        String figureSpace = "\u2007";

        for (int i = 0; i < emptyPositions ; i++) {
            indent += figureSpace;
        }

        String indentedPrice = indent + formattedPrice;

        return indentedPrice;
    }
}
