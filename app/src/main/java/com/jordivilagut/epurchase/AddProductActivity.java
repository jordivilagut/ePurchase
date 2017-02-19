package com.jordivilagut.epurchase;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddProductActivity extends AppCompatActivity {

    Button addProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproduct);

        addProduct = (Button) findViewById(R.id.addBtn);
        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addProduct = new Intent(AddProductActivity.this, MainActivity.class);

                EditText fieldName = (EditText) findViewById(R.id.name);
                EditText fieldPrice = (EditText) findViewById(R.id.price);

                if(isWord(fieldName) && isNumeric(fieldPrice)) {
                    String name = fieldName.getText().toString();
                    double price = Double.valueOf(fieldPrice.getText().toString());
                    Product product = new Product(name, price);

                    addProduct.putExtra("product", product);
                    setResult(Activity.RESULT_OK, addProduct);
                    finish();
                } else {
                    displayAlertDialog();
                }
            }
        });
    }

    private boolean isWord(EditText field) {
        String wordRegex = "^[a-zA-Z]+$";
        String text = field.getText().toString();

        if(text.matches(wordRegex)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isNumeric(EditText field) {
        String numericRegex = "\\d+(?:\\.\\d+)?";
        String text = field.getText().toString();

        if(text.matches(numericRegex)) {
            return true;
        } else {
            return false;
        }
    }

    private void displayAlertDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(AddProductActivity.this).create();
        alertDialog.setTitle("ERROR");
        alertDialog.setMessage("Please fill out all the fields to register a new product.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
