package com.example.sberbanktest.presentation.di.module

import android.content.Context
import com.example.sberbanktest.data.api.ApiHelper
import com.example.sberbanktest.data.api.ApiHelperImpl
import com.example.sberbanktest.data.api.ApiService
import com.example.sberbanktest.data.repository.MainRepository
import com.example.sberbanktest.presentation.viewModel.MainViewModel
import com.example.sberbanktest.utils.Constants
import com.example.sberbanktest.utils.NetworkHelper
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

val mainModule = module{

    single { provideRetrofit(Constants.BASE_URL) }
    factory { provideApiService(get()) }
    single { provideNetworkHelper(androidContext()) }

    factory<ApiHelper> {
        return@factory ApiHelperImpl(get())
    }

    single {
        MainRepository(get())
    }

    viewModel {
        MainViewModel(get(), get())
    }
}

private fun provideNetworkHelper(context: Context) = NetworkHelper(context)

private fun provideRetrofit(BASE_URL: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        //.addConverterFactory(ScalarsConverterFactory.create())
        .build()
}

private fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)