package com.example.androidinterviewprep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shimmerLayout.startShimmer()
        GlobalScope.launch {
            delay(5000L)
            runOnUiThread {
                setRecyclerAdapter()
                shimmerLayout.stopShimmer()
                shimmerLayout.visibility = View.GONE
            }
        }
    }

    private fun setRecyclerAdapter() {
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
        recylerView.layoutManager = LinearLayoutManager(this)
        recylerView.adapter = MoviesAdapter(movies)    }
}