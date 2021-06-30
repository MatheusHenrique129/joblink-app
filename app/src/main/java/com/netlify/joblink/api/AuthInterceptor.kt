package com.netlify.joblink.api

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor(context: Context?) : Interceptor {
    private val sessionManager = SessionManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder: Request.Builder = chain.request().newBuilder()

        sessionManager.fethAuthToken()?.let {
            requestBuilder.addHeader("Authorization", "Bearer ${sessionManager.fethAuthToken()}")
        }

        return chain.proceed(requestBuilder.build())
    }
}