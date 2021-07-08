package com.netlify.joblink.model

import com.google.gson.annotations.SerializedName

class RegisterFreelancerModel(
    var name: String,
    var gender: String,
    var image: String,

    @SerializedName("birth_date")
    var birthDate: String,
    var email: String,
    var cpf: String,
    var password: String,
    var address: String
)