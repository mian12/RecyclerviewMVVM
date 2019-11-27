package com.shahbaz.recyclerviewmvvm.data.repositories

import com.shahbaz.recyclerviewmvvm.data.network.MoviesApi

class MoviesRepositroy(
   private  val api: MoviesApi
) : SafeApiRequest()
{

    suspend fun getMovies()=apiRequest{api.getMovies()}
}