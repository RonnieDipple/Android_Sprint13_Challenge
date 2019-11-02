package com.example.simple_sprint13_challenge.Model

import com.google.gson.annotations.SerializedName

data class MakeUpData(
                  val brand: String,
                  val price: String,
                  val rating: Int,
                  val image_link: String)