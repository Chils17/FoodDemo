package com.example.chiragpatel.fooddemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chiragpatel.fooddemo.R;
import com.example.chiragpatel.fooddemo.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiragpatel on 01/06/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<User> userList, filterList;
    private Context context;

    public MyAdapter(Context context, List<User> userList) {
        this.userList = userList;
        this.context = context;
        this.filterList = new ArrayList<User>();
        this.filterList.addAll(userList);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setValues(filterList.get(position));

    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public void filter(final String text) {

        filterList.clear();

        if (TextUtils.isEmpty(text)) {

            filterList.addAll(userList);

        } else {

            Log.e("tag", "text:" + text);

            for (User user : userList) {
                if (user.getName().toLowerCase().contains(text.toLowerCase()) ||
                        user.getAddress().toLowerCase().contains(text.toLowerCase())) {

                    filterList.add(user);
                    Log.e("tag", "filterList:" + filterList);
                }
            }
        }

        notifyDataSetChanged();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private TextView txtAddress;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtAddress = (TextView) itemView.findViewById(R.id.txtAddress);
        }

        public void setValues(User user) {
            Log.e("data", user.getName());
            txtName.setText(user.getName());
            txtAddress.setText(user.getAddress());

        }
    }
}
