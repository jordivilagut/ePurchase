package com.jordivilagut.epurchase;

import android.app.Activity;
import android.content.Intent;
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

                if(isValid(fieldName) && isValid(fieldPrice)) {
                    String name = fieldName.getText().toString();
                    double price = Double.valueOf(fieldPrice.getText().toString());
                    Product product = new Product(name, price);

                    addProduct.putExtra("product", product);
                    setResult(Activity.RESULT_OK, addProduct);
                    finish();
                }
            }
        });
    }

    private boolean isValid(EditText field) {
        if(field.getText().toString().equals("")) {
            return false;
        } else {
            return true;
        }
    }
}
