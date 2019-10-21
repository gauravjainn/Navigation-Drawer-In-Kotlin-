package com.example.gaurav.kotlin_navigationdrawer.Utills

import android.content.Context
import android.net.ConnectivityManager
import android.support.v4.app.FragmentActivity


class ConnectionDetector(private val _context: FragmentActivity?) {


    val isConnectingToInternet: Boolean
        get() {
            val connectivityManager = _context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
}
