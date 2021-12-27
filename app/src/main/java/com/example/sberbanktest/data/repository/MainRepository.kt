package com.example.sberbanktest.data.repository

import com.example.sberbanktest.data.api.ApiHelper

class MainRepository (private val apiHelper: ApiHelper){

    suspend fun getWalkList() = apiHelper.getWalkList()

}