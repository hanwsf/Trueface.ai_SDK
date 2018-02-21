package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Face() : Parcelable {

    @SerializedName("bounding_box")
    @Expose
    var boundingBox: List<Double>? = null

    @SerializedName("points")
    @Expose
    var points: List<Int>? = null

    @SerializedName("landmarks")
    @Expose
    var landmarks: List<Any>? = null

    constructor(parcel: Parcel) : this()

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Face> {
        override fun createFromParcel(parcel: Parcel): Face {
            return Face(parcel)
        }

        override fun newArray(size: Int): Array<Face?> {
            return arrayOfNulls(size)
        }
    }

}
