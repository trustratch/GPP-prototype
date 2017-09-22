package com.example.trust.reportbutton;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.trust.reportbutton.recyclerview.PinItemAdapter;

import java.util.Objects;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.example.trust.reportbutton.SharedKey.SHARED_PREF_KEY;
import static com.example.trust.reportbutton.SharedKey.SHARED_PREF_ORDER_KEY;

public class PinActivity extends AppCompatActivity  implements PinItemAdapter.OnPinClickListener{

    @Bind(R.id.pin_recyclerview)
    RecyclerView pinRecyclerView;

    private int pinCount = 0;
    private String order = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        setupPinRecyclerView();
    }

    private void setupPinRecyclerView(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3 ,GridLayoutManager.VERTICAL, false);
        PinItemAdapter barChartItemAdapter = new PinItemAdapter(EvaluationData.getDefualt(this));
        barChartItemAdapter.setOnPinClickListener(this);
        pinRecyclerView.setLayoutManager(gridLayoutManager);
        pinRecyclerView.setAdapter(barChartItemAdapter);
    }

    @Override
    public void onPinClick(EvaluationData evaluationData) {
        pinCount++;
        if (Objects.equals(order, "")) {
            order = order + evaluationData.getValue();
        } else {
            order = order + "-" + evaluationData.getValue();
        }

        if (pinCount == 4) {
            saveOrder(order);
            Toast.makeText(this, getOrder(), Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, PassPointPasswordActivity.class));
            finish();
        }
    }

    private void saveOrder(String password) {
        SharedPreferences pref = this.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE);
        pref.edit().putString(SHARED_PREF_ORDER_KEY, password).apply();
    }

    private String getOrder(){
        SharedPreferences pref = this.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE);
        return pref.getString(SHARED_PREF_ORDER_KEY,"");
    }
}
