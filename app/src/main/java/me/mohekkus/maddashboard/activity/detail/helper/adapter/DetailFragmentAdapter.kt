package me.mohekkus.maddashboard.activity.detail.helper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import me.mohekkus.maddashboard.R
import me.mohekkus.maddashboard.activity.detail.helper.model.VendorModel

class DetailFragmentAdapter(val raw: ArrayList<VendorModel>) : RecyclerView.Adapter<DetailFragmentAdapter.ViewHolder>() {


    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.component_summary_card, parent, false)
        )

    override fun getItemCount(): Int = raw.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.itemView
        val data = raw[position]

        view.apply {
            findViewById<TextView>(R.id.txt_contract_id).text = data.contractID
            findViewById<TextView>(R.id.txt_mitra).text = data.contractPartner
            findViewById<TextView>(R.id.txt_proj_name).text = data.contractDesc
            setOnClickListener {
                Toast.makeText(context, "SOON", Toast.LENGTH_LONG).show()
            }
        }
    }
}