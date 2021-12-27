package com.example.sberbanktest.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gallery(
    val caption: String? = null,
    val ordering: Int,
    val type: String,
    val value: List<String>
) : Parcelable