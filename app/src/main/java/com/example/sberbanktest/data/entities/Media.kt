package com.example.sberbanktest.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Media(
    val caption: String,
    val ordering: Int,
    val type: String,
    val value: String
) : Parcelable