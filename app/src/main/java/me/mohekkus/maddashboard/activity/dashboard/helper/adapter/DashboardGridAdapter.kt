package me.mohekkus.maddashboard.activity.dashboard.helper.adapter

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import me.mohekkus.maddashboard.R
import me.mohekkus.maddashboard.activity.dashboard.helper.model.DashboardGridModel
import me.mohekkus.maddashboard.activity.detail.DetailActivity
import me.mohekkus.maddashboard.activity.vendor.VendorActivity

class DashboardGridAdapter(val gridMenu: ArrayList<DashboardGridModel>) : RecyclerView.Adapter<DashboardGridAdapter.ViewHolder>() {

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.component_dash_card, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.itemView
        val data = gridMenu[position]

        view.apply {
            findViewById<TextView>(R.id.card_sub).text = data.getSub()
            findViewById<TextView>(R.id.card_title).text = data.getTitle()
            if (data.getColor().isNotEmpty())
                findViewById<CardView>(R.id.card_root).setCardBackgroundColor(
                    Color.parseColor(
                        data.getColor()
                    )
                )

            setOnClickListener {
                when (data.getOnClick()) {
                    "APPS-MONTHLY" ->
                        context.startActivity(
                            Intent(view.context, DetailActivity::class.java)
                        )
                    "APPS-VENDOR" ->
                        context.startActivity(
                            Intent(view.context, VendorActivity::class.java)
                        )
                    else -> Toast.makeText(context, "SOON", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun getItemCount(): Int = gridMenu.size


}