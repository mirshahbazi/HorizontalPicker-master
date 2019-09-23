package com.github.jhonnyx2012.horizontalpicker;


/**
 * Created by jhonn on 28/02/2017.
 */

public class Item {

    private boolean selected;
    String value;

    public Item(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

}
