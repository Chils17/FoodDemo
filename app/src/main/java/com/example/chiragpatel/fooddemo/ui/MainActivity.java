package com.example.chiragpatel.fooddemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chiragpatel.fooddemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_signin;
    private Button btn_search;
    private Button btn_shop;
    private Button btn_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        clickListener();
    }

    private void clickListener() {
        btn_signin.setOnClickListener(this);
        btn_search.setOnClickListener(this);
        btn_shop.setOnClickListener(this);
        btn_product.setOnClickListener(this);
    }

    private void init() {
        btn_signin=(Button)findViewById(R.id.btn_signin);
        btn_search=(Button)findViewById(R.id.btn_search);
        btn_shop=(Button)findViewById(R.id.btn_shop);
        btn_product=(Button)findViewById(R.id.btn_product);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_signin:
                Intent intentSign =new Intent(getApplicationContext(),SignActivity.class);
                startActivity(intentSign);
                break;

            case R.id.btn_search:
                Intent intentSearch =new Intent(getApplicationContext(),ListActivity.class);
                startActivity(intentSearch);
                break;

            case R.id.btn_shop:
                Intent intentOrder =new Intent(getApplicationContext(),ShopActivity.class);
                startActivity(intentOrder);
                break;

            case R.id.btn_product:
                Intent intentItem =new Intent(getApplicationContext(),ProductActivity.class);
                startActivity(intentItem);
                break;

        }
    }
}
