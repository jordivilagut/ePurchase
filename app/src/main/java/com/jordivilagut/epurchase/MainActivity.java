package com.jordivilagut.epurchase;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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

        TextView productList = (TextView) findViewById(R.id.productList);
        productList.setMovementMethod(new ScrollingMovementMethod());

        goToAddProduct = (Button) findViewById(R.id.addBtn);
        goToAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToAddProduct = new Intent(MainActivity.this, AddProductActivity.class);
                startActivityForResult(goToAddProduct, RequestCodes.START_TO_ADDPRODUCT);
            }
        });

        goToCheckout = (Button) findViewById(R.id.checkoutBtn);
        goToCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cart.getProducts().size() > 0) {

                    Intent goToCheckout = new Intent(MainActivity.this, CheckoutActivity.class);
                    goToCheckout.putExtra("cart", cart);
                    startActivityForResult(goToCheckout, RequestCodes.START_TO_CHECKOUT);

                } else {

                    displayAlertDialog();
                }
            }
        });

        cart = new ShoppingCart();
        displayProductList(cart);
        displayCartPrice(cart.getPrice());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == RequestCodes.START_TO_ADDPRODUCT) {

            if(resultCode == Activity.RESULT_OK){

                Product product = (Product) data.getSerializableExtra("product");
                cart.addProduct(product);
                displayProductList(cart);
                displayCartPrice(cart.getPrice());
            }
        }

        if (requestCode == RequestCodes.START_TO_CHECKOUT) {

            if(resultCode == Activity.RESULT_OK){

                cart.clearBasket();
                displayProductList(cart);
                displayCartPrice(cart.getPrice());
            }
        }
    }

    private void displayProductList(ShoppingCart cart) {
        TextView productList = (TextView) findViewById(R.id.productList);
        productList.setText(cart.toString());
    }

    private void displayCartPrice(double price) {
        TextView cartPrice = (TextView) findViewById(R.id.cartPrice);
        cartPrice.setText(FormatUtil.getIndentedPrice(price) + " € total");
    }

    private void displayAlertDialog() {

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("OOPS!");
        alertDialog.setMessage("You may need to add something to your cart before proceeding to check out!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
