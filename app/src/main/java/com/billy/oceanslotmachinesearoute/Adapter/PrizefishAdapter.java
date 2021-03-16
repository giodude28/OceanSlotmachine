package com.billy.oceanslotmachinesearoute.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.billy.oceanslotmachinesearoute.Model.PrizefishModel;
import com.billy.oceanslotmachinesearoute.R;

import java.util.List;

public class PrizefishAdapter extends RecyclerView.Adapter<PrizefishAdapter.ViewHolder> {
    Context context;
    List<PrizefishModel> data;
    TextView title1,prizes;
    ImageView img1;
    public PrizefishAdapter(Context context, List<PrizefishModel> data) {
        this.context = context;
        this.data = data;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.prizefishitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.title.setText(data.get(position).getPfname());
    holder.img.setImageResource(data.get(position).getPfimage());
        holder.pri.setText(data.get(position).getPfprize());

//        final Dialog myDialog;
//        myDialog = new Dialog(context);
//        myDialog.setContentView(R.layout.prizedetail);
//        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        title1 = myDialog.findViewById(R.id.prizeName);
//        prizes = myDialog.findViewById(R.id.prize);
//        img1 = myDialog.findViewById(R.id.prizeImage);
//        for (int i = 0; i<data.size(); i++) {
//            if(holder.title.getText()==data.get(position).getPfname()){
//                title1.setText(data.get(position).getPfname());
//                prizes.setText(data.get(position).getPfprize());
//                Picasso.get().load(data.get(position).getPfimage()).into(img1);
//            }
//        }
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myDialog.show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,pri;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pri = itemView.findViewById(R.id.prize);
            title = itemView.findViewById(R.id.prizetitle);
            img = itemView.findViewById(R.id.prizeimg);
        }
    }
}
