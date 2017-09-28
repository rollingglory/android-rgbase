package com.rollingglory.androidrgbase;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


/**
 * Created by mhasby on 9/28/2017.
 * mhmmd.hsby@gmail.com
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/ClearSans-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

}
