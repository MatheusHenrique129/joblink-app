package com.netlify.joblink.api.calls

import com.netlify.joblink.model.LoginResponseModel
import com.netlify.joblink.model.UserLoginModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserSessionCall {

    @POST("sessions")
    fun login(@Body user: UserLoginModel): Call<LoginResponseModel>
}