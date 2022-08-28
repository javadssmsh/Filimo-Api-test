package com.example.data.model

import com.google.gson.annotations.SerializedName

data class AttributesResponse(

    val descr: String,
    val imdb_rate: String,
    val movie_title: String,
    val movie_title_en: String,
    @SerializedName("pic")
    val pic: PicResponse
)