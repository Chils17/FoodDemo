package com.example.chiragpatel.fooddemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView txtTitle=(TextView)findViewById(R.id.txtTitle);

        // toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        //toolbar.setTitle("List Screen");
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(Color.WHITE);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtTitle.setText("List Screen");

        init();

        setAdapter();

        clickListener();

    }


    private void init() {
        mSearchView = (SearchView) findViewById(R.id.search_view);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerView);
        emptyView = (TextView) findViewById(R.id.empty_view);
        imgMenu = (ImageView) findViewById(R.id.imgMenu);

    }

    private void clickListener() {
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CustomDrawerActivity.class);
                startActivity(intent);
                finish();
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
        userList.add(new User("Anis",  "135-shusan, vadodara"));
        userList.add(new User("Ishan","451-makarpura, baroda"));
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
