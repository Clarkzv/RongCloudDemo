package com.example.gener.rongyundemo;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import io.rong.imkit.RongIM;
import okhttp3.OkHttpClient;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);

        initOkHttp();
    }

    private void initOkHttp() {
        OkHttpClient build = new OkHttpClient
                .Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }
}
