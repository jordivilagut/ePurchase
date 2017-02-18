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
                String name = fieldName.getText().toString();
                String price = fieldPrice.getText().toString();


                if (name.equals("") || price.equals("")) {

                } else {
                    Product product = new Product(name, Double.valueOf(price));
                    addProduct.putExtra("product", product);
                    setResult(Activity.RESULT_OK, addProduct);
                    finish();
                }
            }
        });
    }
}
