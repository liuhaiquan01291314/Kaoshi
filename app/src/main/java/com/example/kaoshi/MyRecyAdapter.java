package com.example.kaoshi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.logging.Handler;

public class MyRecyAdapter extends RecyclerView.Adapter {
    private ArrayList<Bean.DataBean.ListBean> list;
    private Context context;

    public MyRecyAdapter(ArrayList<Bean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recy,null);
        return new Handle(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            Handle handle= (Handle) viewHolder;
        Glide.with(context).load(list.get(i).getPic()).into(handle.img);
         handle.name.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class Handle extends RecyclerView.ViewHolder{
       private ImageView img;
       private TextView name;
        public Handle(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.name);
        }
    }
}
