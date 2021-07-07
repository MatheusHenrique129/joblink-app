package com.netlify.joblink.api.calls

import com.netlify.joblink.model.PublishModel
import com.netlify.joblink.model.RegisterClientModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface PublishCall {

    @Headers("Content-Type: application/json")
    @POST("posts")
    fun addPost(@Body publish: PublishModel): Call<PublishModel>
}