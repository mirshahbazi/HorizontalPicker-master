package com.jhonnyx.horizontalpickerexample;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatePickerListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> list = new ArrayList<>();
        list.add("فروردین");
        list.add("اردیبهشت");
        list.add("خرداد");
        list.add("تیر");
        list.add("مرداد");
        list.add("شهریور");
        list.add("مهر");
        list.add("آبان");
        list.add("آذر");
        list.add("دی");
        list.add("بهمن");
        list.add("اسفند");

        HorizontalPicker picker = findViewById(R.id.datePicker);
        picker.setListener(this)
                .setData(list)
                .setItemBackgroundColor(getResources().getColor(android.R.color.holo_red_dark))
                .setItemBackgroundTextColor(getResources().getColor(android.R.color.holo_orange_dark))
                .setItemSelectedBackgroundColor(getResources().getColor(android.R.color.holo_green_dark))
                .setItemSelectedTextColor(getResources().getColor(android.R.color.holo_blue_dark))
                .setDefaultSelected(list.size() / 2)
                .setItemHover(R.drawable.item_hover)
                .setCount(4)
                .setSnapHelper(false)
                .init();
        picker.setBackgroundColor(Color.LTGRAY);

    }

    @Override
    public void onDateSelected(String dateSelected) {
        Toast.makeText(this, "you Select: " + dateSelected, Toast.LENGTH_SHORT).show();
    }
}
