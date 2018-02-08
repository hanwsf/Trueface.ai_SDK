package ai.trueface.sdk.models

import android.os.Parcel
import android.os.Parcelable

class SpoofDetectionRequest(internal val img: String) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
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
