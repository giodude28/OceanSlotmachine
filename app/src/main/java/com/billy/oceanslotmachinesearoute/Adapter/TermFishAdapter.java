package com.billy.oceanslotmachinesearoute.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.billy.oceanslotmachinesearoute.Model.TermFishModel;
import com.billy.oceanslotmachinesearoute.R;

import java.util.List;

public class TermFishAdapter extends RecyclerView.Adapter<TermFishAdapter.ViewHolder> {
    Context context;
    List<TermFishModel> data;
    TextView title1,desc1;
    public TermFishAdapter(Context context, List<TermFishModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public TermFishAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.termitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TermFishAdapter.ViewHolder holder, int position) {
    holder.title.setText(data.get(position).getTitle());

        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.termdetails);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        title1 = myDialog.findViewById(R.id.termnamedetail);
        desc1 = myDialog.findViewById(R.id.termdescdetail);
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
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tername);
        }
    }
}
