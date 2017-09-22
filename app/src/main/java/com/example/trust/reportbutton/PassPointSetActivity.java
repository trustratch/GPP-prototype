package com.example.trust.reportbutton;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.trust.reportbutton.recyclerview.PasswordItemAdapter;

import java.util.Objects;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.example.trust.reportbutton.SharedKey.SHARED_PREF_KEY;
import static com.example.trust.reportbutton.SharedKey.SHARED_PREF_PASSWORD_KEY;

public class PassPointSetActivity extends AppCompatActivity implements PasswordItemAdapter.OnPasswordClickListener{

    @Bind(R.id.password_recyclerview)
    RecyclerView pinRecyclerView;

    private int clickCount = 0;
    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        setupPinRecyclerView();
        Toast.makeText(this, "Set Password", Toast.LENGTH_SHORT).show();
    }

    private void setupPinRecyclerView(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 10 ,GridLayoutManager.VERTICAL, false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        PasswordItemAdapter passwordItemAdapter = new PasswordItemAdapter();
        passwordItemAdapter.setOnPasswordClickListener(this);
        pinRecyclerView.setLayoutManager(gridLayoutManager);
        pinRecyclerView.setAdapter(passwordItemAdapter);
    }

    @Override
    public void onPasswordClick(PasswordObject passwordObject) {
        clickCount++;
        if (Objects.equals(password, "")) {
            password = password + passwordObject.getValue();
        } else {
            password = password + "-" + passwordObject.getValue();
        }
        if (clickCount == 4) {
            savePassword(password);
            Toast.makeText(this, getPassword(), Toast.LENGTH_SHORT).show();
            clickCount = 0;
            password = "";
            startActivity(new Intent(this, PassPointPasswordActivity.class));
            finish();
        }
    }

    private void savePassword(String password) {
        SharedPreferences pref = this.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE);
        pref.edit().putString(SHARED_PREF_PASSWORD_KEY, password).apply();
    }

    private String getPassword(){
        SharedPreferences pref = this.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE);
        return pref.getString(SHARED_PREF_PASSWORD_KEY,"");
    }
}
