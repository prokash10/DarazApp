package com.example.darazapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.darazapp.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class slideradapter extends SliderViewAdapter<slideradapter.SliderAdapterVH> {
    private Context context;
    private int count;


    public slideradapter(Context context) {
        this.context = context;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item clicked " + position, Toast.LENGTH_SHORT).show();
            }
        });

        switch (position) {
            case 0:
                Glide.with(viewHolder.itemView).load(R.drawable.shirt1).into(viewHolder.imageSlideBackground);
                break;
            case 1:
                Glide.with(viewHolder.itemView).load(R.drawable.fsaff).into(viewHolder.imageSlideBackground);
                break;
            default:
                Glide.with(viewHolder.itemView).load(R.drawable.asd).into(viewHolder.imageSlideBackground);
                break;

        }

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return count;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageSlideBackground;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageSlideBackground = itemView.findViewById(R.id.img_slider);
            this.itemView = itemView;
        }
    }
}
