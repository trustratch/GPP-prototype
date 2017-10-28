package com.example.trust.reportbutton.passpoint;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.trust.reportbutton.PasswordObject;
import com.example.trust.reportbutton.R;
import com.example.trust.reportbutton.recyclerview.PasswordItemAdapter;

import java.util.HashMap;
import java.util.Objects;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.example.trust.reportbutton.SharedKey.SHARED_PREF_KEY;
import static com.example.trust.reportbutton.SharedKey.SHARED_PREF_ORDER_KEY;
import static com.example.trust.reportbutton.SharedKey.SHARED_PREF_PASSWORD_KEY;

public class PassPointPasswordActivity extends AppCompatActivity implements PasswordItemAdapter.OnPasswordClickListener {

    @Bind(R.id.password_recyclerview)
    RecyclerView pinRecyclerView;


    private HashMap<String, String> passwordHashMap = new HashMap<>();
    private int count = 0;
    private int correctCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        setupPinRecyclerView();
        createHashMap();
    }

    private void setupPinRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 10, GridLayoutManager.VERTICAL, false) {
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

    private void createHashMap() {
        String[] passwordArray = getSharedPrefValue(SHARED_PREF_PASSWORD_KEY).split("-");
        for (int i = 0; i <= 3; i++) {
            passwordHashMap.put(String.valueOf(i + 1), passwordArray[i]);
        }
    }

    private String getSharedPrefValue(String key) {
        SharedPreferences pref = this.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE);
        return pref.getString(key, "");
    }

    @Override
    public void onPasswordClick(PasswordObject passwordObject) {
        count++;
        boolean isCorrect = Objects.equals(passwordHashMap.get(String.valueOf(count)), passwordObject.getValue());
        if (isCorrect) {
            correctCount++;
        }

        if (count == 4) {
            if (correctCount == 4) {
                Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "WRONG!", Toast.LENGTH_SHORT).show();
                count = 0;
                correctCount = 0;
            }
        }

    }
}
