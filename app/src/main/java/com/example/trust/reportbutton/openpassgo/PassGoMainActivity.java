package com.example.trust.reportbutton.openpassgo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.trust.reportbutton.R;
import com.example.trust.reportbutton.openpassgo.PassGoCreatePasswordActivity;
import com.example.trust.reportbutton.openpassgo.PassGoLoginActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PassGoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passpoint);
        ButterKnife.bind(this);
    }

   @OnClick(R.id.set_password_container)
    protected void onSetPasswordClick(){
       startActivity(new Intent(this, PassGoCreatePasswordActivity.class));
   }

    @OnClick(R.id.enter_password_container)
    protected void onEnterPasswordClick(){
        startActivity(new Intent(this, PassGoLoginActivity.class));
    }

}
