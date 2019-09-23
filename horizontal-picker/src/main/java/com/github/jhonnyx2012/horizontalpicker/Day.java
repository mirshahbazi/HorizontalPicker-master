package com.github.jhonnyx2012.horizontalpicker;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by jhonn on 28/02/2017.
 */
public class Day {
    private DateTime date;
    private boolean selected;
    String value;
    private String monthPattern = "MMMM YYYY";

    public Day(String value) {
        this.value = value;
    }

    public String getDay() {
        return value;
    }

    public String getWeekDay() {
        return "";
    }

    public String getMonth() { return getMonth(""); }

    public String getMonth(String pattern) {
//        if (!pattern.isEmpty())
//            this.monthPattern = pattern;
//
//        return date.toString(monthPattern, Locale.getDefault());
        return "";
    }

    public String getDate() {
        return value;
    }

    public boolean isToday() {
//        DateTime today=new DateTime().withTime(0,0,0,0);
//        return getDate().getMillis()==today.getMillis();
        return false;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

}
