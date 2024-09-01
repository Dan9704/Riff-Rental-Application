import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Instrument(
    val name: String,
    val rating: Float,
    val type: String,
    val pricePerMonth: Int,
    val imageResId: Int
) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }
}
