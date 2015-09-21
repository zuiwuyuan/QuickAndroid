package com.lnyp.quickandroid.sys;


import android.app.Application;

import com.anupcowkur.reservoir.Reservoir;
import com.lnyp.quickandroid.util.ImageLoaderUtil;

public class BaseApp extends Application {

    public static AppCache cache;

    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoaderUtil.init(this);

        cache = AppCache.init(this);

        try {
            // 需要注意的是，Reservoir内部引用了GSON，所以不要再额外引入gson库
            Reservoir.init(this, 2048);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
