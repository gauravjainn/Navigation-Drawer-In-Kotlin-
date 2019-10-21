package com.example.gaurav.kotlin_navigationdrawer.activity

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.gaurav.kotlin_navigationdrawer.BR
import com.example.gaurav.kotlin_navigationdrawer.R
import com.example.gaurav.kotlin_navigationdrawer.databinding.HomeListItemBinding
import com.example.gaurav.kotlin_navigationdrawer.model.Contact

class HomeAdapter(private val contactList: List<Contact>, activity: FragmentActivity) : RecyclerView.Adapter<HomeAdapter.ViewHolder> /*implements CustomClickListener */() {
    private val mContext: Context

    init {
        this.mContext = activity
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val binding = DataBindingUtil.inflate<HomeListItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.home_list_item, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = contactList[position]
        holder.bind(dataModel)
        //   holder.homeItemBinding.setItemClickListener(this);
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    inner class ViewHolder(var homeItemBinding: HomeListItemBinding) : RecyclerView.ViewHolder(homeItemBinding.root) {

        fun bind(obj: Any) {
            homeItemBinding.setVariable(BR.model, obj)
            homeItemBinding.executePendingBindings()
        }
    }

    fun cardClicked(contact: Contact) {
        Toast.makeText(mContext, "You clicked " + contact.name,
                Toast.LENGTH_LONG).show()
    }

}