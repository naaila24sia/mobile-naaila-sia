package com.example.naailaapps.Data.api

import com.example.naailaapps.Data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}