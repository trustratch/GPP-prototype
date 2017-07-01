package com.example.trust.reportbutton.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.trust.reportbutton.EvaluationData;
import com.example.trust.reportbutton.KpiBarDB;
import com.example.trust.reportbutton.PasswordObject;
import com.example.trust.reportbutton.R;

import java.util.Collections;
import java.util.List;

import butterknife.Bind;


public class PinItemAdapter extends
        RecyclerView.Adapter<PinItemAdapter.ViewHolder> {

    private List<EvaluationData> evaluationDataList;
    private OnPinClickListener onPinClickListener;

    public PinItemAdapter(List<EvaluationData> evaluationDataList) {
        Collections.shuffle(evaluationDataList);
        this.evaluationDataList = evaluationDataList;
    }

    public void setOnPinClickListener(OnPinClickListener onPinClickListener) {
        this.onPinClickListener = onPinClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pin_recylcerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final EvaluationData item = evaluationDataList.get(position);
        Context context = holder.getView().getContext();
        holder.textView.setText(item.getValue());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onPinClickListener != null) {
                    onPinClickListener.onPinClick(item);
                }
                Collections.shuffle(evaluationDataList);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return evaluationDataList != null ? evaluationDataList.size() : 0;
    }

    public interface OnPinClickListener{
        void onPinClick(EvaluationData evaluationData);
    }


    public class ViewHolder extends EkoViewHolder {
        @Bind(R.id.pin_item_textview)
        TextView textView;
        @Bind(R.id.parent)
        View parent;

        public ViewHolder(View view) {
            super(view);
        }

    }

}
