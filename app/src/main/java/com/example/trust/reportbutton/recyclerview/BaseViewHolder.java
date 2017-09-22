package com.example.trust.reportbutton.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;



public class BaseViewHolder extends RecyclerView.ViewHolder {

    private View view;

    public BaseViewHolder(View view) {
        super(view);
        this.view = view;
        ButterKnife.bind(this,view);
    }

    public View getView(){
        return this.view;
    }

}
