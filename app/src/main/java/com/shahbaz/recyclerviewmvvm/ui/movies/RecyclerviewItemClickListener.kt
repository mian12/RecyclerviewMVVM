package com.shahbaz.recyclerviewmvvm.ui.movies

import android.view.View
import com.shahbaz.recyclerviewmvvm.data.models.Movies

interface RecyclerviewItemClickListener {

    fun onRecyclerviewItemClick(view:View,movies: Movies)
}