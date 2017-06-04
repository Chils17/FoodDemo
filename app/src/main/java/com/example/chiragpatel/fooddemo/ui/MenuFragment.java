package com.example.chiragpatel.fooddemo.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.chiragpatel.fooddemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {
    private ImageView imgClose;


    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        imgClose = (ImageView) view.findViewById(R.id.imgClose);

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ListActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

}
