package com.test_project.mycanteentest.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.test_project.mycanteentest.Model.FoodsItem;
import com.test_project.mycanteentest.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterFood extends RecyclerView.Adapter<AdapterFood.MyViewHolder>{

    private List<FoodsItem> foodsItems = new ArrayList<>();
    private Context context;
    private int quantity = 0;

    public AdapterFood(List<FoodsItem> foodsItems, Context context) {
        this.foodsItems = foodsItems;
        this.context = context;
    }

    public void getContext(Context context) {
        this.context = context;
    }

    public void setData(List<FoodsItem> foodsItems) {
        this.foodsItems = foodsItems;
    }

    @NonNull
    @Override
    public AdapterFood.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AdapterFood.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFood.MyViewHolder myViewHolder, int i) {
        FoodsItem item = foodsItems.get(i);

        Glide.with(context)
                .load(item.getImg())
                .into(myViewHolder.image);
        myViewHolder.txttitle.setText(item.getTitle());
        myViewHolder.txtharga.setText(String.valueOf(item.getHarga()));


    }

    @Override
    public int getItemCount() {
        return foodsItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView txttitle, txtharga;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            txttitle = itemView.findViewById(R.id.txt_Title);
            txtharga = itemView.findViewById(R.id.txt_Harga);
        }
    }




}
