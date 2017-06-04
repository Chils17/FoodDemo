package com.example.chiragpatel.fooddemo.ui;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chiragpatel.fooddemo.R;
import com.example.chiragpatel.fooddemo.adapter.MyCustomPagerAdapter;

import me.relex.circleindicator.CircleIndicator;

public class ProductActivity extends AppCompatActivity {
    private TextView txtTitle;
    private ViewPager viewPager;
    private MyCustomPagerAdapter myCustomPagerAdapter;
    int images[] = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        init();
    }

    private void init() {
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText("Product Items");

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        myCustomPagerAdapter = new MyCustomPagerAdapter(ProductActivity.this, images);


        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        viewPager.setAdapter(myCustomPagerAdapter);
        indicator.setViewPager(viewPager);
    }
}
