package au.edu.swin.sdm.riffrentalapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Instrument(
    val name: String,
    val rating: Float,
    val type: String,
    val pricePerMonth: Int,
    val imageUrl: String
) : Parcelable
