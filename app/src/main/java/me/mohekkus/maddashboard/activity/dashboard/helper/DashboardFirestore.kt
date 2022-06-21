package me.mohekkus.maddashboard.activity.dashboard.helper

import android.util.Log
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import me.mohekkus.maddashboard.activity.dashboard.helper.interfaces.DashboardInterface
import me.mohekkus.maddashboard.activity.dashboard.helper.model.DashboardModel
import me.mohekkus.maddashboard.etc.FirestoreImplementator
import javax.inject.Inject

class DashboardFirestore @Inject constructor() {

    fun getDoc(dashInterface: DashboardInterface) {
        val doc = Firebase.firestore.collection("Apps").document("21xKsNAMnLhEbTWbTnmD")

        doc.get(Source.DEFAULT).addOnCompleteListener {
            if (it.isSuccessful) {
                val result = it.result


                Log.e("BANGST", "${result.data}")
                val pojo = result.toObject(DashboardModel::class.java)
                println(pojo?.gridMenu)
                if (pojo != null)
                    dashInterface.doWithData(pojo)
            }
        }
    }
}