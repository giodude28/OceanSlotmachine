package com.billy.oceanslotmachinesearoute.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.billy.oceanslotmachinesearoute.Model.AdviceFishModel;
import com.billy.oceanslotmachinesearoute.R;

import java.util.List;

public class AdviceFishAdapter extends RecyclerView.Adapter<AdviceFishAdapter.ViewHolder> {
    Context context;
    List<AdviceFishModel> data;
    TextView title1,desc1;

    public AdviceFishAdapter(Context context, List<AdviceFishModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.adviceitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.title.setText(data.get(position).getTitle());
    holder.img.setImageResource(data.get(position).getImage());

        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.advicedetails);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        title1 = myDialog.findViewById(R.id.advicenamedetail);
        desc1 = myDialog.findViewById(R.id.advicedescdetail);
        for (int i = 0; i<data.size(); i++) {
            if(holder.title.getText()==data.get(position).getTitle()){
                title1.setText(data.get(position).getTitle());
                desc1.setText(data.get(position).getDesc());
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.advicename);
            img = itemView.findViewById(R.id.adviceImage);
        }
    }
}
