package com.leinardi.dagger2mvp.ui.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.leinardi.dagger2mvp.R;
import com.leinardi.dagger2mvp.model.Hit;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by leinardi on 12/07/16.
 */

public class HitRecyclerViewAdapter extends RecyclerView.Adapter<HitRecyclerViewAdapter.ViewHolder> {

    private final List<Hit> mValues;
    private OnItemClickListener mListener;

    public HitRecyclerViewAdapter(List<Hit> items, OnItemClickListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hit_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mName.setText(mValues.get(position).getUser());
        holder.mSubline.setText(mValues.get(position).getTags());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(holder.mItem);
            }
        });

        Glide.with(holder.mView.getContext())
                .load(holder.mItem.getWebformatURL())
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .crossFade()
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        holder.mImageView.setImageDrawable(null);
                        return false;
                    }
                })
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        @BindView(R.id.imageView)
        ImageView mImageView;
        @BindView(R.id.name)
        AppCompatTextView mName;
        @BindView(R.id.sub_line)
        AppCompatTextView mSubline;
        Hit mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, itemView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mSubline.getText() + "'";
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Hit hit);
    }
}