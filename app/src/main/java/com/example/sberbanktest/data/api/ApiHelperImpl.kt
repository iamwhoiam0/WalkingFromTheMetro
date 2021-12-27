package com.example.sberbanktest.data.api

import com.example.sberbanktest.data.entities.WalkListData
import retrofit2.Response

class ApiHelperImpl (private val apiService: ApiService) : ApiHelper {

    override suspend fun getWalkList(): Response<WalkListData> = apiService.getWalkList()

}