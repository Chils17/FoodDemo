package com.example.chiragpatel.fooddemo.ui;


import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.chiragpatel.fooddemo.R;
import com.example.chiragpatel.fooddemo.adapter.MyCustomPagerAdapter;

import me.relex.circleindicator.CircleIndicator;

public class ProductActivity extends AppCompatActivity {
    private TextView txtTitle;
    private ViewPager viewPager;
    private MyCustomPagerAdapter myCustomPagerAdapter;
    int images[] = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
    private TextView txtItemName;
    private TextView txtPr;
    private TextView txtDesc;
    private TextView txtFullDesc;
    private String font = "Raleway-Regular.ttf";
    private String medium = "Raleway-Medium.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        //toolbar.setTitle("List Screen");
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(Color.WHITE);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init() {
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtItemName = (TextView) findViewById(R.id.txtItemName);
        txtPr = (TextView) findViewById(R.id.txtPr);
        txtDesc = (TextView) findViewById(R.id.txtDesc);
        txtFullDesc = (TextView) findViewById(R.id.txtFullDesc);

        txtTitle.setText("Product Items");

        Typeface tf = Typeface.createFromAsset(getApplicationContext().getResources().getAssets(), font);
        txtTitle.setTypeface(tf);
        txtFullDesc.setTypeface(tf);

        Typeface typeface = Typeface.createFromAsset(getApplicationContext().getResources().getAssets(), medium);
        txtItemName.setTypeface(typeface);
        txtDesc.setTypeface(typeface);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        myCustomPagerAdapter = new MyCustomPagerAdapter(ProductActivity.this, images);


        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        viewPager.setAdapter(myCustomPagerAdapter);
        indicator.setViewPager(viewPager);
    }
}
