package com.example.chiragpatel.fooddemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.chiragpatel.fooddemo.R;
import com.example.chiragpatel.fooddemo.adapter.RecyclerViewAdapter;
import com.example.chiragpatel.fooddemo.model.Food;
import com.example.chiragpatel.fooddemo.model.User;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Food> foodArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView txtTitle=(TextView)findViewById(R.id.txtTitle);

        // toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        //toolbar.setTitle("List Screen");
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(Color.WHITE);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtTitle.setText("Shop");

        init();

        setRecyclerView();
    }


    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    }

    private void setRecyclerView() {

        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 2);

        recyclerView.setLayoutManager(manager);

        foodArrayList = new ArrayList<>();

        foodArrayList.add(new Food(R.drawable.img1,"Picnic Cupcakes", "$5"));
        foodArrayList.add(new Food(R.drawable.img2,"Grill Barbecue", "$25"));
        foodArrayList.add(new Food(R.drawable.img3,"Healthy Pasta", "$5"));
        foodArrayList.add(new Food(R.drawable.img4,"Morning Breakfast", "$25"));
        foodArrayList.add(new Food(R.drawable.img1,"Vada Pav", "$5"));
        foodArrayList.add(new Food(R.drawable.img2,"Dabeli", "$25"));
        foodArrayList.add(new Food(R.drawable.img3,"Pizza", "$5"));
        foodArrayList.add(new Food(R.drawable.img4,"Burger", "$25"));


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getApplicationContext(), foodArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
}
