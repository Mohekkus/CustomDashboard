package me.mohekkus.maddashboard.activity.dashboard.helper.interfaces

import me.mohekkus.maddashboard.activity.dashboard.helper.model.DashboardModel

interface DashboardInterface {
    fun doWithData(pojo: DashboardModel)
}