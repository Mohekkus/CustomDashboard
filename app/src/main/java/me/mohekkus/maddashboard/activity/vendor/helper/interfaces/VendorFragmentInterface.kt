package me.mohekkus.maddashboard.activity.vendor.helper.interfaces

import me.mohekkus.maddashboard.activity.vendor.helper.model.VendorDetailModel

interface VendorFragmentInterface {
    fun getDetailData(pojo: VendorDetailModel)
    fun failed()
}