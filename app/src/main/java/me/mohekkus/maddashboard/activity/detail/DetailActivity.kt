package me.mohekkus.maddashboard.activity.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import dagger.hilt.android.AndroidEntryPoint
import me.mohekkus.maddashboard.activity.detail.helper.DetailFirestore
import me.mohekkus.maddashboard.activity.detail.helper.adapter.DetailSliderAdapter
import me.mohekkus.maddashboard.activity.detail.helper.interfaces.DetailInterface
import me.mohekkus.maddashboard.activity.detail.helper.model.MonthModel
import me.mohekkus.maddashboard.databinding.LayoutDetailBinding
import javax.inject.Inject

@AndroidEntryPoint
class DetailActivity: FragmentActivity(), DetailInterface {

    private lateinit var binding: LayoutDetailBinding
    @Inject lateinit var detailFirestore: DetailFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(
//            R.layout.layout_detail
//        )
        LayoutDetailBinding.inflate(layoutInflater).apply {
            binding = this
            setContentView(this.root)
        }

        detailFirestore.getDoc(this)
    }

    override fun getData(pojo: MonthModel) {
        Log.e("POJOSETAN", pojo.data[0].contracts[0].contractID)
        binding.pager.adapter = DetailSliderAdapter(pojo, this)
    }

    override fun onBackPressed() {
        if (binding.pager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            binding.pager.currentItem = binding.pager.currentItem - 1
        }
    }
}