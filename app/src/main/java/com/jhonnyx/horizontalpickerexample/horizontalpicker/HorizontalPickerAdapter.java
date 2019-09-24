package com.jhonnyx.horizontalpickerexample.horizontalpicker;


import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jhonnyx.horizontalpickerexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhonn on 22/02/2017.
 */

public class HorizontalPickerAdapter extends RecyclerView.Adapter<HorizontalPickerAdapter.ViewHolder> {

    private final int mBackgroundColor;
    private final int mItemColorTextColor;
    private final int mItemSelectedColor;
    private final int mItemSelectedTextColor;
    private int itemWidth;
    private final OnItemClickedListener listener;
    private ArrayList<Item> items;

    public HorizontalPickerAdapter(int itemWidth, OnItemClickedListener listener, List<String> list, final int mItemColor, final int mItemSelectedColor, final int mItemSelectedTextColor, int mItemColorTextColor) {
        items = new ArrayList<>();
        this.itemWidth = itemWidth;
        this.listener = listener;
        this.mBackgroundColor = mItemColor;
        this.mItemSelectedColor = mItemSelectedColor;
        this.mItemSelectedTextColor = mItemSelectedTextColor;
        this.mItemColorTextColor = mItemColorTextColor;

        stringToItem(list);
    }

    private void stringToItem(List<String> list) {
        for (String s : list) {
            items.add(new Item(s));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = getItem(position);
        holder.tvText.setText(item.getValue());
        if (item.isSelected()) {
            holder.tvText.setTextColor(mItemSelectedTextColor);
            holder.tvText.setBackgroundColor(mItemSelectedColor);
            holder.tvText.setTypeface(holder.tvText.getTypeface(), Typeface.BOLD);
        } else {
            holder.tvText.setTextColor(mItemColorTextColor);
            holder.tvText.setBackgroundColor(mBackgroundColor);
            holder.tvText.setTypeface(holder.tvText.getTypeface(), Typeface.NORMAL);
        }
    }

    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvText;

        public ViewHolder(View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tvDay);
            tvText.setWidth(itemWidth);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClickView(v, getAdapterPosition());
        }
    }
}