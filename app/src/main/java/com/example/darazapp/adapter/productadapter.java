package com.example.darazapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.darazapp.R;
import com.example.darazapp.model.Products;

import java.util.List;

public class productadapter extends RecyclerView.Adapter<productadapter.ItemViewHolder> {
    List<Products> productsList;


    public productadapter(Context context, List<Products> productsLis) {
        this.productsList = productsLis;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_layout,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Products products=productsList.get(position);
        holder.imgImage.setImageResource(products.getImage());
        holder.tvDescription.setText(products.getDescription());
        holder.tvRate.setText("Rs" + products.getPrice());
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView imgImage;
        TextView tvDescription,tvRate;
        public ItemViewHolder(@NonNull View itemView){
            super(itemView);
            imgImage=itemView.findViewById(R.id.imgProduct);
            tvDescription=itemView.findViewById(R.id.tvProductDesc);
            tvRate=itemView.findViewById(R.id.tvProductPrice);
        }
    }


}
