package com.example.chiragpatel.fooddemo.ui;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.chiragpatel.fooddemo.R;

public class SignActivity extends AppCompatActivity {

    private TextView txtTitle;
    private TextView txtUi;
    private TextView btn_login;
    private TextView txtForgetPassword;
    private TextView txtLoginWith;
    private TextView txtFb;
    private TextView txtTw;
    private String font = "Raleway-Regular.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        init();

        setTypeFace();
    }

    private void init() {
        txtTitle=(TextView)findViewById(R.id.txtTitle);
        txtUi=(TextView)findViewById(R.id.txtUi);
        btn_login=(TextView)findViewById(R.id.btn_login);
        txtForgetPassword=(TextView)findViewById(R.id.txtForgetPassword);
        txtLoginWith=(TextView)findViewById(R.id.txtLoginWith);
        txtFb=(TextView)findViewById(R.id.txtFb);
        txtTw=(TextView)findViewById(R.id.txtTw);
    }

    private void setTypeFace() {
        Typeface tf = Typeface.createFromAsset(getApplicationContext().getResources().getAssets(), font);
        txtTitle.setTypeface(tf);
        txtUi.setTypeface(tf);
        btn_login.setTypeface(tf);
        txtForgetPassword.setTypeface(tf);
        txtFb.setTypeface(tf);
        txtTw.setTypeface(tf);
    }
}
