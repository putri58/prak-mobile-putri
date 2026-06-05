package com.example.putriapps.data.api

import com.example.putriapps.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}