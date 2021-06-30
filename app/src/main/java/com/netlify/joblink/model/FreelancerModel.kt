package com.netlify.joblink.model

import com.google.gson.annotations.SerializedName

data class FreelancerModel(
    var id: Long,
    var name: String,
    var email: String,
    @SerializedName("birth_date")
    var birthDate: String,
    @SerializedName("phone_number")
    var PhoneNumber: String,
    var image: String? = "",
    var gender: String,
    var address: String,
    var cpf: String,
    @SerializedName("is_freelancer")
    var isFreelancer: Long
)