package com.example.chiragpatel.fooddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_signin;
    private Button btn_search;
    private Button btn_item;
    private Button btn_hotel;

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
        btn_item.setOnClickListener(this);
        btn_hotel.setOnClickListener(this);
    }

    private void init() {
        btn_signin=(Button)findViewById(R.id.btn_signin);
        btn_search=(Button)findViewById(R.id.btn_search);
        btn_item=(Button)findViewById(R.id.btn_item);
        btn_hotel=(Button)findViewById(R.id.btn_hotel);
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

            /*case R.id.btn_order:
                Intent intentOrder =new Intent(getApplicationContext(),OrderActivity.class);
                startActivity(intentOrder);
                break;

            case R.id.btn_item:
                Intent intentItem =new Intent(getApplicationContext(),FoodItemActivity.class);
                startActivity(intentItem);
                break;

            case R.id.btn_hotel:
                Intent intenthotel =new Intent(getApplicationContext(),HotelActivity.class);
                startActivity(intenthotel);
                break;*/
        }
    }
}
