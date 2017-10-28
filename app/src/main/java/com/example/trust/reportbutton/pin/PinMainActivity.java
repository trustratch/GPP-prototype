package com.example.trust.reportbutton.pin;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.trust.reportbutton.R;
import com.github.omadahealth.lollipin.lib.managers.AppLock;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PinMainActivity extends AppCompatActivity {;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passpoint);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.set_password_container)
    protected void onSetPasswordClick(){
        Intent intent = new Intent(this, PinActivity.class);
        intent.putExtra(AppLock.EXTRA_TYPE, AppLock.ENABLE_PINLOCK);
        startActivity(intent);
    }

    @OnClick(R.id.enter_password_container)
    protected void onEnterPasswordClick(){
        Intent intent = new Intent(this, PinActivity.class);
        startActivity(intent);
    }

}
