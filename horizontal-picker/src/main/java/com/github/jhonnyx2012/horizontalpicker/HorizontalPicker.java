package com.github.jhonnyx2012.horizontalpicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

import java.util.List;

/**
 * Created by Jhonny Barrios on 22/02/2017.
 */

public class HorizontalPicker extends LinearLayout implements HorizontalPickerListener {

    private View vHover;
    private DatePickerListener listener;
    private HorizontalPickerRecyclerView rvDays;
    private List<String> list;

    private int drawableHover;
    private int mItemColor = -1;
    private int mItemColorTextColor = -1;
    private int mItemSelectedColor = -1;
    private int mItemSelectedTextColor = -1;
    private int position = -1;
    private int count = 7;
    private boolean hasSnapHelper;

    public HorizontalPicker(Context context) {
        super(context);
    }

    public HorizontalPicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontalPicker(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public HorizontalPicker setListener(DatePickerListener listener) {
        this.listener = listener;
        return this;
    }

    public void init() {
        inflate(getContext(), R.layout.horizontal_picker, this);
        rvDays = findViewById(R.id.rvDays);
        vHover = findViewById(R.id.vHover);
        rvDays.setListener(this);
        rvDays.init(getContext(), count, hasSnapHelper, list, mItemColor, mItemSelectedColor, mItemSelectedTextColor, mItemColorTextColor, position);

        if (drawableHover != -1)
            vHover.setBackgroundResource(drawableHover);
    }

    public HorizontalPicker setData(List<String> list) {
        this.list = list;
        return this;
    }

    @Override
    public boolean post(Runnable action) {
        return rvDays.post(action);
    }

    @Override
    public void onStopDraggingPicker() {
        if (vHover.getVisibility() == VISIBLE)
            vHover.setVisibility(INVISIBLE);
    }

    @Override
    public void onDraggingPicker() {
        if (vHover.getVisibility() == INVISIBLE)
            vHover.setVisibility(VISIBLE);
    }

    @Override
    public void onDateSelected(Item item) {
        if (listener != null) {
            listener.onDateSelected(item.getValue());
        }
    }

    public HorizontalPicker setItemHover(@DrawableRes int drawable) {
        drawableHover = drawable;
        return this;
    }

    public HorizontalPicker setItemSelectedTextColor(@ColorInt int color) {
        mItemSelectedTextColor = color;
        return this;
    }

    public HorizontalPicker setItemSelectedBackgroundColor(@ColorInt int color) {
        mItemSelectedColor = color;
        return this;
    }

    public HorizontalPicker setItemBackgroundColor(@ColorInt int color) {
        mItemColor = color;
        return this;
    }

    public HorizontalPicker setItemBackgroundTextColor(@ColorInt int color) {
        mItemColorTextColor = color;
        return this;
    }

    public HorizontalPicker setDefaultSelected(int position) {
        this.position = position;
        return this;
    }

    public HorizontalPicker setCount(@IntRange(from = 4) int count) {
        this.count = count;
        return this;
    }

    public HorizontalPicker setSnapHelper(boolean has) {
        this.hasSnapHelper = has;
        return this;
    }
}