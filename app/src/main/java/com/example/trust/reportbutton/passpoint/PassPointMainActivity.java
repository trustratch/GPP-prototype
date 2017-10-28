package com.example.trust.reportbutton.passpoint;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.trust.reportbutton.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PassPointMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passpoint);
        ButterKnife.bind(this);
    }

   @OnClick(R.id.set_password_container)
    protected void onSetPasswordClick(){
       startActivity(new Intent(this, PassPointSetActivity.class));
   }

    @OnClick(R.id.enter_password_container)
    protected void onEnterPasswordClick(){
        startActivity(new Intent(this, PassPointPasswordActivity.class));
    }

}
