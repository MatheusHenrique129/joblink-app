package com.netlify.joblink.api.calls

import com.netlify.joblink.model.ProfessionModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfessionCall {

    @GET("professions")
    fun getProfession(): Call<List<ProfessionModel>>

    @GET("professions/{id}")
    fun getProfessionId(@Path("id") id: Long): Call<List<ProfessionModel>>
}