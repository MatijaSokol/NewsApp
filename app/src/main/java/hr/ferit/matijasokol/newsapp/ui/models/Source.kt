package hr.ferit.matijasokol.newsapp.ui.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Source(
    val id: @RawValue Any?,
    val name: String
) : Parcelable