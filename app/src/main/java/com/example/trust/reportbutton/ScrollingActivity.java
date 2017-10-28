package com.example.trust.reportbutton;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScrollingActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Bind(R.id.cover_imageview)
    ImageView coverImageview;

    private SchemaInfo schemaInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        this.schemaInfo = (SchemaInfo) getIntent().getSerializableExtra("Data");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setTitle(schemaInfo.getName());
        coverImageview.setImageResource(schemaInfo.getImageRes());
    }

    @OnClick(R.id.fab)
    protected void onFabClick(){
        Class clazz = schemaInfo.getActivityClass();
        startActivity(new Intent(this, clazz));
    }

}
