package com.example.sberbanktest.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthorCompany(
    val description: String,
    val img: String,
    val title: String
) : Parcelable