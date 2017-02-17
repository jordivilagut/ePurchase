package com.jordivilagut.epurchase;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button goToAddProduct;
    private Button goToCheckout;
    private ShoppingCart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToAddProduct = (Button) findViewById(R.id.addBtn);
        goToAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddProduct = new Intent(MainActivity.this, AddProductActivity.class);
                startActivityForResult(goToAddProduct, 1);
            }
        });

        goToCheckout = (Button) findViewById(R.id.checkoutBtn);
        goToCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCheckout = new Intent(MainActivity.this, CheckoutActivity.class);
                startActivityForResult(goToCheckout, 2);
            }
        });

        cart = new ShoppingCart();

        cart.addProduct(new Product("mobile", 200));
        cart.addProduct(new Product("tv", 1000));
        cart.addProduct(new Product("wine", 7));

        displayProductList(cart);
    }

    private void displayProductList(ShoppingCart cart) {

        TextView productList = (TextView) findViewById(R.id.productList);

        StringBuilder builder = new StringBuilder();
        for (Product product : cart.getProducts()) {
            builder.append(product.getPrice() + " € " + product.getName() + "\n");
        }

        productList.setText(builder.toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String name = data.getStringExtra("name");
                double price = Double.valueOf(data.getStringExtra("price"));
                Product newProduct = new Product(name, price);
                cart.addProduct(newProduct);
                displayProductList(cart);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Do nothing
            }
        }

        if (requestCode == 2) {
            if(resultCode == Activity.RESULT_OK){
                cart.products.clear();
                displayProductList(cart);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Do nothing
            }
        }
    }
}
