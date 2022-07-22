package com.netlify.joblink.api

import android.content.Context
import com.netlify.joblink.api.UrlApi.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitApi {

    companion object {
        fun <T> getRetrofit(clazz: Class<T>, context: Context): T {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient(context))
                .build()

            return retrofit.create(clazz)
        }

        private fun httpClient(context: Context?): OkHttpClient {
            return OkHttpClient.Builder()
                .readTimeout(0, TimeUnit.SECONDS)
                .connectTimeout(0, TimeUnit.SECONDS)
                .addInterceptor(AuthInterceptor(context))
                .build()
        }
    }
}