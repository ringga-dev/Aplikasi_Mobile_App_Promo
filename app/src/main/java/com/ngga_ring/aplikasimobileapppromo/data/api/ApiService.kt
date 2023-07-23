package com.ngga_ring.aplikasimobileapppromo.data.api

import com.ngga_ring.aplikasimobileapppromo.data.models.PromoModels
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("promos")
    suspend fun getDataPage(
    ): Response<List<PromoModels>>
}

