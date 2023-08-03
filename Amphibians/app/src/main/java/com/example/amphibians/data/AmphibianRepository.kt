package com.example.amphibians.data

import com.example.amphibians.network.AmphibianApiService

interface AmphibianRepository{
    suspend fun getAmphibians(): List<AmphibianData>
}

class NetworkAmphibianRepository(private val amphibianApiService: AmphibianApiService): AmphibianRepository{
    override suspend fun getAmphibians(): List<AmphibianData> {
        return amphibianApiService.getAmphibians()
    }
}