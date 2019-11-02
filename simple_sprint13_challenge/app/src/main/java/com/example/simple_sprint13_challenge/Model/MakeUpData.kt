package com.example.simple_sprint13_challenge.Model

import com.google.gson.annotations.SerializedName

data class MakeUpData( @SerializedName("brand")
                  val brand: String,
                  @SerializedName("name")
                  val name: String,
                  @SerializedName("price")
                  val price: String,
                  @SerializedName("rating")
                  val rating: Int,
                  @SerializedName("api_featured_image")
                  val imageLink: String)