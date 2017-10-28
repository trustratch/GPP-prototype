package com.example.trust.reportbutton.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trust.reportbutton.PasswordObject;
import com.example.trust.reportbutton.R;
import com.example.trust.reportbutton.SchemaInfo;
import com.example.trust.reportbutton.ScrollingActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;


public class CardItemAdapter extends
        RecyclerView.Adapter<CardItemAdapter.ViewHolder> {

    private ArrayList<SchemaInfo> schemaInfos = new ArrayList<>();

    public CardItemAdapter(Context context) {
        schemaInfos = SchemaInfo.create(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Context context = holder.getView().getContext();
        final SchemaInfo schemaInfo = schemaInfos.get(position);
        holder.titleTextView.setText(schemaInfo.getName());
        holder.descriptionTextView.setText(schemaInfo.getDescription());
        holder.imageView.setImageResource(schemaInfo.getImageRes());
    }

    @Override
    public int getItemCount() {
        return schemaInfos.size();
    }

    public interface OnPasswordClickListener {
        void onPasswordClick(PasswordObject passwordObject);
    }

    public class ViewHolder extends BaseViewHolder {
        @Bind(R.id.card_image_imageview)
        ImageView imageView;
        @Bind(R.id.card_description_textview)
        TextView descriptionTextView;
        @Bind(R.id.card_image_title_textview)
        TextView titleTextView;

        @OnClick(R.id.card_parent_view)
        protected void onCardClick() {
            Intent intent = new Intent(getView().getContext(), ScrollingActivity.class);
            intent.putExtra("Data", schemaInfos.get(getAdapterPosition()));
            getView().getContext().startActivity(intent);
        }

        public ViewHolder(View view) {
            super(view);
        }

    }

}
