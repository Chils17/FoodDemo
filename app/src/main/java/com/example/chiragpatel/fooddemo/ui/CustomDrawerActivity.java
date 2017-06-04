package com.example.chiragpatel.fooddemo.ui;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.chiragpatel.fooddemo.R;

public class CustomDrawerActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private LinearLayout navLinear;
    private ImageView imgClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        imgClose = (ImageView) findViewById(R.id.imgClose);

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
                finish();
            }
        });

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        //setFragment(HomeFragment.newInstance());

        ActionBarDrawerToggle toggle = new
                ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        navLinear = (LinearLayout) findViewById(R.id.nav);

        //navLinear.setOnClickListener(this);

        View headerView = LayoutInflater.from(this).inflate(R.layout.main_layout, null, false);
        navLinear.removeAllViews();
        navLinear.addView(headerView);*/
    }
}
