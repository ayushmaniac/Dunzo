package com.dunzo.project.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "photos_table")
data class Photo (

    @SerializedName("id")
    @Expose
    @PrimaryKey
    var id: String = "",

    @SerializedName("owner")
    @Expose
    var owner: String? = null,

    @SerializedName("secret")
    @Expose
    var secret: String? = null,

    @SerializedName("server")
    @Expose
    var server: String? = null,

    @SerializedName("farm")
    @Expose
    var farm: Int? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("ispublic")
    @Expose
    var ispublic: Int? = null,

    @SerializedName("isfriend")
    @Expose
    var isfriend: Int? = null,

    @SerializedName("isfamily")
    @Expose
    var isfamily: Int? = null
)