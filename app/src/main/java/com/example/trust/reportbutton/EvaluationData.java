package com.example.trust.reportbutton;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class EvaluationData {

    private String value;
    private String description;
    private int color;
    private boolean isSelected;


    public EvaluationData() {

    }

    public static EvaluationData PROXY() {
        EvaluationData proxy = new EvaluationData();
        proxy.setValue("");
        proxy.setDescription("");
        proxy.setColor(1);
        return proxy;
    }

    public EvaluationData(String value, String description, int color) {
        this.value = value;
        this.description = description;
        this.color = color;
        this.isSelected = false;
    }

    public static List<EvaluationData> getDefualt(Context context) {
        ArrayList<EvaluationData> evaluationDataArrayList = new ArrayList<>();
        evaluationDataArrayList.add(new EvaluationData("1", "Unacceptable", context.getResources().getColor(R.color.pdf_file_bg)));
        evaluationDataArrayList.add(new EvaluationData("2", "Fair", context.getResources().getColor(R.color.group_unlock)));
        evaluationDataArrayList.add(new EvaluationData("3", "Good", context.getResources().getColor(R.color.vibrant_green)));
        evaluationDataArrayList.add(new EvaluationData("4", "Beyond", context.getResources().getColor(R.color.excel_file_bg)));
        evaluationDataArrayList.add(new EvaluationData("5", "Ultimate", context.getResources().getColor(R.color.word_file_bg)));
        evaluationDataArrayList.add(new EvaluationData("6", "ass", context.getResources().getColor(R.color.text_file_bg)));
        evaluationDataArrayList.add(new EvaluationData("7", "what", context.getResources().getColor(R.color.audio_file_bg)));
        evaluationDataArrayList.add(new EvaluationData("8", "fat", context.getResources().getColor(R.color.group_unlock)));
        evaluationDataArrayList.add(new EvaluationData("9", "tood", context.getResources().getColor(R.color.zip_file_bg)));

        return evaluationDataArrayList;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
