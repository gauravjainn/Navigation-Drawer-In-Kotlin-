package com.example.gaurav.kotlin_navigationdrawer.Fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.gaurav.kotlin_navigationdrawer.R
import com.example.gaurav.kotlin_navigationdrawer.Utills.ConnectionDetector
import com.example.gaurav.kotlin_navigationdrawer.activity.HomeAdapter
import com.example.gaurav.kotlin_navigationdrawer.databinding.FragmentHomeBinding
import com.example.gaurav.kotlin_navigationdrawer.model.APIResponse
import com.example.gaurav.kotlin_navigationdrawer.model.Contact
import com.example.gaurav.kotlin_navigationdrawer.settingStructure.ApiClient
import com.example.gaurav.kotlin_navigationdrawer.settingStructure.ApiInterface
import com.google.gson.Gson

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    internal lateinit var binding: FragmentHomeBinding
    internal lateinit var mAdapter: HomeAdapter
    internal lateinit var contactList: List<Contact>
    private var isInternetConnected: Boolean = false


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.fragment_home, container, false)

        contactList = ArrayList()

        isInternetConnected = ConnectionDetector(activity).isConnectingToInternet
        if (isInternetConnected) {
            getContactData()
        } else {
            Toast.makeText(activity, resources.getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }


    private fun getContactData() {

        try {
            if (isInternetConnected) {
                val apiInterface = ApiClient.client?.create(ApiInterface::class.java)
                val saleCall = apiInterface?.contactsData
                Log.e(TAG, saleCall?.request()?.url().toString())

                saleCall?.enqueue(object : Callback<APIResponse> {
                    override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
                        Log.e(TAG, response.raw().toString())
                        Log.e(TAG, Gson().toJson(response.body()))

                        if (response.isSuccessful) {
                            try {
                                val example = response.body()
                                contactList = example!!.contacts!!

                                mAdapter = HomeAdapter(contactList, activity!!)
                                val mLayoutManager = LinearLayoutManager(activity)
                                binding.recyclerView.layoutManager = mLayoutManager
                                binding.recyclerView.isNestedScrollingEnabled = false
                                binding.recyclerView.itemAnimator = DefaultItemAnimator()
                                binding.recyclerView.adapter = mAdapter

                            } catch (e: Exception) {
                                e.printStackTrace()
                            }

                        } else {
                            // do nothing
                        }
                    }

                    override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                        // do nothing
                    }
                })
            } else {
                // do nothing
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    companion object {
        private val TAG = HomeFragment::class.java.simpleName
    }


}




