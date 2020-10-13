package com.example.androidinterviewprep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
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
        recylerView.layoutManager = LinearLayoutManager(this)
        recylerView.adapter = MoviesAdapter(movies)
    }
}