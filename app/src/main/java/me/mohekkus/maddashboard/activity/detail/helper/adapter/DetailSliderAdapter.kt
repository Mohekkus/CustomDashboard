package me.mohekkus.maddashboard.activity.detail.helper.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import me.mohekkus.maddashboard.activity.detail.fragments.DetailFragments
import me.mohekkus.maddashboard.activity.detail.helper.model.MonthModel

class DetailSliderAdapter(private val pojo: MonthModel, private val fragments: FragmentActivity): FragmentStateAdapter(fragments) {
    override fun getItemCount(): Int = pojo.data.size

    override fun createFragment(position: Int): Fragment {
        return DetailFragments().apply {
            setData(
                getMonth(position + 1),
                pojo.data[position]
            )
        }
    }

    private fun getMonth(num: Int): String = when (num) {
        1 -> "January"
        2 -> "February"
        3 -> "March"
        4 -> "April"
        5 -> "Mei"
        6 -> "June"
        7 -> "July"
        8 -> "August"
        9 -> "September"
        10 -> "October"
        11 -> "November"
        12 -> "December"
        else -> "Invalid month is it doomsday already? Fuck!"
    }
}