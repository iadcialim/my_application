package com.kiran.myapplication.data.remote

import retrofit2.Response
import retrofit2.http.GET

/**
 * My Application
 *
 * Created by Kiran Shaw on 03-08-2022
 */

interface APIService {
    @GET("people")
    suspend fun getPeopleList(): Response<List<StarWarsPeople>>
}