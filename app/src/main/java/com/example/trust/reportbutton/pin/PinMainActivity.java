package com.example.trust.reportbutton.pin;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.trust.reportbutton.MainActivity;
import com.example.trust.reportbutton.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PinMainActivity extends AppCompatActivity {;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.login_buton)
    protected void onLoginClick(){
        startActivity(new Intent(this, MainActivity.class));
    }
}
