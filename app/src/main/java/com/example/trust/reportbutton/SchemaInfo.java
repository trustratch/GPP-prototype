package com.example.trust.reportbutton;


import android.content.Context;
import android.support.annotation.DrawableRes;

import com.example.trust.reportbutton.openpassgo.PassGoMainActivity;
import com.example.trust.reportbutton.passpoint.PassPointMainActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class SchemaInfo implements Serializable {

    private String name;
    private String description;
    private String details;
    @DrawableRes
    private int imageRes;
    private String videoUrl;
    private Class activityClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Class getActivityClass() {
        return activityClass;
    }

    public void setActivity(Class activityClass) {
        this.activityClass = activityClass;
    }

    public static ArrayList<SchemaInfo> create(Context context){
        ArrayList<SchemaInfo> schemaInfos = new ArrayList<>();
        schemaInfos.add(createPassGo(context));
        schemaInfos.add(createPassPoint(context));
        schemaInfos.add(createPhotographicAuthen(context));
        return schemaInfos;
    }

    private static SchemaInfo createPassGo(Context context){
        SchemaInfo passgo = new SchemaInfo();
        passgo.setName("Pass Go");
        passgo.setDescription(context.getString(R.string.large_text));
        passgo.setDetails(context.getString(R.string.large_text));
        passgo.setActivity(PassGoMainActivity.class);
        passgo.setImageRes(R.drawable.passgo);
        return passgo;
    }

    private static SchemaInfo createPassPoint(Context context){
        SchemaInfo passgo = new SchemaInfo();
        passgo.setName("Pass Point");
        passgo.setDescription(context.getString(R.string.large_text));
        passgo.setDetails(context.getString(R.string.large_text));
        passgo.setActivity(PassPointMainActivity.class);
        passgo.setImageRes(R.drawable.photographer);
        return passgo;
    }

    private static SchemaInfo createPhotographicAuthen(Context context){
        SchemaInfo passgo = new SchemaInfo();
        passgo.setName("Photographic Authentication");
        passgo.setDescription(context.getString(R.string.large_text));
        passgo.setDetails(context.getString(R.string.large_text));
        passgo.setActivity(PassPointMainActivity.class);
        passgo.setImageRes(R.drawable.photographer);
        return passgo;
    }

}
