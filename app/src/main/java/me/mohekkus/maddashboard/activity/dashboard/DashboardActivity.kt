package me.mohekkus.maddashboard.activity.dashboard

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import me.mohekkus.maddashboard.activity.dashboard.helper.DashboardFirestore
import me.mohekkus.maddashboard.activity.dashboard.helper.adapter.DashboardGridAdapter
import me.mohekkus.maddashboard.activity.dashboard.helper.adapter.DashboardRecentAdapter
import me.mohekkus.maddashboard.activity.dashboard.helper.interfaces.DashboardInterface
import me.mohekkus.maddashboard.activity.dashboard.helper.model.DashboardModel
import me.mohekkus.maddashboard.databinding.LayoutDashboardBinding
import me.mohekkus.maddashboard.etc.Utility
import javax.inject.Inject

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity(), DashboardInterface {

    private lateinit var binding: LayoutDashboardBinding
    @Inject lateinit var utility: Utility
    @Inject lateinit var dashboardFirestore: DashboardFirestore

    override fun onStart() {
        super.onStart()

        dashboardFirestore.getDoc(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        LayoutDashboardBinding.inflate(layoutInflater).apply {
            binding = this
            setContentView(this.root)
        }

        initiateActivity()
    }

    private fun initiateActivity() {
        binding.apply {
            utility.timelyGreet.setGreeting(dashTime)
            dashSummButton.setOnClickListener {
                soonTM()
            }
            dashBudgetButton.setOnClickListener {
                soonTM()
            }
        }
    }

    private fun soonTM() {
        Toast.makeText(this, "SOON", Toast.LENGTH_LONG).show()
    }

    override fun doWithData(pojo: DashboardModel) {
        Log.d("TAG", pojo.gridMenu.size.toString())
        binding.apply {
            dashTotal.text = "IDR ${pojo.bastTotal}"
            dashRvGrid.apply {
                layoutManager = GridLayoutManager(this@DashboardActivity, 2)
                adapter = DashboardGridAdapter(pojo.gridMenu)
                setHasFixedSize(true)
                isNestedScrollingEnabled = false
            }
            dashRvRecent.apply {
                layoutManager = LinearLayoutManager(this@DashboardActivity)
                adapter = DashboardRecentAdapter(pojo.recentActivities)
                setHasFixedSize(false)
                isNestedScrollingEnabled = false
            }
        }
    }
}