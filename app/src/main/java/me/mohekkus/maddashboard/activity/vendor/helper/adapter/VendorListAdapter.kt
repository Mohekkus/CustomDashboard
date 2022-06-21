package me.mohekkus.maddashboard.activity.vendor.helper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.mohekkus.maddashboard.R

class VendorListAdapter() : RecyclerView.Adapter<VendorListAdapter.ViewHolder>() {

    private lateinit var dataFilter: ArrayList<String>
    private lateinit var callback: (String) -> Unit

    constructor(data: ArrayList<String>, kFunction1: (String) -> Unit) : this() {
        this.dataFilter = data
        this.callback = kFunction1
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.component_vendor_card, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.itemView
        val data = dataFilter[position]

        view.apply {
            findViewById<TextView>(R.id.card_title).text = data
            setOnClickListener {
                callback(data)
            }
        }
    }

    override fun getItemCount(): Int = dataFilter.size

    fun setFilter(list: ArrayList<String>) {
        dataFilter = arrayListOf()
        dataFilter.addAll(list)
        notifyDataSetChanged()
    }
}