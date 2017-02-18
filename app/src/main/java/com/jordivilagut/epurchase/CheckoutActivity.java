package com.jordivilagut.epurchase;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        checkout = (Button)findViewById(R.id.checkoutBtn);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = createAlertDialog();
                alertDialog.show();
            }
        });

        ShoppingCart cart = (ShoppingCart) getIntent().getSerializableExtra("cart");
        displayCartPrice(cart);
    }

    private void displayCartPrice(ShoppingCart cart) {

        TextView cartPrice = (TextView) findViewById(R.id.cartPrice);
        cartPrice.setText(cart.getCartPrice() +" € total");
    }

    private AlertDialog createAlertDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(CheckoutActivity.this).create();
        alertDialog.setTitle("TRANSACTION COMPLETED");
        alertDialog.setMessage("Thank you for trusting ePurchase.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finishActivity();
                    }
                });
        return alertDialog;
    }

    private void finishActivity() {
        Intent checkout = new Intent(CheckoutActivity.this, MainActivity.class);
        setResult(Activity.RESULT_OK, checkout);
        finish();
    }
}
