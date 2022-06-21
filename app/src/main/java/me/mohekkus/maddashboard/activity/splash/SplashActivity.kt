package me.mohekkus.maddashboard.activity.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import me.mohekkus.maddashboard.R
import me.mohekkus.maddashboard.activity.dashboard.DashboardActivity


class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_splash)
        Handler(Looper.getMainLooper())
            .postDelayed(
                {
                    startActivity(
                        Intent(
                            this,
                            DashboardActivity::class.java
                        )
                    )
                    finish()
                },
                3000
            )
    }
}