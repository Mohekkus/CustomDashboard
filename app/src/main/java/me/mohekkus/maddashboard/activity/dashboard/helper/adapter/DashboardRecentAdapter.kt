package me.mohekkus.maddashboard.activity.dashboard.helper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import me.mohekkus.maddashboard.R
import me.mohekkus.maddashboard.activity.dashboard.helper.model.DashboardRecentModel

class DashboardRecentAdapter(private val data: ArrayList<DashboardRecentModel>) : RecyclerView.Adapter<DashboardRecentAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.component_dash_recent, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.itemView
        val data = data[position]

        view.apply {
            findViewById<TextView>(R.id.recent_title).text = data.contractName
            findViewById<TextView>(R.id.recent_sub).text = data.contractID
            setOnClickListener {
                Toast.makeText(context, "SOON", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getItemCount(): Int = data.size
}