package com.dhirajnayak.axsimageapp.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhirajnayak.axsimageapp.R;
import com.dhirajnayak.axsimageapp.model.imageresponse.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Name: ImageAdapter
 * Purpose: Adapter to set the data to views
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {
    private List<Image> mImages;
    private Context mContext;

    public ImageAdapter(List<Image> mImages, Context mContext) {
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
        ImageHolder imageHolder = new ImageHolder(view);
        return  imageHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
        Image image = mImages.get(position);
        holder.textView.setText(image.getmTitle());
        Picasso.get().load(image.getmUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    //custom view holder
    public static class ImageHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public ImageHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.listItemImageView);
            textView = itemView.findViewById(R.id.listItemTextView);
        }
    }
}
