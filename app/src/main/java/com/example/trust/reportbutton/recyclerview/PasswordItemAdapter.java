package com.example.trust.reportbutton.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trust.reportbutton.EvaluationData;
import com.example.trust.reportbutton.PasswordObject;
import com.example.trust.reportbutton.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;


public class PasswordItemAdapter extends
        RecyclerView.Adapter<PasswordItemAdapter.ViewHolder> {

    private ArrayList<PasswordObject> passwordObjects = new ArrayList<>();
    private OnPasswordClickListener listener;


    public PasswordItemAdapter() {
        for (int i = 0 ; i <= 120 ; i++){
            passwordObjects.add(new PasswordObject(String.valueOf(i)));
        }
    }

    public void setOnPasswordClickListener(OnPasswordClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.password_recylcerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Context context = holder.getView().getContext();
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onPasswordClick(passwordObjects.get(position));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return passwordObjects.size();
    }

    public interface OnPasswordClickListener{
        void onPasswordClick(PasswordObject passwordObject);
    }

    public class ViewHolder extends EkoViewHolder {
        @Bind(R.id.parent)
        View parent;

        public ViewHolder(View view) {
            super(view);
        }

    }

}
