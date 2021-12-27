package com.example.sberbanktest.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Route(
    val audio: String,
    val galleries: List<Gallery>,
    val media: List<Media>,
    val points: List<Point>,
    val textContents: List<TextContent>,
    val title: String,
    val type: String
) : Parcelable