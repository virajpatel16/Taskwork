package com.example.taskwork.Fragment

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taskwork.R
import com.example.taskwork.databinding.FragmentMineBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF


class mineFragment : Fragment() {

    lateinit var binding:FragmentMineBinding
    var taskpading=0
    var taskcomplite=1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentMineBinding.inflate(layoutInflater)
        lateinit var pieChart: PieChart


  piechart()

        return binding.root
    }

    private fun piechart() {
       binding .pieChart.setUsePercentValues(true)
        binding .pieChart.getDescription().setEnabled(false)
        binding . pieChart.setExtraOffsets(5f, 10f, 5f, 5f)

        // on below line we are setting drag for our pie chart
        binding .  pieChart.setDragDecelerationFrictionCoef(0.95f)

        // on below line we are setting hole
        // and hole color for pie chart
        binding .  pieChart.setDrawHoleEnabled(true)
        binding .  pieChart.setHoleColor(Color.WHITE)

        // on below line we are setting circle color and alpha
        binding .  pieChart.setTransparentCircleColor(Color.WHITE)
        binding .  pieChart.setTransparentCircleAlpha(110)

        // on  below line we are setting hole radius
        binding .  pieChart.setHoleRadius(58f)
        binding .  pieChart.setTransparentCircleRadius(61f)

        // on below line we are setting center text
        binding . pieChart.setDrawCenterText(true)

        // on below line we are setting
        // rotation for our pie chart
        binding .  pieChart.setRotationAngle(0f)

        // enable rotation of the pieChart by touch
        binding . pieChart.setRotationEnabled(true)
        binding . pieChart.setHighlightPerTapEnabled(true)

        // on below line we are setting animation for our pie chart
        binding . pieChart.animateY(1400, Easing.EaseInOutQuad)

        // on below line we are disabling our legend for pie chart
        binding . pieChart.legend.isEnabled = false
        binding . pieChart.setEntryLabelColor(Color.WHITE)
        binding . pieChart.setEntryLabelTextSize(12f)

        // on below line we are creating array list and
        // adding data to it to display in pie chart
        val entries: ArrayList<PieEntry> = ArrayList()
        entries.add(PieEntry(taskpading.toFloat()))
        entries.add(PieEntry(taskcomplite.toFloat()))


        // on below line we are setting pie data set
        val dataSet = PieDataSet(entries, "Mobile OS")

        // on below line we are setting icons.
        dataSet.setDrawIcons(false)

        // on below line we are setting slice for pie
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f

        // add a lot of colors to list
        val colors: ArrayList<Int> = ArrayList()
        colors.add(resources.getColor(R.color.purple_200))
        colors.add(resources.getColor(R.color.yellow))
        colors.add(resources.getColor(R.color.red))

        // on below line we are setting colors.
        dataSet.colors = colors

        // on below line we are setting pie data set
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(15f)
        data.setValueTypeface(Typeface.DEFAULT_BOLD)
        data.setValueTextColor(Color.WHITE)
        binding . pieChart.setData(data)

        // undo all highlights
        binding . pieChart.highlightValues(null)

        // loading chart
        binding . pieChart.invalidate()
        binding.pieChart.absoluteAngles
    }


}