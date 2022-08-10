package com.kiran.myapplication.data.remote

import com.google.gson.annotations.SerializedName

data class StarWarsPeople(

    @SerializedName("birth_year")
    val birthYear: String,

    @SerializedName("name")
    val name: String
)
