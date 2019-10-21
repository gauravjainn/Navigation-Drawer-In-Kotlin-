package com.example.gaurav.kotlin_navigationdrawer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class APIResponse {

    @SerializedName("contacts")
    @Expose
    var contacts: List<Contact>? = null

    fun withContacts(contacts: List<Contact>): APIResponse {
        this.contacts = contacts
        return this
    }

}