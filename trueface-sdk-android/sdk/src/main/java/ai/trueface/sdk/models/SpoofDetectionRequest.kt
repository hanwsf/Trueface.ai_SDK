package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SpoofDetectionRequest() : Parcelable {

    @SerializedName("img")
    @Expose
    var img: String? = null

    constructor(parcel: Parcel) : this() {
        img = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SpoofDetectionRequest> {
        override fun createFromParcel(parcel: Parcel): SpoofDetectionRequest {
            return SpoofDetectionRequest(parcel)
        }

        override fun newArray(size: Int): Array<SpoofDetectionRequest?> {
            return arrayOfNulls(size)
        }
    }

}
