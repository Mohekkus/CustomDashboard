package me.mohekkus.maddashboard.activity.vendor.helper.model

class VendorListModel {

    lateinit var vendorList: ArrayList<String>

    constructor()
    constructor(vendorList: ArrayList<String>) {
        this.vendorList = vendorList
    }
}