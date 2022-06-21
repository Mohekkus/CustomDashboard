package me.mohekkus.maddashboard.activity.vendor.helper.interfaces

import me.mohekkus.maddashboard.activity.detail.helper.model.MonthModel
import me.mohekkus.maddashboard.activity.vendor.helper.model.VendorListModel

interface VendorInterface {
    fun getDataList(pojo: VendorListModel)
}