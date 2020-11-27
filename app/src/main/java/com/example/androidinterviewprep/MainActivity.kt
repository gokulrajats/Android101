package com.example.androidinterviewprep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_VERTICAL
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movies = listOf(
            Movie(1, "", true, "UA", 73, 2300, "Marvel", "English", "2D"),
            Movie(1, "", true, "UA", 73, 2300, "Marvel", "English", "2D"),
            Movie(1, "", true, "UA", 73, 2300, "Marvel", "English", "2D"),
            Movie(1, "", true, "UA", 73, 2300, "Marvel", "English", "2D"),
            Movie(1, "", true, "UA", 73, 2300, "Marvel", "English", "2D"),
            Movie(1, "", true, "UA", 73, 2300, "Marvel", "English", "2D"),
            Movie(1, "", true, "UA", 73, 2300, "Marvel", "English", "2D"),
            Movie(1, "", true, "UA", 73, 2300, "Marvel", "English", "2D"),


            )
        view_pager.adapter = MovieAdapterViewPager(movies)
        view_pager.orientation = ORIENTATION_HORIZONTAL
        view_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            // override desired callback functions
        })
    }
}