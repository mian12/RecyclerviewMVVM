package com.shahbaz.recyclerviewmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class MoviesViewModel(
    private val moviesRepositroy: MoviesRepositroy
) : ViewModel() {
    // TODO: Implement the ViewModel

    private lateinit var job: Job

    private val _movies = MutableLiveData<List<Movies>>()

    val movies: LiveData<List<Movies>>
        get() = _movies

    fun getMovies() {

        job = Corotunies.ioThenMain(
            { moviesRepositroy.getMovies() },
            { _movies.value = it }
        )


    }

    override fun onCleared() {
        super.onCleared()

        if (::job.isInitialized) job.cancel()
    }
}
