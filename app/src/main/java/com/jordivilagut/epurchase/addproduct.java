package com.jordivilagut.epurchase;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddProduct extends AppCompatActivity {

    Button addProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproduct);

        addProduct = (Button) findViewById(R.id.addBtn);
        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addProduct = new Intent(AddProduct.this, MainActivity.class);
                Product duck = new Product("duck", 200);
                addProduct.putExtra("newProduct", duck);
                setResult(Activity.RESULT_OK, addProduct);
                finish();
            }
        });
    }
}
