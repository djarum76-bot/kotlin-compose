package com.example.amphibians.network

import com.example.amphibians.data.AmphibianData
import retrofit2.http.GET

interface AmphibianApiService {
    @GET("amphibians?hl=id")
    suspend fun getAmphibians(): List<AmphibianData>
}