package com.example.trust.reportbutton;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.trust.reportbutton.recyclerview.PinItemAdapter;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

   @OnClick(R.id.set_password_container)
    protected void onSetPasswordClick(){
       startActivity(new Intent(this, SetPasswordActivity.class));
   }

    @OnClick(R.id.enter_password_container)
    protected void onEnterPasswordClick(){
        startActivity(new Intent(this, PinActivity.class));
    }
}
