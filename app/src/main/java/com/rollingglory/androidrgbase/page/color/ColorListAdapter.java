package com.rollingglory.androidrgbase.page.color;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rollingglory.androidrgbase.R;

import java.util.List;

import app.model.Color;

/**
 * Created by mhasby on 9/28/2017.
 * mhmmd.hsby@gmail.com
 */

public class ColorListAdapter extends RecyclerView.Adapter<ColorListAdapter.ViewHolder> {

    private Context context;
    private List<Color> list;

    ColorListAdapter(Context context, List<Color> list) {
        this.context= context;
        Log.d("ColorListAdapter", "list size = " + list.size());
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_color, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Color color = getItem(position);

        holder.ivColor.setBackgroundColor(color.color);
        holder.tvName.setText(color.name);
        holder.tvHexa.setText(color.hexacode);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private Color getItem(int position){
        return list.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivColor;
        TextView tvName;
        TextView tvHexa;

        ViewHolder(View itemView) {
            super(itemView);
            ivColor = (ImageView) itemView.findViewById(R.id.iv_color);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvHexa = (TextView) itemView.findViewById(R.id.tv_hexa);
        }
    }
}
