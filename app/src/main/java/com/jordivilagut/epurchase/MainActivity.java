package com.jordivilagut.epurchase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                startActivity(goToAddProduct);
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
    }

    public static void main(String[] args) {

        Product p1 = new Product("Mobile", 200);
        Product p2 = new Product("TV", 1000);
        Product p3 = new Product("Wine", 7);

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);
    }
}
