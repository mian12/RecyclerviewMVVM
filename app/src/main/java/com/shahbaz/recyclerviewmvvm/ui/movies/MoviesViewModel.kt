package com.shahbaz.recyclerviewmvvm.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shahbaz.recyclerviewmvvm.data.models.Movies
import com.shahbaz.recyclerviewmvvm.data.repositories.MoviesRepositroy
import com.shahbaz.recyclerviewmvvm.utils.Corotunies
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
