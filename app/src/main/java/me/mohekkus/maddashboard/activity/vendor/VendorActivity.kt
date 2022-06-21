package me.mohekkus.maddashboard.activity.vendor

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import me.mohekkus.maddashboard.R
import me.mohekkus.maddashboard.activity.vendor.fragment.VendorFragment
import me.mohekkus.maddashboard.activity.vendor.helper.VendorFirestore
import me.mohekkus.maddashboard.activity.vendor.helper.adapter.VendorListAdapter
import me.mohekkus.maddashboard.activity.vendor.helper.interfaces.VendorInterface
import me.mohekkus.maddashboard.activity.vendor.helper.model.VendorListModel
import me.mohekkus.maddashboard.databinding.LayoutVendorBinding
import me.mohekkus.maddashboard.etc.KeyboardUtils
import javax.inject.Inject

@AndroidEntryPoint
class VendorActivity : AppCompatActivity(), VendorInterface {

    private lateinit var binding: LayoutVendorBinding
    @Inject lateinit var vendorFirestore: VendorFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LayoutVendorBinding.inflate(layoutInflater).apply {
            binding = this
            setContentView(this.root)
        }

        initiateActivity()
    }

    private fun initiateActivity() {
        binding.apply {
            vendorBack.setOnClickListener {
                onBackPressed()
            }
        }

        vendorFirestore.getDocList(this)
    }

    private fun openVendorDetail(string: String) {
        val vendorFragment = VendorFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.vendor_fragment, vendorFragment.apply {
                arguments = Bundle().apply {
                    putString(
                        "docRef",
                        string
                    )
                }
            })
            .addToBackStack(vendorFragment.tag)
            .commit()

        binding.vendorFragment.bringToFront()
    }

    private lateinit var vendorListAdapter: VendorListAdapter

    override fun getDataList(pojo: VendorListModel) {
        vendorListAdapter = VendorListAdapter(pojo.vendorList, ::openVendorDetail)
        binding.apply {
            vendorSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    val itemFilter: ArrayList<String> = arrayListOf()
                    for (i in pojo.vendorList.indices) {
                        val data = pojo.vendorList[i]

                        if (data.contains(p0.toString(), true))
                            itemFilter.add(data)
                    }

                    vendorListAdapter.setFilter(itemFilter)
                    return true
                }
            })

            vendorRv.apply {
                layoutManager = GridLayoutManager(this@VendorActivity, 2)
                adapter = vendorListAdapter
                setHasFixedSize(true)
            }
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1)
            supportFragmentManager.popBackStack()
        else {
            KeyboardUtils.hide(this, binding.root)
            super.onBackPressed()
        }
    }
}