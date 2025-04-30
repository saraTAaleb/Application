package com.example.application

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class AndroidCompact12 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_compact12)

        val pieChart = findViewById<PieChart>(R.id.pieChart)

        // 1) تجهيز البيانات
        val entries = listOf(
            PieEntry(60f),
            PieEntry(25f),
            PieEntry(10f),
            PieEntry(5f)
        )
        val colors = listOf(Color.RED, Color.parseColor("#4EF0B7"), Color.YELLOW, Color.BLUE)
        val dataSet = PieDataSet(entries, "").apply {
            this.colors = colors
            sliceSpace = 2f
            selectionShift = 5f
            setDrawValues(false)
        }

        // 2) ربط البيانات بالشارت ثم تحديثه
        pieChart.apply {
            // هاد السطر هو اللي كيربط البيانات:
            data = PieData(dataSet)              // ← هنا

            // إعدادات إضافية
            setUsePercentValues(false)
            description.isEnabled = false
            legend.isEnabled = false
            isDrawHoleEnabled = true
            holeRadius = 60f
            transparentCircleRadius = 65f

            // هاد السطرين كيرسلو إشعار وتعيدو رسم الشارت:
            notifyDataSetChanged()               // ← هنا
            invalidate()                         // ← هنا
        }
    }

}