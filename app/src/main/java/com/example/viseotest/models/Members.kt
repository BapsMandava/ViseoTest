package com.example.viseotest.models

import com.google.gson.annotations.SerializedName

data class Data (

    @SerializedName("_id") val id : String,
    @SerializedName("company") val company : String,
    @SerializedName("website") val website : String,
    @SerializedName("logo") val logo : String,
    @SerializedName("about") val about : String,
    @SerializedName("members") val members : List<Members>
)

data class Members (

    @SerializedName("_id") val id : String,
    @SerializedName("age") val age : Int,
    @SerializedName("name") val name : Name,
    @SerializedName("email") val email : String,
    @SerializedName("phone") val phone : String
)

data class Name (

    @SerializedName("first") val first : String,
    @SerializedName("last") val last : String
)