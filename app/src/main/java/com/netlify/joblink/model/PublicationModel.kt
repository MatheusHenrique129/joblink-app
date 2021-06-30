package com.netlify.joblink.model

import com.google.gson.annotations.SerializedName

data class PublicationModel(
    var id: Long,
    var title: String = "",
    var profission: String = "",
    var description: String = "",
    @SerializedName("createdAt")
    var datePublication: String = "",
    var image: String = "",
    var urgency: Int = 0,
    var attendance: Boolean,
    @SerializedName("is_announcement")
    var is_announcement: Int = 1,
    var freelancerNote: Float = 1.0f,
    @SerializedName("User")
    var userModel : UserModel
    //@SerializedName("Categories")
    //var categories: ProfissionModel
)