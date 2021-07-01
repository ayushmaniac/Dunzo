package com.dunzo.project.data.remote

import com.dunzo.project.data.local.model.Photos
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class PhotoResponse(
    @SerializedName("photos")
    @Expose
    var photos: Photos? = null,

    @SerializedName("stat")
    @Expose
    var stat: String? = null
)

