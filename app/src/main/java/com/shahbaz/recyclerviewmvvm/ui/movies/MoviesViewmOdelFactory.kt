package com.shahbaz.recyclerviewmvvm.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shahbaz.recyclerviewmvvm.data.repositories.MoviesRepositroy

class MoviesViewmOdelFactory(
    private val repositroy: MoviesRepositroy

) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(repositroy) as T
    }
}