package com.example.gaurav.kotlin_navigationdrawer.settingStructure


import com.example.gaurav.kotlin_navigationdrawer.Utills.Constants

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {


    //set up retrofit to make api calls

    var retrofit: Retrofit? = null

    val client: Retrofit?
        get() {

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit
        }
}
