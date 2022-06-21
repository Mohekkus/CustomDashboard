package me.mohekkus.maddashboard.activity.vendor.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import me.mohekkus.maddashboard.R
import me.mohekkus.maddashboard.activity.vendor.helper.VendorFirestore
import me.mohekkus.maddashboard.activity.vendor.helper.interfaces.VendorFragmentInterface
import me.mohekkus.maddashboard.activity.vendor.helper.model.VendorDetailModel
import me.mohekkus.maddashboard.etc.KeyboardUtils
import javax.inject.Inject

@AndroidEntryPoint
class VendorFragment: Fragment(), VendorFragmentInterface {

    @Inject lateinit var vendorFirestore: VendorFirestore

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_vendor_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            KeyboardUtils.hide(requireActivity(), view)
            findViewById<ImageView>(R.id.vendor_back).setOnClickListener {
                requireActivity().onBackPressed()
            }
        }

        println(arguments?.getString("docRef").toString())
        if (arguments != null)
            vendorFirestore.getDetail(arguments?.getString("docRef", "").toString(), this@VendorFragment)
        else
            requireActivity().onBackPressed()
    }

    override fun getDetailData(pojo: VendorDetailModel) {
        if (pojo.noData)
            failed()

        view?.apply {
            findViewById<TextView>(R.id.vendor_name).text = pojo.vendorName
            findViewById<TextView>(R.id.vendor_proj_count).text = pojo.activeProj.toString()

        }
    }

    override fun failed() {
        requireActivity().onBackPressed()
        Toast.makeText(requireContext(), "Something went wrong, Contact who had control over this Apps", Toast.LENGTH_LONG).show()
    }


}