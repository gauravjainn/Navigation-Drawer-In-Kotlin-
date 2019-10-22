package com.example.gaurav.kotlin_navigationdrawer.settingStructure

import android.app.Application
import android.content.Context


class MainApplication : Application() {

   /* Take reference to understand Application class working and structure*/
   /* https://developer.android.com/studio/build/multidex#kotlin*/

    override fun onCreate() {
        super.onCreate()

    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)

    }

    companion object {

        private val TAG = "Navigation Drawer"
    }
}