package com.example.trust.reportbutton.passface;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.trust.reportbutton.PasswordObject;
import com.example.trust.reportbutton.R;
import com.example.trust.reportbutton.recyclerview.PassFaceItemAdapter;
import com.example.trust.reportbutton.recyclerview.PasswordItemAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.example.trust.reportbutton.SharedKey.SHARED_PREF_KEY;
import static com.example.trust.reportbutton.SharedKey.SHARED_PREF_PASSFACE_KEY;
import static com.example.trust.reportbutton.SharedKey.SHARED_PREF_PASSWORD_KEY;

public class PassFacePasswordActivity extends AppCompatActivity implements PassFaceItemAdapter.OnPasswordClickListener {

    @Bind(R.id.password_recyclerview)
    RecyclerView pinRecyclerView;

    private int count = 0;
    private String password = "";

    private static final int PASSWORD_LENGTH = 4;

    ArrayList<Integer> guessList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passface );
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        setupPinRecyclerView();
        createPassword();
    }

    private void setupPinRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5, GridLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        PassFaceItemAdapter passwordItemAdapter = new PassFaceItemAdapter();
        passwordItemAdapter.setOnPasswordClickListener(this);
        pinRecyclerView.setLayoutManager(gridLayoutManager);
        pinRecyclerView.setAdapter(passwordItemAdapter);
    }

    private void createPassword() {
        String[] passwordArray = getSharedPrefValue(SHARED_PREF_PASSFACE_KEY).split("-");
        ArrayList<Integer> passwordList = new ArrayList<>();
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            passwordList.add(Integer.parseInt(passwordArray[i]));
        }
        Collections.sort(passwordList);
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            password = password + "" + passwordList.get(i);
        }
    }

    private String getSharedPrefValue(String key) {
        SharedPreferences pref = this.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE);
        return pref.getString(key, "");
    }

    @Override
    public void onPasswordClick(PassFacePasswordPicture passwordObject) {
        count++;
        guessList.add(passwordObject.getValue());
        if (count == PASSWORD_LENGTH) {
            String guess = "";
            Collections.sort(guessList);
            for (int i = 0; i < PASSWORD_LENGTH; i++) {
                guess = guess + "" + guessList.get(i);
            }
            if (Objects.equals(guess, password)) {
                Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "WRONG!", Toast.LENGTH_SHORT).show();
                count = 0;
                guessList.clear();
            }
        }

    }
}
