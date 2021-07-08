package com.netlify.joblink.model

import com.google.gson.annotations.SerializedName

data class PublishModel(
    var title: String,
    var description: String,
    var urgency: String?,
    var image: String?,
    var category: String?,
    var attendance: String?,
    @SerializedName("is_announcement")
    var isAnnouncement: String?
)