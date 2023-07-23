package com.ngga_ring.aplikasimobileapppromo.data.repository


import com.ngga_ring.aplikasimobileapppromo.data.api.ApiService
import com.ngga_ring.aplikasimobileapppromo.data.api.Resource
import com.ngga_ring.aplikasimobileapppromo.data.models.PromoModels
import javax.inject.Inject

class PromoRepository @Inject constructor(
    private val apiService: ApiService,
) {
    suspend fun getData(): Resource<List<PromoModels>> {
        return try {
            val response = apiService.getDataPage()
            if (response.isSuccessful) {
                val userResponse = response.body()
                Resource.success(userResponse)
            } else {
                Resource.error("Data failed")
            }
        } catch (e: Exception) {
            Resource.error(e.localizedMessage ?: "Unknown error occurred")
        }
    }
}