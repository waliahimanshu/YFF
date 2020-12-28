package com.himanshuw.yff

import android.app.Application
import com.facebook.stetho.Stetho

class YffApplication  : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
    }
}