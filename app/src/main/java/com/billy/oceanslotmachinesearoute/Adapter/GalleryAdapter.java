package com.billy.oceanslotmachinesearoute.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.billy.oceanslotmachinesearoute.Model.GalleryModel;
import com.billy.oceanslotmachinesearoute.R;

import java.util.List;

public class GalleryAdapter  extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    Context context;
    List<GalleryModel> data;

    public GalleryAdapter(Context context, List<GalleryModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.galleryitem,parent,false);
      ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.ViewHolder holder, int position) {
    holder.img.setImageResource(data.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.cimage);
        }
    }
}
