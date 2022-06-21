package me.mohekkus.maddashboard.activity.detail.helper.model

class VendorModel {

    lateinit var contractID: String
    lateinit var contractPartner: String
    lateinit var contractSpent: String
    lateinit var contractDesc: String

    constructor()
    constructor(
        contractID: String,
        contractPartner: String,
        contractSpent: String,
        contractDesc: String
    ) {
        this.contractPartner = contractPartner
        this.contractID = contractID
        this.contractSpent = contractSpent
        this.contractDesc = contractDesc
    }
}