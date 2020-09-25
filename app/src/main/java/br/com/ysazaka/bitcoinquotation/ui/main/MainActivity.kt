package br.com.ysazaka.bitcoinquotation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.ysazaka.bitcoinquotation.R
import br.com.ysazaka.bitcoinquotation.data.viewmodel.MainViewModel
import br.com.ysazaka.bitcoinquotation.util.Constants
import br.com.ysazaka.bitcoinquotation.util.CustomMarker
import br.com.ysazaka.bitcoinquotation.util.Utils
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.card_last_quotation.*
import kotlinx.android.synthetic.main.line_chart.*
import java.util.*

/**
 * Created by Glauco Sazaka on 22/09/2020
 */
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var entry: Entry
    private var entryList: MutableList<Entry> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.chartLiveData.observe(this, Observer {
            it?.let { chartData ->
                for (values in chartData.values!!) {
                    entry = Entry(values.x!!.toFloat(), values.y!!.toFloat())
                    entryList.add(entry)
                }
                Hawk.put(Constants.CHART_ENTRIES, entryList)

                configChart()
            }
        })

        viewModel.statLiveData.observe(this, Observer {
            it?.let { statData ->
                Hawk.put(Constants.LAST_QUOTATION, statData.marketPriceUsd)
                tv_last_quotation.text = Utils.getMoneyText(statData.marketPriceUsd!!, Locale("en", "US"))
            }
        })

        viewModel.getChartData()
        viewModel.getStats()
    }

    private fun configChart() {
        val vl = LineDataSet(entryList, "Evolução da cotação")

        vl.setDrawValues(false)
        vl.setDrawFilled(true)
        vl.lineWidth = 3f
        vl.fillColor = R.color.colorGold
        vl.fillAlpha = R.color.colorGoldenRod

        lineChart.xAxis.labelRotationAngle = 0f

        lineChart.data = LineData(vl)

        lineChart.setTouchEnabled(true)
        lineChart.setPinchZoom(true)

        lineChart.description.text = "Evolução da cotação"
        lineChart.description.textColor = R.color.colorGold
        lineChart.setNoDataText("Sem dados disponíveis")

        lineChart.legend.isEnabled = true
        lineChart.legend.textColor = R.color.colorGold
        lineChart.legend.textSize = 20f

        lineChart.animateX(1800, Easing.EaseInExpo)

        val markerView = CustomMarker(this@MainActivity, R.layout.marker_view)
        lineChart.marker = markerView
    }
}
