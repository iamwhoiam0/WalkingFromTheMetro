package com.example.sberbanktest.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val authorCompany: AuthorCompany,
    val authors: List<Author>,
    val description: String,
    val duration: Int,
    val id: Int,
    val img: String,
    val routes: ArrayList<Route>,
    val shortDescription: String?,
    val title: String,
    val type: String
) : Parcelable