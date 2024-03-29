package com.shahbaz.recyclerviewmvvm.data.network

import com.shahbaz.recyclerviewmvvm.data.models.Movies
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesApi {


    @GET("movies")
    suspend fun getMovies(): Response<List<Movies>>


    companion object {

        operator fun invoke(): MoviesApi {

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.simplifiedcoding.in/course-apis/recyclerview/")
                .build()
                .create(MoviesApi::class.java)
        }
    }
}