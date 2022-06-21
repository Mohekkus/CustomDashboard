package me.mohekkus.maddashboard.activity.detail.helper

import android.util.Log
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import me.mohekkus.maddashboard.activity.detail.helper.interfaces.DetailInterface
import me.mohekkus.maddashboard.activity.detail.helper.model.MonthModel
import javax.inject.Inject

class DetailFirestore @Inject constructor() {

    fun getDoc(detailInterface: DetailInterface) {
        val doc = Firebase.firestore.collection("Apps")
            .document("21xKsNAMnLhEbTWbTnmD")
            .collection("Month")
            .document("2022")

        doc.get(Source.DEFAULT).addOnCompleteListener {
            if (it.isSuccessful) {
                val result = it.result


                Log.e("BANGST", "${result.data}")
                val pojo = result.toObject(MonthModel::class.java)
                println(pojo?.data?.get(0)?.contracts?.get(0)?.contractPartner)
                if (pojo != null)
                    detailInterface.getData(pojo)
            }
        }
    }
}