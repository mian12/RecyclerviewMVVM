package com.shahbaz.recyclerviewmvvm

class MoviesRepositroy(
   private  val api: MoviesApi
) : SafeApiRequest()
{

    suspend fun getMovies()=apiRequest{api.getMovies()}
}