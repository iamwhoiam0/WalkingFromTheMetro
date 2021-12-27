package com.example.sberbanktest.data.api

import com.example.sberbanktest.data.entities.WalkListData
import retrofit2.Response

interface ApiHelper {

    suspend fun getWalkList(): Response<WalkListData>

}