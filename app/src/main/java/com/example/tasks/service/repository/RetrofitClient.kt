package com.example.tasks.service.repository

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor(){
    //padrão singleton

    companion object{
        private lateinit var retrofit: Retrofit
        private val baseurl = "http://devmasterteam.com/CursoAndroidAPI/"

        private fun getRetrofitInstance() : Retrofit{
            val httpClient = OkHttpClient.Builder()

            if(!::retrofit.isInitialized){
                retrofit = Retrofit.Builder()
                    .baseUrl(baseurl)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
        fun <S> createService(serviceClass: Class<S>) : S{
            return getRetrofitInstance().create(serviceClass)
        }
    }
}