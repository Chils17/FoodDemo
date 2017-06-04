package com.example.chiragpatel.fooddemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chiragpatel.fooddemo.R;
import com.example.chiragpatel.fooddemo.model.Food;
import com.example.chiragpatel.fooddemo.model.User;

import java.util.ArrayList;

import static com.example.chiragpatel.fooddemo.R.id.txtAddress;
import static com.example.chiragpatel.fooddemo.R.id.txtName;

/**
 * Created by chiragpatel on 04/06/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Food> foodArrayList;
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<Food> foodArrayList) {
        this.context = context;
        this.foodArrayList = foodArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.imgView.setImageResource(foodArrayList.get(position).getImg());
        itemViewHolder.textName.setText(foodArrayList.get(position).getName());
        itemViewHolder.txtPrice.setText(foodArrayList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgView;
        private TextView textName;
        private TextView txtPrice;

        public ItemViewHolder(View view) {
            super(view);
            imgView = (ImageView) view.findViewById(R.id.imgView);
            textName = (TextView) view.findViewById(R.id.textName);
            txtPrice = (TextView) view.findViewById(R.id.txtPrice);
        }
    }
}
