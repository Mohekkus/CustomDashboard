package me.mohekkus.maddashboard.etc

import android.app.Activity
import android.content.Context
import android.content.Intent
import javax.inject.Inject

class CustomIntent {
}


//class AppsFeature @Inject constructor() {
//
//    private val home = Home::class.java
//    private val detail = ReportDetail::class.java
//    private val form = ReportForm::class.java
//    private val profile = Profile::class.java
//    private val visit = VisitSchedule::class.java
//    private val kegiatan = Kegiatan::class.java
//    private val member = ListPelanggan::class.java
//    private val login = Login::class.java
//    private val storeList = StoreList::class.java
//
//    var intents: Intent? = null
//
//    lateinit var context: Context
//
//    fun getClassFromString(string: String): Class<out Any>? {
//        return when (string){
//            Constant.STORE ->
//                storeList
//            Constant.DETAIL ->
//                detail
//            Constant.FORM ->
//                form
//            Constant.MEMBER ->
//                member
//            Constant.LIST ->
//                kegiatan
//            Constant.PROFILE ->
//                profile
//            Constant.SCHEDULE ->
//                visit
//            Constant.HOME ->
//                home
//            Constant.LOGIN ->
//                login
//            else -> null
//        }
//    }
//
//    fun initIntent(from: Context, destination: String): AppsFeature {
//        context = from
//        intents = Intent(from, getClassFromString(destination))
//        FirebaseCrashUtils(from)
//            .addReport("[Init] : $destination Activity")
//        return this
//    }
//
//    fun getDestination(destination: String): Class<out Any>? {
//        return getClassFromString(destination)
//    }
//
//    fun xtras(name: String, objects: String): AppsFeature {
//        intents?.putExtra(name, objects)
//        return this
//    }
//
//    fun xtras(name: String, objects: Request?): AppsFeature {
//        intents?.putExtra(name, objects)
//        return this
//    }
//
//    fun xtras(name: String, objects: LoginBodyResponse): AppsFeature {
//        intents?.putExtra(name, objects)
//        return this
//    }
//
//    fun runIntent(){
//        context.startActivity(intents)
//    }
//
//    companion object {
//        fun extract(activity: Activity) {
//            activity.intent?.extras?.get("key") as String
//            activity.intent?.extras?.get("req") as Request
//        }
//
//        fun extractIntent(intent: Intent, function: (MutableMap<String, Any>) -> Unit) {
//            val list = mutableMapOf<String, Any>()
//            list["key"] = intent.extras?.get("key") as String
//            list["request"] = intent.extras?.get("req") as Request
//
//            function(list)
//        }
//    }
//}