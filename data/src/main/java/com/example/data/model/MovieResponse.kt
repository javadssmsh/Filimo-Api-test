package com.example.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("attributes")
    val attributes: AttributesResponse,
    val id: Int,
    val type: String
)