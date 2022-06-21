package me.mohekkus.maddashboard.activity.vendor.helper.model

class VendorDetailModel {
    var activeProj: Int = 0
    lateinit var contractID: ArrayList<String>
    lateinit var vendorName: String
    @field:JvmField
    var noData: Boolean = false

    constructor()
    constructor(
        activeProj: Int,
        contractID: ArrayList<String>,
        vendorName: String,
        noData: Boolean
    ) {
        this.activeProj = activeProj
        this.contractID = contractID
        this.vendorName = vendorName
        this.noData = noData
    }
}