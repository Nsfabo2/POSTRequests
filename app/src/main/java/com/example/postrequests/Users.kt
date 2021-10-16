package com.example.postrequests

import com.google.gson.annotations.SerializedName

class Users : ArrayList<UserItem>()

data class UserItem (

    @SerializedName("location")
    val location: String,

    @SerializedName("name")
    val name: String
)