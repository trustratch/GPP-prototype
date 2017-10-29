package com.example.trust.reportbutton.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.trust.reportbutton.PasswordObject;
import com.example.trust.reportbutton.R;
import com.example.trust.reportbutton.passface.PassFacePasswordPicture;

import java.util.ArrayList;

import butterknife.Bind;


public class PassFaceItemAdapter extends
        RecyclerView.Adapter<PassFaceItemAdapter.ViewHolder> {

    private ArrayList<PassFacePasswordPicture> passwordObjects = new ArrayList<>();
    private OnPasswordClickListener listener;


    public PassFaceItemAdapter() {
        passwordObjects = PassFacePasswordPicture.createPassword();
    }

    public void setOnPasswordClickListener(OnPasswordClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.passface_recylcerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Context context = holder.getView().getContext();
        holder.imageView.setImageResource(passwordObjects.get(position).getDrawableRes());
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
        void onPasswordClick(PassFacePasswordPicture passwordObject);
    }

    public class ViewHolder extends BaseViewHolder {
        @Bind(R.id.parent)
        View parent;

        @Bind(R.id.passface_image_view)
        ImageView imageView;

        public ViewHolder(View view) {
            super(view);
        }

    }

}
