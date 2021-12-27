package com.example.sberbanktest.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TextContent(
    val ordering: Int,
    val type: String,
    val value: String
) : Parcelable