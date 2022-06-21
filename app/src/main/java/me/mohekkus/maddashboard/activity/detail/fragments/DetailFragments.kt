package me.mohekkus.maddashboard.activity.detail.fragments

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.aachartmodel.aainfographics.aachartcreator.*
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AADataLabels
import dagger.hilt.android.AndroidEntryPoint
import me.mohekkus.maddashboard.R
import me.mohekkus.maddashboard.activity.detail.helper.adapter.DetailFragmentAdapter
import me.mohekkus.maddashboard.activity.detail.helper.model.ContractsModel
import me.mohekkus.maddashboard.databinding.LayoutDetailFragBinding


@AndroidEntryPoint
class DetailFragments : Fragment() {

    private lateinit var binding: LayoutDetailFragBinding
    private lateinit var data: ContractsModel
    private lateinit var month: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_detail_frag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<TextView>(R.id.summary_title).text = month
            findViewById<TextView>(R.id.summary_text).text = "Contract(s) in $month"
            findViewById<RecyclerView>(R.id.summary_rv).apply {
                layoutManager = LinearLayoutManager(context)
                adapter = DetailFragmentAdapter(data.contracts)
            }
            findViewById<ImageView>(R.id.summary_back).setOnClickListener {
                requireActivity().onBackPressed()
            }
            findViewById<AAChartView>(R.id.charted).apply {
                val chartModel = AAChartModel().apply {
                    chartType = AAChartType.Pie
                    legendEnabled(false)
                    backgroundColor(Color.TRANSPARENT)
                    colorsTheme(arrayOf("#2A327D","#FFB039","#00C689","#FE645A"))
                    series(arrayOf(
                        AASeriesElement()
                            .dataLabels(AADataLabels().enabled(false))
                            .innerSize("30%")
                            .data(
                                arrayOf(
                                    arrayOf("Preparing", 1.0),
                                    arrayOf("Instalasi", .2),
                                    arrayOf("Commtest", .8),
                                    arrayOf("Uji Terima", .4)
                                )
                            )
                    ))
                }
                val option = chartModel.aa_toAAOptions()
                option.chart?.animation = false
                aa_drawChartWithChartOptions(option)
            }
        }
    }

    fun setData(month: String, data: ContractsModel) {
        this.data = data
        this.month = month
    }
}