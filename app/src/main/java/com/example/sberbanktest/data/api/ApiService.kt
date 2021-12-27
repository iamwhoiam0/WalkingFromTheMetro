package com.example.sberbanktest.data.api

import com.example.sberbanktest.data.entities.WalkListData
import com.example.sberbanktest.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

//    @Headers(
//        "accept: application/json",
//    )
    @GET(Constants.API_EXCURSION)
    suspend fun getWalkList(): Response<WalkListData>
}