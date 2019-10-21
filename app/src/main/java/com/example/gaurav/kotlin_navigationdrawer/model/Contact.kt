package com.example.gaurav.kotlin_navigationdrawer.model

import com.example.gaurav.kotlin_navigationdrawer.model.Phone
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Contact {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("address")
    @Expose
    var address: String? = null
    @SerializedName("gender")
    @Expose
    var gender: String? = null
    @SerializedName("phone")
    @Expose
    var phone: Phone? = null

    fun withId(id: String): Contact {
        this.id = id
        return this
    }

    fun withName(name: String): Contact {
        this.name = name
        return this
    }

    fun withEmail(email: String): Contact {
        this.email = email
        return this
    }

    fun withAddress(address: String): Contact {
        this.address = address
        return this
    }

    fun withGender(gender: String): Contact {
        this.gender = gender
        return this
    }

    fun withPhone(phone: Phone): Contact {
        this.phone = phone
        return this
    }

}