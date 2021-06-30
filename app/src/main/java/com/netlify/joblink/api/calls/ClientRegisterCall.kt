package com.netlify.joblink.api.calls

import com.netlify.joblink.model.RegisterClientModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ClientRegisterCall {

    @Headers("Content-Type: application/json")
    @POST("clients")
    fun addClient(@Body register: RegisterClientModel): Call<RegisterClientModel>
}