package com.dunzo.project.data.local.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Photos (
    @SerializedName("page")
    @Expose
    var page: Int? = null,

    @SerializedName("pages")
    @Expose
    var pages: Int? = null,

    @SerializedName("perpage")
    @Expose
    var perpage: Int? = null,

    @SerializedName("total")
    @Expose
    var total: Int? = null,

    @Ignore
    @SerializedName("photo")
    @Expose
    var photo: List<Photo>? = null
)