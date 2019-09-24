package com.jhonnyx.horizontalpickerexample;

import android.app.Application;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

/**
 * Author: Hamed Taherpour
 * *
 * Created: 9/24/2019
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/IRANSansMobile(FaNum)_Light.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());
    }
}
