package me.mohekkus.maddashboard.activity.detail.helper.model

class ContractsModel {

    lateinit var contracts: ArrayList<VendorModel>

    constructor()
    constructor(contracts: ArrayList<VendorModel>){
        this.contracts = contracts
    }
}