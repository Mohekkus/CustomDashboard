package me.mohekkus.maddashboard.activity.vendor.helper

import android.util.Log
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import me.mohekkus.maddashboard.activity.vendor.helper.interfaces.VendorFragmentInterface
import me.mohekkus.maddashboard.activity.vendor.helper.interfaces.VendorInterface
import me.mohekkus.maddashboard.activity.vendor.helper.model.VendorDetailModel
import me.mohekkus.maddashboard.activity.vendor.helper.model.VendorListModel
import javax.inject.Inject

class VendorFirestore @Inject constructor() {

    fun getDocList(vendorInterface: VendorInterface) {
        val doc = Firebase.firestore.collection("Apps")
            .document("21xKsNAMnLhEbTWbTnmD")
            .collection("Vendors")
            .document("List")

        doc.get(Source.DEFAULT).addOnCompleteListener {
            if (it.isSuccessful) {
                val result = it.result
//                Log.e("BANGST", "${result.data}")

                val pojo = result.toObject(VendorListModel::class.java)
//                println(pojo?.vendorList?.get(0))
                if (pojo != null)
                    vendorInterface.getDataList(pojo)
            }
        }
    }

    fun getDetail(get: String, vendorFragmentInterface: VendorFragmentInterface) {
        val doc = Firebase.firestore.collection("Apps")
            .document("21xKsNAMnLhEbTWbTnmD")
            .collection("Vendors")
            .document(get)

        doc.get(Source.DEFAULT).addOnCompleteListener {
            if (it.isSuccessful) {
                val result = it.result
//                Log.e("BANGST", "${result.data}")

                val pojo = result.toObject(VendorDetailModel::class.java)
//                println(pojo?.vendorName)
                if (pojo != null)
                    vendorFragmentInterface.getDetailData(pojo)
            } else
                vendorFragmentInterface.failed()
        }
    }
}