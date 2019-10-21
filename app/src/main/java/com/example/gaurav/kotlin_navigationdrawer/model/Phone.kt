package com.example.gaurav.kotlin_navigationdrawer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Phone {

    @SerializedName("mobile")
    @Expose
    var mobile: String? = null
    @SerializedName("home")
    @Expose
    var home: String? = null
    @SerializedName("office")
    @Expose
    var office: String? = null

    fun withMobile(mobile: String): Phone {
        this.mobile = mobile
        return this
    }

    fun withHome(home: String): Phone {
        this.home = home
        return this
    }

    fun withOffice(office: String): Phone {
        this.office = office
        return this
    }

}