package com.example.gaurav.kotlin_navigationdrawer.settingStructure

import android.app.Application
import android.content.Context

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)

    }

    companion object {

        private val TAG = "styleNSity"
    }
}