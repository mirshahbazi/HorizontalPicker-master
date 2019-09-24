package com.jhonnyx.horizontalpickerexample;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jhonnyx.horizontalpickerexample.horizontalpicker.DatePickerListener;
import com.jhonnyx.horizontalpickerexample.horizontalpicker.HorizontalPicker;

import java.util.ArrayList;
import java.util.List;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                month();
            }
        }, 200);

        year();
    }

    private void year(){
        List<String> list = new ArrayList<>();
        list.add("1398");
        list.add("1397");
        list.add("1396");
        list.add("1395");
        list.add("1394");
        list.add("1393");
        list.add("1392");
        list.add("1391");
        list.add("1390");
        list.add("1389");
        list.add("1388");
        list.add("1387");

        HorizontalPicker picker = findViewById(R.id.list_year);
        picker.setData(list)
                .setItemBackgroundColor(getResources().getColor(R.color.colorGray))
                .setItemBackgroundTextColor(getResources().getColor(R.color.colorText))
                .setItemSelectedBackgroundColor(getResources().getColor(R.color.colorWhite))
                .setItemSelectedTextColor(getResources().getColor(R.color.colorTextSelected))
                .setDefaultSelected(list.size())
                .setCount(4)
                .setSnapHelper(false)
                .setListener(new DatePickerListener() {
                    @Override
                    public void onDateSelected(String dateSelected) {
                        Toast.makeText(getApplicationContext(), "you Select: " + dateSelected, Toast.LENGTH_SHORT).show();
                    }
                })
                .init();
        picker.setBackgroundColor(Color.LTGRAY);
    }

    private void month(){
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

        HorizontalPicker picker = findViewById(R.id.list_month);
        picker.setData(list)
                .setItemBackgroundColor(getResources().getColor(R.color.colorGray))
                .setItemBackgroundTextColor(getResources().getColor(R.color.colorText))
                .setItemSelectedBackgroundColor(getResources().getColor(R.color.colorWhite))
                .setItemSelectedTextColor(getResources().getColor(R.color.colorTextSelected))
                .setDefaultSelected(list.size() / 2)
                .setCount(4)
                .setSnapHelper(false)
                .setListener(new DatePickerListener() {
                    @Override
                    public void onDateSelected(String dateSelected) {
                        Toast.makeText(getApplicationContext(), "you Select: " + dateSelected, Toast.LENGTH_SHORT).show();
                    }
                })
                .init();
        picker.setBackgroundColor(Color.LTGRAY);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
