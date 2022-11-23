package com.bestemorgul.coffeeapp.data.model

import android.content.ClipData
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.squareup.moshi.Json

@Parcelize
data class CoffeeTypes (val id: Int,
                        val description: String,
                        val title: String,
                        val ingredients: List<String>,
                        @Json(name = "image") val imageUrl: String ) : Parcelable
