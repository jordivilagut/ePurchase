package com.jordivilagut.epurchase;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button goToAddProduct;
    Button goToCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToAddProduct = (Button)findViewById(R.id.addBtn);
        goToAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddProduct = new Intent(MainActivity.this, AddProduct.class);
                startActivityForResult(goToAddProduct, 1);
            }
        });

        goToCheckout = (Button)findViewById(R.id.checkoutBtn);
        goToCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCheckout = new Intent(MainActivity.this, Checkout.class);
                startActivity(goToCheckout);
            }
        });

        TextView productList = (TextView) findViewById(R.id.productList);
        Product mobile = new Product("mobile", 200);
        Product tv = new Product("tv", 1000);
        Product wine = new Product("wine", 7);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(mobile);
        cart.addProduct(tv);
        cart.addProduct(wine);

        StringBuilder builder = new StringBuilder();
        for (Product product : cart.getProducts()) {
            builder.append(product.getPrice() + " € " + product.getName() + "\n");
        }

        productList.setText(builder.toString());
    }
}
