package com.netlify.joblink.api.calls

import com.netlify.joblink.model.PublicationModel
import retrofit2.Call
import retrofit2.http.GET

interface FeedCall {

    @GET("feed")
    fun getPublication(): Call<List<PublicationModel>>
}