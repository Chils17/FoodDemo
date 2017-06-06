package com.example.chiragpatel.fooddemo.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chiragpatel.fooddemo.R;
import com.example.chiragpatel.fooddemo.adapter.MyAdapter;
import com.example.chiragpatel.fooddemo.helper.DividerItemDecoration;
import com.example.chiragpatel.fooddemo.model.User;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private SearchView mSearchView;
    private RecyclerView recyclerview;
    private MyAdapter myAdapter;
    private ArrayList<User> userList;
    private TextView emptyView;
    private ImageView imgMenu;
    private DrawerLayout mDrawerLayout;
    private LinearLayout lv;
    private ImageView imgClose;
    private TextView txtTitle;
    private String font = "Raleway-Regular.ttf";
    private String medium = "Raleway-Medium.ttf";
    private TextView txtProfile;
    private TextView txtInbox;
    private TextView txtLocation;
    private TextView txtFAQs;
    private TextView txtSettings;
    private TextView txtSign_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TextView) findViewById(R.id.txtTitle);

        // toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        //toolbar.setTitle("List Screen");
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(Color.WHITE);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtTitle.setText("List Screen");

        init();

        setTypeFace();

        setAdapter();

        clickListener();

    }

    private void init() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        lv = (LinearLayout) findViewById(R.id.lv);
        mSearchView = (SearchView) findViewById(R.id.search_view);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerView);
        emptyView = (TextView) findViewById(R.id.empty_view);
        imgMenu = (ImageView) findViewById(R.id.imgMenu);

        View headerView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.main_layout, null, false);
        lv.removeAllViews();
        lv.addView(headerView);

        imgClose = (ImageView) headerView.findViewById(R.id.imgClose);
        txtProfile = (TextView) headerView.findViewById(R.id.txtProfile);
        txtInbox = (TextView) headerView.findViewById(R.id.txtInbox);
        txtLocation = (TextView) headerView.findViewById(R.id.txtLocation);
        txtFAQs = (TextView) headerView.findViewById(R.id.txtFAQs);
        txtSettings = (TextView) headerView.findViewById(R.id.txtSettings);
        txtSign_out = (TextView) headerView.findViewById(R.id.txtSign_out);
    }

    private void setTypeFace() {
        Typeface tf = Typeface.createFromAsset(getApplicationContext().getResources().getAssets(), font);
        txtTitle.setTypeface(tf);

        Typeface typeface = Typeface.createFromAsset(getApplicationContext().getResources().getAssets(), medium);
        txtProfile.setTypeface(typeface);
        txtInbox.setTypeface(typeface);
        txtLocation.setTypeface(typeface);
        txtFAQs.setTypeface(typeface);
        txtSettings.setTypeface(typeface);
        txtSign_out.setTypeface(typeface);
    }


    private void clickListener() {
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.RIGHT);
            }
        });

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.closeDrawer(Gravity.RIGHT);
            }
        });
    }

    private void setAdapter() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerview.setHasFixedSize(true);


        setEmployeeList();


        myAdapter = new MyAdapter(this, userList);
        recyclerview.setAdapter(myAdapter);

        setupSearchView();
    }

    private void setEmployeeList() {
        userList = new ArrayList<>();

        userList.add(new User("Chirag", "1345-Abrama, Navsari"));
        userList.add(new User("Krishna", "981-monal, madhay"));
        userList.add(new User("Sagar", "345-godhra, Godhra"));
        userList.add(new User("Anis", "135-shusan, vadodara"));
        userList.add(new User("Ishan", "451-makarpura, baroda"));
        userList.add(new User("Vatsal", "545-subhanpura, baroda"));
        userList.add(new User("Gulam", "234-sakri, baroda"));
        userList.add(new User("Mehul", "675-vedch, bharuch"));
        userList.add(new User("Shailesh", "932-sayla, Surendranagar"));
        userList.add(new User("Ankur", "132-todi, Navsari"));

    }

    private void setupSearchView() {
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setQueryHint("Search");
    }

    @Override
    public boolean onQueryTextSubmit(String text) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        myAdapter.filter(newText);

        Log.e("tag", "myAdapter.getItemCount(): " + myAdapter.getItemCount());

        if (myAdapter.getItemCount() == 0) {
            recyclerview.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            recyclerview.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
