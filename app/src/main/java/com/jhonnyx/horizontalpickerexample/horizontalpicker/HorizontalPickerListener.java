package com.jhonnyx.horizontalpickerexample.horizontalpicker;

/**
 * Author: Hamed Taherpour
 * *
 * Created: 9/24/2019
 */
public interface HorizontalPickerListener {
    void onStopDraggingPicker();
    void onDraggingPicker();
    void onDateSelected(Item item);
}