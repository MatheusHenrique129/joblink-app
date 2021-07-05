package com.netlify.joblink.api.calls

import com.netlify.joblink.model.FreelancerModel
import retrofit2.Call
import retrofit2.http.GET

interface FreelancersCall {

    @GET("/freelancers")
    fun getFreelancers(): Call<List<FreelancerModel>>
}