package com.test_project.mycanteentest.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.test_project.mycanteentest.Model.DrinksItem;
import com.test_project.mycanteentest.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterDrink extends RecyclerView.Adapter<AdapterDrink.MyViewHolder> {

    private List<DrinksItem> drinksItems = new ArrayList<>();
    private Context context;
    private int quantity = 0;
   private String tampilJumlah;

    public AdapterDrink(List<DrinksItem> drinksItems, Context context) {
        this.drinksItems = drinksItems;
        this.context = context;
    }

    public void getContext(Context context) {
        this.context = context;
    }

    public void setData(List<DrinksItem> drinksItems) {
        this.drinksItems = drinksItems;
    }

    @NonNull
    @Override
    public AdapterDrink.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterDrink.MyViewHolder myViewHolder, int i) {
        DrinksItem item = drinksItems.get(i);
        tampilJumlah = Integer.toString(quantity);
        final TextView tampil = myViewHolder.txtjumlah;

        Glide.with(context)
                .load(item.getImg())
                .into(myViewHolder.image);
        myViewHolder.txttitle.setText(item.getTitle());
        myViewHolder.txtharga.setText(String.valueOf(item.getHarga()));

        myViewHolder.increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity==0){
                    Toast.makeText(context,"Pesanan Bertambah" , Toast.LENGTH_SHORT).show();
                    return;
                }
                quantity = quantity+1 ;
                tampil.setText(tampilJumlah);


            }
        });

        myViewHolder.decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity==1){
                    Toast.makeText(context,"Pesanan Berkurang",Toast.LENGTH_SHORT).show();
                    return;
                }
                quantity = quantity-1;
                tampil.setText(tampilJumlah);
            }
        });


    }



    @Override
    public int getItemCount() {
        return drinksItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView txttitle, txtharga, txtjumlah;
        Button increase, decrease;


        private MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            txttitle = itemView.findViewById(R.id.txt_Title);
            txtharga = itemView.findViewById(R.id.txt_Harga);
            txtjumlah = itemView.findViewById(R.id.jumlah);
            increase = itemView.findViewById(R.id.tambah);
            decrease = itemView.findViewById(R.id.kurang);
        }
    }

    /*public void increament(View view) {
        if (quantity == 100) {
            Toast.makeText(this, "Pesanan maximal 100", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    public void decreament(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "Pesanan minimal 1", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);

    }*/
}
