package com.example.trust.reportbutton.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.trust.reportbutton.PasswordObject;
import com.example.trust.reportbutton.R;

import java.util.ArrayList;

import butterknife.Bind;


public class PassFaceItemAdapter extends
        RecyclerView.Adapter<PassFaceItemAdapter.ViewHolder> {

    protected static final int[] ORIGINAL_PICTURES = { R.drawable.d1,
            R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5,
            R.drawable.d6, R.drawable.d7, R.drawable.d8, R.drawable.d9,
            R.drawable.d10, R.drawable.d11, R.drawable.d12, R.drawable.d13,
            R.drawable.d14, R.drawable.d15, R.drawable.d16, R.drawable.d17,
            R.drawable.d18, R.drawable.d19, R.drawable.d20, R.drawable.d21,
            R.drawable.d22, R.drawable.d23, R.drawable.d24, R.drawable.d25,
            R.drawable.d26, R.drawable.d27 , R.drawable.d28, R.drawable.d29,
            R.drawable.d30, R.drawable.d31, R.drawable.d32, R.drawable.d33,
            R.drawable.d34, R.drawable.d35, R.drawable.d36, R.drawable.d37,
            R.drawable.d38, R.drawable.d39, R.drawable.d40, R.drawable.d41,
            R.drawable.d42, R.drawable.d43, R.drawable.d44, R.drawable.d45,
            R.drawable.d46, R.drawable.d47, R.drawable.d48, R.drawable.d49,
            R.drawable.d50, R.drawable.d51, R.drawable.d52, R.drawable.d53,
            R.drawable.d54, R.drawable.d55, R.drawable.d56, R.drawable.d57,
            R.drawable.d58, R.drawable.d59, R.drawable.d60, R.drawable.d61,
            R.drawable.d62, R.drawable.d63, R.drawable.d64, R.drawable.d65,
            R.drawable.d66, R.drawable.d67, R.drawable.d68, R.drawable.d69,
            R.drawable.d70
    };

    private ArrayList<PasswordObject> passwordObjects = new ArrayList<>();
    private OnPasswordClickListener listener;


    public PassFaceItemAdapter() {
        for (int i = 0 ; i < 70 ; i++){
            passwordObjects.add(new PasswordObject(String.valueOf(i)));
        }
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
        holder.imageView.setImageResource(ORIGINAL_PICTURES[position]);
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
