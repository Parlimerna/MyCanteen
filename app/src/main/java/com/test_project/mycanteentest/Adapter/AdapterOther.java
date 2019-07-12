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
import com.test_project.mycanteentest.Model.OtherItem;
import com.test_project.mycanteentest.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterOther extends RecyclerView.Adapter<AdapterOther.MyViewHolder>{

    private List<OtherItem> otherItems = new ArrayList<>();
    private Context context;

    public AdapterOther(List<OtherItem> othersItems, Context context) {
        this.otherItems = othersItems;
        this.context = context;
    }

    public void getContext(Context context) {
        this.context = context;
    }

    public void setData(List<OtherItem> otherItems) {
        this.otherItems = otherItems;
    }

    @NonNull
    @Override
    public AdapterOther.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AdapterOther.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterOther.MyViewHolder myViewHolder, int i) {
        OtherItem item = otherItems.get(i);

        Glide.with(context)
                .load(item.getImg())
                .into(myViewHolder.image);
        myViewHolder.txttitle.setText(item.getTitle());
        myViewHolder.txtharga.setText(String.valueOf(item.getHarga()));
    }

    @Override
    public int getItemCount() {
        return otherItems.size();
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

