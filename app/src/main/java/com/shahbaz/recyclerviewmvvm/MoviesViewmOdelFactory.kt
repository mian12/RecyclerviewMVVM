package com.shahbaz.recyclerviewmvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MoviesViewmOdelFactory(
    private val repositroy: MoviesRepositroy

) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(repositroy) as T
    }
}