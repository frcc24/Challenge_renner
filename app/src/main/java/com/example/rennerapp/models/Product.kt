package com.example.rennerapp.models
import androidx.annotation.DrawableRes
import java.io.Serializable

data class Product  (
    var name: String,
    var price: Double,
    var description: String,
    @DrawableRes var icon: Int,
    var colors: List<String>,
    var size: List<String>
) : Serializable