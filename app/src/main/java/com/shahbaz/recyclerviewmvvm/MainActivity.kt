package com.shahbaz.recyclerviewmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repositroy = MoviesRepositroy(MoviesApi())


        GlobalScope.launch(Dispatchers.Main) {
            val movies = repositroy.getMovies()

            Toast.makeText(this@MainActivity, movies.toString(), Toast.LENGTH_LONG).show()

        }
    }
}
