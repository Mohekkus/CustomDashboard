package me.mohekkus.maddashboard.etc

import android.widget.TextView
import java.util.*
import javax.inject.Inject

class TimelyGreet @Inject constructor() {

    //An helper class to set greeting text on dashboard main page based on time (clock)

    fun setGreeting(textView: TextView) {
        textView.text = getTime()
    }

    private fun getTime(): String {
        val cal = Calendar.getInstance()

        return getGreeting(
            cal.get(Calendar.HOUR_OF_DAY)
        )
    }

    private fun getGreeting(hour: Int): String =
        when (hour) {
            in 0..11 -> "Good Morning"
            in 12..15 -> "Good Afternoon"
            in 16..20 -> "Good Evening"
            in 21..24 -> "Good Night"
            else -> ""
        }

    companion object {
        const val TAG = "Timely Greet"
    }
}